package com.prutsoft.core.test.state.machine;

import junit.framework.TestCase;
import com.prutsoft.core.state.machine.StateMachine;
import com.prutsoft.core.state.machine.State;
import com.prutsoft.core.state.machine.Transition;
import com.prutsoft.core.state.machine.TransitionAction;
import com.prutsoft.core.state.machine.conditions.EqualsCondition;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 16 $
 * @since 2008-8-24 22:21
 */
public class StateMachineTestCase extends TestCase {

    public void testSimple() {
        StateMachine machine = new StateMachine(10);

        State stateA = machine.addState(new State(12));
        State stateB = machine.addState(new State(45));
        machine.addTransition(stateA, stateB,
                new Transition(new EqualsCondition("a"), new TransitionAction() {
                    public void run(Transition transition, State from, State to) {
                        // do nothing
                    }
                })
        );
        machine.addTransition(stateB, stateA,
                new Transition(new EqualsCondition("b"), new TransitionAction() {
                    public void run(Transition transition, State from, State to) {
                        // do nothing
                    }
                })
        );

        machine.setInitialState(stateA);
        machine.addAcceptableState(stateB);

        machine.start();
        machine.input("a");
        machine.input("b");
        machine.input("a");
        machine.finish();

        assertTrue(machine.isSuccess());
        assertTrue((Integer)machine.getFinishState().getState() == 45);
    }
}
