package com.khmelyuk.core.state.machine;

import java.io.Serializable;

/**
 * The action made while entring or exiting state.
 * It is serializable, so the serializable fields can be stored while
 * serializing state.
 *
 * @author Ruslan Khmelyuk
 * @since 2008-8-23 18:12
 */
public interface StateAction extends Serializable {

    /**
     * Execute the action for specified state and transition.
     * @param state the action state.
     * @param transition the transition (in or out).
     */
    void run(State state, Transition transition);
}
