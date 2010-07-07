package com.prutsoft.core.state.machine;

import java.io.Serializable;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 16 $
 * @since 2008-8-25 18:38
 */
public interface StateChangeListener extends Serializable {

    void onChange(State fromState, State toState);
}
