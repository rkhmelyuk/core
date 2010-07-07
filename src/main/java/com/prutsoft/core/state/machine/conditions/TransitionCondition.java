package com.prutsoft.core.state.machine.conditions;

import java.io.Serializable;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 16 $
 * @since 2008-8-24 22:5
 */
public interface TransitionCondition extends Serializable {

    boolean match(Serializable value);

}
