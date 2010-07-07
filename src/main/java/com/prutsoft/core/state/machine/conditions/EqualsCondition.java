package com.prutsoft.core.state.machine.conditions;

import com.prutsoft.core.utils.ObjectUtils;

import java.io.Serializable;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 16 $
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
