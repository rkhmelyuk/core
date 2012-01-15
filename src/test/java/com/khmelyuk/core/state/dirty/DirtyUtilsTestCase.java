package com.khmelyuk.core.state.dirty;

import com.khmelyuk.core.BaseTestCase;
import com.khmelyuk.core.utils.collections.ListUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The tests for <code>DirtyUtils</code>.
 * 
 * @author Ruslan Khmelyuk
 * @since 2008-09-27 02:25
 */
public class DirtyUtilsTestCase extends BaseTestCase {

    public void testWrapValues1() {
        Collection<Integer> values = ListUtils.listOf(1, 2, 45, 23, 12);
        Collection<DirtyWrapper<Integer>> wrapped = DirtyUtils.wrapValues(values);

        assertNotNull(wrapped);
        assertEquals(wrapped.size(), values.size());

        for (DirtyWrapper<Integer> anElem : wrapped) {
            assertTrue(values.contains(anElem.getValue()));
            assertEquals(anElem.getState(), DirtyState.UNMODIFIED);
        }
    }

    public void testWrapValues2() {
        Collection<Integer> values = ListUtils.listOf(1, 2, 45, 23, 12);
        Collection<DirtyWrapper<Integer>> wrapped = DirtyUtils.wrapValues(values, DirtyState.ADDED);

        assertNotNull(wrapped);
        assertEquals(wrapped.size(), values.size());

        for (DirtyWrapper<Integer> anElem : wrapped) {
            assertTrue(values.contains(anElem.getValue()));
            assertEquals(anElem.getState(), DirtyState.ADDED);
        }
    }

    public void testWrap1Null() {
        try {
            DirtyUtils.wrapValues(null);
            unexpected("null can't be wrapped.");
        }
        catch (IllegalArgumentException e) {
            // that's OK 
        }
        catch (Exception e) {
            unexpectedException(e.getMessage());
        }
    }

    public void testWrap2Null() {
        try {
            DirtyUtils.wrapValues(null, DirtyState.ADDED);
            unexpected("null can't be wrapped.");
        }
        catch (IllegalArgumentException e) {
            // that's OK
        }
        catch (Exception e) {
            unexpectedException(e.getMessage());
        }

        try {
            DirtyUtils.wrapValues(ListUtils.listOf(10), null);
            unexpected("state can't be null.");
        }
        catch (IllegalArgumentException e) {
            // that's OK
        }
        catch (Exception e) {
            unexpectedException(e.getMessage());
        }
    }

    public void testGetValuesWithStateFromCollection() {
        Collection<DirtyWrapper<Integer>> wrapped = new ArrayList<DirtyWrapper<Integer>>();
        wrapped.add(new DirtyWrapper<Integer>(1, DirtyState.ADDED));
        wrapped.add(new DirtyWrapper<Integer>(2, DirtyState.ADDED));
        wrapped.add(new DirtyWrapper<Integer>(3, DirtyState.REMOVED));
        wrapped.add(new DirtyWrapper<Integer>(4, DirtyState.MODIFIED));
        wrapped.add(new DirtyWrapper<Integer>(5, DirtyState.MODIFIED));

        Collection<Integer> addedOnly = DirtyUtils.getValuesWithState(wrapped, DirtyState.ADDED);
        Collection<Integer> removedOnly = DirtyUtils.getValuesWithState(wrapped, DirtyState.REMOVED);
        Collection<Integer> modifiedOnly = DirtyUtils.getValuesWithState(wrapped, DirtyState.MODIFIED);
        Collection<Integer> unmodifiedOnly = DirtyUtils.getValuesWithState(wrapped, DirtyState.UNMODIFIED);

        assertNotNull(addedOnly);
        assertEquals(addedOnly.size(), 2);
        assertTrue(addedOnly.contains(1));
        assertTrue(addedOnly.contains(2));

        assertNotNull(removedOnly);
        assertEquals(removedOnly.size(), 1);
        assertTrue(removedOnly.contains(3));

        assertNotNull(modifiedOnly);
        assertEquals(modifiedOnly.size(), 2);
        assertTrue(modifiedOnly.contains(4));
        assertTrue(modifiedOnly.contains(5));

        assertNotNull(unmodifiedOnly);
        assertEquals(unmodifiedOnly.size(), 0);
    }

    public void testGetValuesWithStateFromMap() {
        Map<Integer, DirtyState> wrapped = new HashMap<Integer, DirtyState>();
        wrapped.put(1, DirtyState.ADDED);
        wrapped.put(2, DirtyState.ADDED);
        wrapped.put(3, DirtyState.REMOVED);
        wrapped.put(4, DirtyState.MODIFIED);
        wrapped.put(5, DirtyState.MODIFIED);

        Collection<Integer> addedOnly = DirtyUtils.getValuesWithState(wrapped, DirtyState.ADDED);
        Collection<Integer> removedOnly = DirtyUtils.getValuesWithState(wrapped, DirtyState.REMOVED);
        Collection<Integer> modifiedOnly = DirtyUtils.getValuesWithState(wrapped, DirtyState.MODIFIED);
        Collection<Integer> unmodifiedOnly = DirtyUtils.getValuesWithState(wrapped, DirtyState.UNMODIFIED);

        assertNotNull(addedOnly);
        assertEquals(addedOnly.size(), 2);
        assertTrue(addedOnly.contains(1));
        assertTrue(addedOnly.contains(2));

        assertNotNull(removedOnly);
        assertEquals(removedOnly.size(), 1);
        assertTrue(removedOnly.contains(3));

        assertNotNull(modifiedOnly);
        assertEquals(modifiedOnly.size(), 2);
        assertTrue(modifiedOnly.contains(4));
        assertTrue(modifiedOnly.contains(5));

        assertNotNull(unmodifiedOnly);
        assertEquals(unmodifiedOnly.size(), 0);
    }
}
