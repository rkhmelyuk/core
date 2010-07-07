package com.prutsoft.core.state.machine;

import com.prutsoft.core.state.machine.conditions.TransitionCondition;
import com.prutsoft.core.asserts.ArgumentAssert;

import java.io.Serializable;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 16 $
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
