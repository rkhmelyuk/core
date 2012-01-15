package com.khmelyuk.core.state.dirty;

import com.khmelyuk.core.BaseTestCase;

/**
 * Few tests for the <code>DirtyWrapper</code> class.
 *
 * @author Ruslan Khmelyuk
 * @since 2008-9-27 2:12
 */
public class DirtyWrapperTestCase extends BaseTestCase {

    public void testCreateEmptyDirtyWrapper() {
        DirtyWrapper<String> dirtyString = new DirtyWrapper<String>();

        assertNull(dirtyString.getValue());
        assertNotNull(dirtyString.getState());
        assertEquals(dirtyString.getState(), DirtyState.UNMODIFIED);
    }

    public void testCreateNotEmptyDirtyWrapper() {
        DirtyWrapper<String> dirtyString = new DirtyWrapper<String>("test", DirtyState.MODIFIED);

        assertEquals(dirtyString.getValue(), "test");
        assertEquals(dirtyString.getState(), DirtyState.MODIFIED);
    }

    public void testSetters() {
        DirtyWrapper<String> dirtyString = new DirtyWrapper<String>();

        //
        // 1.
        dirtyString.setValue("test");
        dirtyString.setState(DirtyState.ADDED);

        assertEquals(dirtyString.getValue(), "test");
        assertEquals(dirtyString.getState(), DirtyState.ADDED);

        try {
            dirtyString.setState(null);
            fail("State can't be null.");
        }
        catch (IllegalArgumentException e) {
            // find
        }

        assertEquals(dirtyString.getValue(), "test");
        assertEquals(dirtyString.getState(), DirtyState.ADDED);

    }

    public void testChanges() {
        DirtyWrapper<String> dirtyString = new DirtyWrapper<String>();

        //
        // 1.
        dirtyString.setValue("test");
        dirtyString.setState(DirtyState.ADDED);

        assertEquals(dirtyString.getValue(), "test");
        assertEquals(dirtyString.getState(), DirtyState.ADDED);

        //
        // 2.
        dirtyString.setValue(null);
        dirtyString.setState(DirtyState.REMOVED);

        assertNull(dirtyString.getValue());
        assertEquals(dirtyString.getState(), DirtyState.REMOVED);

        //
        // 3.
        dirtyString.setValue("strange");
        dirtyString.setState(DirtyState.UNMODIFIED);

        assertEquals(dirtyString.getValue(), "strange");
        assertEquals(dirtyString.getState(), DirtyState.UNMODIFIED);
    }

    public void testEquals() {
        DirtyWrapper<String> dirtyString1 = new DirtyWrapper<String>("test", DirtyState.ADDED);
        DirtyWrapper<String> dirtyString2 = new DirtyWrapper<String>("test1", DirtyState.ADDED);
        DirtyWrapper<String> dirtyString3 = new DirtyWrapper<String>("test", DirtyState.REMOVED);
        DirtyWrapper<String> dirtyString4 = new DirtyWrapper<String>("test", DirtyState.ADDED);

        assertTrue(dirtyString1.equals(dirtyString4));
        assertTrue(dirtyString4.equals(dirtyString1));
        assertFalse(dirtyString1.equals(dirtyString2));
        assertFalse(dirtyString2.equals(dirtyString1));
        assertFalse(dirtyString1.equals(dirtyString3));
        assertFalse(dirtyString3.equals(dirtyString1));
    }
}
