package com.khmelyuk.core.state.machine.conditions;

import java.io.Serializable;

/**
 * @author Ruslan Khmelyuk
 * @since 2008-8-24 22:13
 */
public class ElseCondition implements TransitionCondition {

    public boolean match(Serializable value) {
        return true;
    }
}
