package com.khmelyuk.core.state.machine;

import java.io.Serializable;

/**
 * @author Ruslan Khmelyuk
 * @since 2008-8-24 21:35
 */
public interface TransitionAction extends Serializable {

    void run(Transition transition, State from, State to);
}
