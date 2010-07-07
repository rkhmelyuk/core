package com.prutsoft.core.test.state.machine;

import com.prutsoft.core.test.BaseTestCase;
import com.prutsoft.core.state.machine.StateMachine;
import com.prutsoft.core.state.machine.Transition;
import com.prutsoft.core.state.machine.TransitionAction;
import com.prutsoft.core.state.machine.State;
import com.prutsoft.core.state.machine.conditions.EqualsCondition;
import com.prutsoft.core.state.machine.conditions.TransitionCondition;
import com.prutsoft.core.Pair;

import java.util.Map;
import java.util.Collection;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 16 $
 * @since 2008-8-25 19:20
 */
public class TransitionTestCase extends BaseTestCase {

    StateMachine machine;

    public void setUp() {
        machine = new StateMachine();
    }

    public void testCreateTransition() {
        TransitionCondition condition = new EqualsCondition(10);
        TransitionAction action = new TransitionAction() {
            public void run(Transition transition, State from, State to) {
                // nothing
            }
        };

        Transition transition = new Transition(condition, null);
        assertEquals(transition.getCondition(), condition);

        transition = new Transition(condition, action);
        assertEquals(transition.getCondition(), condition);
        assertEquals(transition.getAction(), action);
    }

    public void testCreateTransitionWithNullCondition() {
        try {
            new Transition(null);
            fail("Transition with null condition is created.");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }

        try {
            new Transition(null, null);
            fail("Transition with null condition is created.");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }
    }

    public void testAddTransition() {
        State stateA = machine.addState(new State("a"));
        State stateB = machine.addState(new State("b"));

        TransitionCondition cond = new EqualsCondition("a");
        Transition transition = new Transition(cond);
        Transition trans = machine.addTransition(stateA, stateB, transition);
        assertNotNull(trans);
        assertSame(trans, transition);

        int count = 0;
        int otherStatesCount = 0;
        for (Map.Entry<Transition, Pair<State, State>> eachTransition :
                machine.getTransitionsWithStates(trans).entrySet()) {
            if (eachTransition.getValue().getFirst().equals(stateA) &&
                eachTransition.getValue().getSecond().equals(stateB)) {
                count++;
            }
            else {
                otherStatesCount++;
            }
        }
        assertEquals("Added more than 1 copy of transition", 1, count);
        assertEquals("Added transition with other states", 0, otherStatesCount);
    }

    public void testAddDuplicateTransition() {
        State stateA = machine.addState(new State("a"));
        State stateB = machine.addState(new State("b"));

        TransitionCondition cond = new EqualsCondition("a");
        Transition transition = new Transition(cond);
        Transition trans = machine.addTransition(stateA, stateB, transition);
        try {
            machine.addTransition(stateA, stateB, transition);
            fail("Duplicate transition is added");
        }
        catch (IllegalStateException e) {
            // it is OK
        }
        machine.addTransition(stateB, stateA, transition);

        assertNotNull(trans);
        assertSame(trans, transition);

        int count = 0;
        int otherStatesCount = 0;
        for (Map.Entry<Transition, Pair<State, State>> eachTransition :
                machine.getTransitionsWithStates(trans).entrySet()) {
            if (eachTransition.getValue().getFirst().equals(stateA) &&
                eachTransition.getValue().getSecond().equals(stateB)) {
                count++;
            }
            else {
                otherStatesCount++;
            }
        }
        assertEquals("Added more than 1 copy of transition", 1, count);
        assertEquals("Added transition with other states", 0, otherStatesCount);
    }

    public void testAddTransitionWithNullStates() {
        State state = machine.addState(new State("a"));

        TransitionCondition cond = new EqualsCondition("a");
        Transition transition = new Transition(cond);
        try {
            machine.addTransition(null, state, transition);
            fail("Transition with null state was added.");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }

        try {
            machine.addTransition(state, null, transition);
            fail("Transition with null state was added.");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }

        try {
            machine.addTransition(null, null, transition);
            fail("Transition with null state was added.");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }
    }

    public void testAddNullTransition() {
        State stateA = machine.addState(new State("a"));
        State stateB = machine.addState(new State("b"));

        try {
            machine.addTransition(stateA, stateB, null);
            fail("Null transition was added");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }
    }

    public void testAddTransitionWithWrongStates() {
        State stateX = new State("x");
        State stateB = machine.addState(new State("b"));
        machine.addState(new State("a"));

        try {
            machine.addTransition(stateX, stateB, null);
            fail("Transition with wrong first state was added.");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }

        try {
            machine.addTransition(stateB, stateX, null);
            fail("Transition with wrong second state was added.");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }

        try {
            machine.addTransition(stateX, stateX, null);
            fail("Transition with wrong both states was added.");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }
    }

    public void testGetTransitions() {
        State stateA = machine.addState(new State("a"));
        State stateB = machine.addState(new State("b"));

        Transition t1 = new Transition(new EqualsCondition(1));
        Transition t2 = new Transition(new EqualsCondition(2));

        machine.addTransition(stateA, stateB, t1);
        machine.addTransition(stateA, stateB, t2);

        Collection<Transition> transitions = machine.getTransitions();

        assertEquals("Wrong size", transitions.size(), 2);
        assertTrue(transitions.contains(t1));
        assertTrue(transitions.contains(t2));
    }

    public void testGetTransitionsForEmptyMachine() {
        assertEquals("Wrong size", machine.getTransitions().size(), 0);
    }
}