package com.khmelyuk.core.state.machine.conditions;

import com.khmelyuk.core.utils.ObjectUtils;

import java.io.Serializable;

/**
 * @author Ruslan Khmelyuk
 * @since 2008-8-24 22:7
 */
public class EqualsCondition implements TransitionCondition {

    private final Serializable conditionValue;

    public EqualsCondition(Serializable conditionValue) {
        this.conditionValue = conditionValue;
    }

    public boolean match(Serializable value) {
        return ObjectUtils.equals(conditionValue, value);
    }
}
