package com.khmelyuk.core.state.machine.conditions;

import java.io.Serializable;

/**
 * @author Ruslan Khmelyuk
 * @since 2008-8-24 22:5
 */
public interface TransitionCondition extends Serializable {

    boolean match(Serializable value);

}
