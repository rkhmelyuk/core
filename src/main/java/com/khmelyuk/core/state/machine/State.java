package com.khmelyuk.core.state.machine;

import com.khmelyuk.core.asserts.ArgumentAssert;
import com.khmelyuk.core.utils.ObjectUtils;

import java.io.Serializable;

/**
 * This class represents some type of state with entry and exit actions.
 * This class is serializable and saved state should be serializable too.
 * <br/>
 * Property state cannot be {@code null}.
 * Entry and exit actions can be {@code null}.
 *
 * @author Ruslan Khmelyuk
 * @since 2008-8-23 18:12
 */
public class State<T extends Serializable> implements Serializable {

    /**
     * The state.
     */
    private final T state;

    /**
     * Entry action for state.
     * If entry action is not null, then it will be invoked by state machine
     * when it will go into this state.
     */
    private final StateAction entryAction;

    /**
     * Exit action for state.
     * If exit action is not null, then it will be invoked by state machine
     * when it will go from this state.
     */
    private final StateAction exitAction;

    public State(T state) {
        ArgumentAssert.isNotNull(state, "State can't be null.");

        this.state = state;
        this.entryAction = null;
        this.exitAction = null;
    }

    public State(T state, StateAction entryAction, StateAction exitAction) {
        ArgumentAssert.isNotNull(state, "State can't be null.");

        this.state = state;
        this.entryAction = entryAction;
        this.exitAction = exitAction;
    }

    public State(T state, StateAction entryAction) {
        ArgumentAssert.isNotNull(state, "State can't be null.");

        this.state = state;
        this.entryAction = entryAction;
        this.exitAction = null;
    }

    public T getState() {
        return state;
    }

    public StateAction getEntryAction() {
        return entryAction;
    }

    public StateAction getExitAction() {
        return exitAction;
    }

    @Override
    public int hashCode() {
        return ObjectUtils.hashCode(state) ^ 19;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof State) {
            State other = (State) obj;
            return ObjectUtils.equals(this.state, other.state);
        }
        return false;
    }
}
