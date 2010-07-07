package com.prutsoft.core.test.state.machine;

import com.prutsoft.core.state.machine.StateMachine;
import com.prutsoft.core.state.machine.State;
import com.prutsoft.core.state.machine.StateAction;
import com.prutsoft.core.state.machine.Transition;
import com.prutsoft.core.test.BaseTestCase;
import com.prutsoft.core.code.Warnings;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 16 $
 * @since 2008-8-25 18:27
 */
public class StateTestCase extends BaseTestCase {

    StateMachine machine;

    public void setUp() {
        machine = new StateMachine();
    }

    @SuppressWarnings(Warnings.Unchecked)
    public void testCreateState() {
        State state = new State(10);
        assertTrue((Integer)state.getState() == 10);
        assertTrue(state.getEntryAction() == null);
        assertTrue(state.getExitAction() == null);

        state = new State(10, null);
        assertTrue((Integer)state.getState() == 10);
        assertTrue(state.getEntryAction() == null);
        assertTrue(state.getExitAction() == null);

        state = new State(10, null, null);
        assertTrue((Integer)state.getState() == 10);
        assertTrue(state.getEntryAction() == null);
        assertTrue(state.getExitAction() == null);

        StateAction action = new StateAction() {
            public void run(State state, Transition transition) {
                // do nothing
            }
        };

        state = new State(10, action, null);
        assertTrue((Integer)state.getState() == 10);
        assertTrue(state.getEntryAction() == action);
        assertTrue(state.getExitAction() == null);

        state = new State(10, action, action);
        assertTrue((Integer)state.getState() == 10);
        assertTrue(state.getEntryAction() == action);
        assertTrue(state.getExitAction() == action);

        state = new State(10, null, action);
        assertTrue((Integer)state.getState() == 10);
        assertTrue(state.getEntryAction() == null);
        assertTrue(state.getExitAction() == action);

        state = new State(10, action);
        assertTrue((Integer)state.getState() == 10);
        assertTrue(state.getEntryAction() == action);
        assertTrue(state.getExitAction() == null);
    }

    @SuppressWarnings(Warnings.Unchecked)
    public void testCreateNullState() {
        State state;
        try {
            state = new State(null);
            fail("Created state");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }

        try {
            state = new State(null, null, null);
            fail("Created state");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }

        try {
            state = new State(null, null);
            fail("Created state");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }
    }

    public void testAddNullState() {
        try {
            machine.addState(null);
            fail("Null state is added.");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }
    }

    public void testAddState() {
        State state = new State<Integer>(10);
        State rState = machine.addState(state);

        assertSame(state, rState);
        int count = 0;
        for (State eachState : machine.getStates()) {
            if (eachState.equals(state)) {
                count++;
            }
        }
        assertEquals("Added more than 1 copy of state", 1, count);
    }

    public void testAddDuplicateState() {
        State state1 = new State<Integer>(10);
        State state2 = new State<Integer>(10);

        machine.addState(state1);

        try {
            machine.addState(state2);
            fail("Duplicate state is added.");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }

        int count = 0;
        for (State eachState : machine.getStates()) {
            if (eachState.equals(state1)) {
                count++;
            }
        }
        assertEquals("Added duplicate copy of state", 1, count);
    }

    public void testAddStateAfterStart() {
        machine.setInitialState(
                machine.addState(new State<String>("a"))
        );
        machine.start();

        try {
            machine.addState(new State<String>("b"));
            fail("Added state after state machine start.");
        }
        catch (IllegalStateException e) {
            // it is OK
        }
    }

    public void testAddStateAfterFinish() {
        machine.setInitialState(
                machine.addState(new State<String>("a"))
        );
        machine.start();
        machine.finish();

        try {
            machine.addState(new State<String>("b"));
            fail("Added state after state machine start.");
        }
        catch (IllegalStateException e) {
            // it is OK
        }
    }

    public void testAddAcceptableState() {
        State state = machine.addState(new State("test"));
        machine.addAcceptableState(state);

        assertTrue(machine.getAcceptableStates().contains(state));
    }

    public void testAddNullAcceptableState() {
        try {
            machine.addAcceptableState(null);
            fail("Added null acceptable state");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }
    }

    public void testSetInitialState() {
        State state = machine.addState(new State(12));
        assertTrue(machine.setInitialState(state));
        assertSame(machine.getInitialState(), state);
    }

    public void testSetNullInitialState() {
        try {
            machine.setInitialState(null);
            fail("Set null initial state");
        }
        catch (IllegalArgumentException e) {
            // it is OK
        }
    }

    public void testSetWrongInitialState() {
        assertFalse(machine.setInitialState(new State(0)));
    }
}
