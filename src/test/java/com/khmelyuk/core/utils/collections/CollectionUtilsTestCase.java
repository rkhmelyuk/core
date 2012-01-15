package com.khmelyuk.core.utils.collections;

import com.khmelyuk.core.BaseTestCase;
import com.khmelyuk.core.code.Warnings;
import com.khmelyuk.core.fp.Procedure;
import com.khmelyuk.core.fp.collections.filters.Filters;

import java.util.Collection;

/**
 * @author Ruslan Khmelyuk
 * @since 2009-01-02 23:39
 */
@SuppressWarnings(Warnings.Unchecked)
public class CollectionUtilsTestCase extends BaseTestCase {

    public void testJoin() {
        Collection collection = ListUtils.listOf(10, 23, 34, 12, 12);
        assertEquals(CollectionUtils.join(collection, ","),
                "10,23,34,12,12");
    }

    public void testMinMaxInteger() {
        Collection collection = ListUtils.listOf(10, 12, 34, 12, 67, 23, 12);
        assertEquals(CollectionUtils.max(collection), 67);
        assertEquals(CollectionUtils.min(collection), 10);
    }

    public void testMinMaxBoolean() {
        Collection collection = ListUtils.listOf(true, false, true, true, false);
        assertEquals(CollectionUtils.max(collection), true);
        assertEquals(CollectionUtils.min(collection), false);
    }

    public void testMinMaxString() {
        Collection collection = ListUtils.listOf("Hello", "hello", "hello world!");
        assertEquals(CollectionUtils.max(collection), "hello world!");
        assertEquals(CollectionUtils.min(collection), "Hello");
    }

    public void testMinMaxEmptyCollection() {
        Collection collection = ListUtils.listOf();
        assertNull(CollectionUtils.max(collection));
        assertNull(CollectionUtils.min(collection));
    }

    public void testMinMaxNullCollection() {
        Collection collection = null;
        try {
            assertNull(CollectionUtils.max(collection));
            unexpected("Exception should be thrown");
        }
        catch (IllegalArgumentException e) {
            // everything is OK
        }
        catch (Exception e) {
            unexpectedException("Wrong exception: must be IllegalArgumentException.");
        }

        try {
            assertNull(CollectionUtils.min(collection));
            unexpected("Exception should be thrown");
        }
        catch (IllegalArgumentException e) {
            // everything is OK
        }
        catch (Exception e) {
            unexpectedException("Wrong exception: must be IllegalArgumentException.");
        }

    }

    public void testMinMaxIndex() {
        Collection collection = ListUtils.listOf(10, 12, 34, 12, 67, 23, 12);
        assertEquals(CollectionUtils.maxIndex(collection), 4);
        assertEquals(CollectionUtils.minIndex(collection), 0);       
    }

    public void testFirstElement() {
        Collection collection = ListUtils.listOf(10, 11, 12, 23, 34, 34, 12);
        assertEquals(10, CollectionUtils.first(collection));
    }

    public void testLastElement() {
        Collection collection = ListUtils.listOf(10, 11, 12, 23, 34, 34, 125);
        assertEquals(125, CollectionUtils.last(collection));
    }

    public void testEach() {
        Collection collection = ListUtils.listOf(1, 2, 3, 4, 5, 6, 7);

        CollectionUtils.each(collection, new Procedure<Integer>() {
            int i = 1;
            public void run(Integer integer) {
                assertTrue(i++ == integer);
            }
        });
    }

    public void testFilter() {
        Collection collection = ListUtils.listOf(10, 11, 12, 23, 30, 34, 34, 125);

        Collection result = CollectionUtils.filter(collection, Filters.greaterThan(30));
        assertNotNull(result);
        assertTrue(result.size() == 3);
        assertTrue(result.containsAll(ListUtils.listOf(34, 34, 125)));
    }
}
