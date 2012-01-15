package com.khmelyuk.core.state.machine;

import com.khmelyuk.core.asserts.ArgumentAssert;
import com.khmelyuk.core.state.machine.conditions.TransitionCondition;

import java.io.Serializable;

/**
 * @author Ruslan Khmelyuk
 * @since 2008-8-23 18:13
 */
public class Transition implements Serializable {

    private TransitionCondition condition;
    private TransitionAction action;

    public Transition(TransitionCondition condition) {
        ArgumentAssert.isNotNull(condition, "Condition cannot be null.");
        this.condition = condition;
        this.action = null;
    }

    public Transition(TransitionCondition condition, TransitionAction action) {
        ArgumentAssert.isNotNull(condition, "Condition cannot be null.");
        this.condition = condition;
        this.action = action;
    }

    public TransitionCondition getCondition() {
        return condition;
    }

    public TransitionAction getAction() {
        return action;
    }
}
