package com.prutsoft.core.state.machine;

import java.io.Serializable;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 20 $
 * @since 2008-8-24 21:35
 */
public interface TransitionAction extends Serializable {

    void run(Transition transition, State from, State to);
}
