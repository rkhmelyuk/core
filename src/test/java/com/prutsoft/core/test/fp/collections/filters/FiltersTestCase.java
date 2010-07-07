package com.prutsoft.core.test.fp.collections.filters;

import com.prutsoft.core.code.Warnings;
import com.prutsoft.core.fp.collections.filters.*;
import com.prutsoft.core.test.BaseTestCase;
import com.prutsoft.core.utils.collections.CollectionUtils;
import com.prutsoft.core.utils.collections.ListUtils;

import java.util.Collection;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev$
 * @since 2009-01-08 22:21
 */
public class FiltersTestCase extends BaseTestCase {

    public void testFilters() {
        assertTrue(Filters.greaterThan(0) instanceof GreaterThan);
        assertTrue(Filters.lessThan(0) instanceof LessThan);
        assertTrue(Filters.equalTo(0) instanceof EqualTo);
        assertTrue(Filters.notNull() instanceof NotNull);
    }

    @SuppressWarnings(Warnings.Unchecked)
    public void testGreaterThanFilter() {
        Collection collection = ListUtils.listOf(10, 11, 12, 23, 30, 34, 34, 125);

        Collection result = CollectionUtils.filter(collection, new GreaterThan(30));
        assertNotNull(result);
        assertTrue(result.size() == 3);
        assertTrue(result.containsAll(ListUtils.listOf(34, 34, 125)));
    }

    @SuppressWarnings(Warnings.Unchecked)
    public void testLessThanFilter() {
        Collection collection = ListUtils.listOf(10, 11, 12, 23, 30, 34, 34, 125);

        Collection result = CollectionUtils.filter(collection, new LessThan(30));
        assertNotNull(result);
        assertTrue(result.size() == 4);
        assertTrue(result.containsAll(ListUtils.listOf(10, 11, 12, 23)));
    }

    @SuppressWarnings(Warnings.Unchecked)
    public void testNotNullFilter() {
        Collection collection = ListUtils.listOf(null, 10, null, 12, 23, null);

        Collection result = CollectionUtils.filter(collection, new NotNull());
        assertNotNull(result);
        assertTrue(result.size() == 3);
        assertTrue(result.containsAll(ListUtils.listOf(10, 12, 23)));
    }

    @SuppressWarnings(Warnings.Unchecked)
    public void testChainedFilters() {
        Collection collection = ListUtils.listOf(null, 10, null, 12, 23, 17, 20, 45, null);
        Collection result = CollectionUtils.filter(collection,
                new NotNull().then(new GreaterThan(12)).then(new LessThan(20)));

        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertTrue(result.contains(17));
    }

}
