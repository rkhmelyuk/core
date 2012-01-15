package com.khmelyuk.core.state.machine;

import com.khmelyuk.core.Pair;
import com.khmelyuk.core.asserts.ArgumentAssert;
import com.khmelyuk.core.asserts.StateAssert;
import com.khmelyuk.core.state.machine.conditions.ElseCondition;
import com.khmelyuk.core.utils.ObjectUtils;

import java.io.Serializable;
import java.util.*;

/**
 * This is state machine. Supports for states with entry and exit actions,
 * transitions with actions and more then 1 finish states.
 * Also supports listeners.
 *
 * @author Ruslan Khmelyuk
 * @since 2008-8-23 18:12
 */
public class StateMachine implements Serializable {

    private List<State> states;
    private Map<Transition, Pair<State, State>> transitions;
    private List<State> acceptableStates = new ArrayList<State>();
    private List<StateChangeListener> changeListeners = new ArrayList<StateChangeListener>();

    private State initialState;
    private State currentState;
    private boolean inProgress = false;

    public StateMachine() {
        states = new ArrayList<State>();
        transitions = new HashMap<Transition, Pair<State, State>>();
    }

    public StateMachine(int size) {
        states = new ArrayList<State>(size);
        transitions = new HashMap<Transition, Pair<State, State>>(size * 4);
    }

    public State addState(State state) {
        ArgumentAssert.isNotNull(state, "Cannot add state, because it is null.");
        ArgumentAssert.isFalse(containsState(state), "Cannot add the duplicated state.");
        StateAssert.isNull(currentState, "State machine is started: you cannot add new states now.");
        return (states.add(state) ? state : null);
    }

    public Collection<State> getStates() {
        return Collections.unmodifiableCollection(states);
    }

    public Transition addTransition(State stateFrom, State stateTo, Transition transition) {
        ArgumentAssert.isNotNull(stateFrom, "State from cannot be null.");
        ArgumentAssert.isNotNull(stateTo, "State to cannot be null.");
        ArgumentAssert.isNotNull(transition, "Transition cannot be null.");

        ArgumentAssert.isTrue(containsState(stateFrom), "State from is not apart of state machine.");
        ArgumentAssert.isTrue(containsState(stateTo), "State to is not apart of state machine.");

        Map<Transition, Pair<State, State>> transitions = getTransitionsWithStates(transition);
        if (transitions.size() == 0) {
            this.transitions.put(transition, new Pair<State, State>(stateFrom, stateTo));
        }
        else {
            for (Pair<State, State> states : transitions.values()) {
                if (states.getFirst().equals(stateFrom) && states.getSecond().equals(stateTo)) {
                    StateAssert.fail("Cannot add duplicate transition. " +
                            "Such transition for such states already exists.");
                }
            }
        }
        return transition;
    }

    public Collection<Transition> getTransitions() {
        return Collections.unmodifiableCollection(transitions.keySet());
    }

    public Map<Transition, Pair<State, State>> getTransitionsWithStates() {
        return Collections.unmodifiableMap(transitions);
    }

    public Map<Transition, Pair<State, State>> getTransitionsWithStates(Transition transition) {
        Map<Transition, Pair<State, State>> result = new HashMap<Transition, Pair<State, State>>();
        for (Map.Entry<Transition, Pair<State, State>> eachTransition : transitions.entrySet()) {
            if (eachTransition.getKey().equals(transition)) {
                result.put(eachTransition.getKey(), eachTransition.getValue());
            }
        }
        return Collections.unmodifiableMap(result);
    }

    public State addAcceptableState(State state) {
        ArgumentAssert.isNotNull(state, "State cannot be null.");
        StateAssert.isTrue(containsState(state), "State cannot be add as acceptable, " +
                "because it is not in list of states");
        acceptableStates.add(state);
        return state;
    }

    public Collection<State> getAcceptableStates() {
        return Collections.unmodifiableCollection(acceptableStates);
    }

    public State getCurrentState() {
        return currentState;
    }

    public State getInitialState() {
        return initialState;
    }

    public boolean setInitialState(State state) {
        ArgumentAssert.isNotNull(state, "Initial state cannot be null.");
        StateAssert.isTrue(currentState == null, "Automate is started.");
        if (initialState == null || !initialState.equals(state)) {
            if (containsState(state)) {
                initialState = state;
                return true;
            }
        }
        return false;
    }

    public boolean containsState(State state) {
        for (State eachState : states) {
            if (eachState.equals(state)) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        StateAssert.isNotNull(initialState, "Initial state is not specified.");
        StateAssert.isNull(currentState, "Automate is started already.");
        currentState = initialState;
        inProgress = true;
    }

    public void finish() {
        StateAssert.isTrue(inProgress, "Automate is not in progress.");
        StateAssert.isNotNull(currentState, "Automate is not started yet.");
        inProgress = false;
    }

    public State input(Serializable input) {
        Map<Transition, State> transitions = getTransitionsForState(currentState);

        for (Map.Entry<Transition, State> eachTransition : transitions.entrySet()) {
            Transition transition = eachTransition.getKey();

            if (transition.getCondition().match(input)) {
                State nextState = eachTransition.getValue();
                if (currentState.getExitAction() != null) {
                    currentState.getExitAction().run(currentState, transition);
                }
                if (transition.getAction() != null) {
                    transition.getAction().run(transition, currentState, nextState);
                }
                if (nextState.getEntryAction() != null) {
                    nextState.getEntryAction().run(nextState, transition);
                }

                try {
                    notifyStateChangeListeners(currentState, nextState, transition);
                }
                finally {
                    currentState = nextState;
                }

                break;
            }
        }

        return currentState;
    }

    private Map<Transition, State> getTransitionsForState(State state) {

        //
        // An 'else condition' moved the end of the map.
        Map<Transition, State> result = new TreeMap<Transition, State>(new Comparator<Transition>() {
            public int compare(Transition left, Transition right) {
                if (left.getCondition() instanceof ElseCondition) {
                    return 1;
                }
                else if (right.getCondition() instanceof ElseCondition) {
                    return -1;
                }
                return 0;
            }
        });

        for (Map.Entry<Transition, Pair<State, State>> eachTransition : transitions.entrySet()) {
            State fromState = eachTransition.getValue().getFirst();
            if (fromState == state) {
                Transition transition = eachTransition.getKey();
                State endState = eachTransition.getValue().getSecond();
                result.put(transition,  endState);
            }
        }
        return result;
    }

    public State getFinishState() {
        if (!inProgress) {
            return currentState;
        }
        return null;
    }
    public boolean isSuccess() {
        return acceptableStates.contains(currentState);
    }

    public boolean isFailed() {
        return !isSuccess();
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public boolean isInState(Serializable state) {
        return ObjectUtils.equals(getCurrentState().getState(), state);
    }

    public boolean addStateChangeListener(StateChangeListener listener) {
        ArgumentAssert.isNotNull(listener, "Listener cannot be null.");
        return changeListeners.add(listener);
    }

    private void notifyStateChangeListeners(State stateFrom, State stateTo, Transition transition) {
        for (StateChangeListener listener : changeListeners) {
            listener.onChange(stateFrom, stateTo);
        }
    }
}
