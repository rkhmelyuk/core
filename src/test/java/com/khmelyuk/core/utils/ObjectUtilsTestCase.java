package com.khmelyuk.core.utils;

import com.khmelyuk.core.BaseTestCase;

/**
 * @author Ruslan Khmelyuk
 * @since 2009-01-05 01:18
 */
public class ObjectUtilsTestCase extends BaseTestCase {

    public void testHashCode() {
        assertTrue(0 == ObjectUtils.hashCode(null));
        assertFalse(0 != ObjectUtils.hashCode(0));
    }

    public void testCompareTo() {
        assertEquals(ObjectUtils.compareTo(null, null), 0);
        assertEquals(ObjectUtils.compareTo(1, null), 1);
        assertEquals(ObjectUtils.compareTo(null, 1), -1);
        assertEquals(ObjectUtils.compareTo(1, 1), 0);
        assertTrue(ObjectUtils.compareTo(1, 2) < 0 );
        assertTrue(ObjectUtils.compareTo(5, 2) > 0 );

        try {
            // the test case
            assertTrue(ObjectUtils.compareTo("String", 2) == 0 );
            unexpected("Exception should be thrown.");
        }
        catch (Exception e) {
            // everything is OK
        }
    }

    public void testEquals() {
        assertTrue(ObjectUtils.equals(null, null));
        assertTrue(ObjectUtils.equals(1, 1));
        assertTrue(ObjectUtils.equals("Hello", "Hello"));
        assertFalse(ObjectUtils.equals("Hello", "hello"));
        assertFalse(ObjectUtils.equals(1, null));
        assertFalse(ObjectUtils.equals(null, "Hello"));
    }

    public void testTernaryEquals() {
        assertTrue(ObjectUtils.equals(null, null, null));
        assertFalse(ObjectUtils.equals(1, null, null));
        assertFalse(ObjectUtils.equals(null, "Hello", null));
        assertFalse(ObjectUtils.equals(1, "Hello", 2));
        assertTrue(ObjectUtils.equals("Hello", "Hello", "Hello"));
        assertTrue(ObjectUtils.equals(2, 2, 2));
        assertFalse(ObjectUtils.equals(2, 12, 2));
    }
}
