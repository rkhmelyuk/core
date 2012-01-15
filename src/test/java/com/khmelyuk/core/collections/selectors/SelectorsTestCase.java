package com.khmelyuk.core.collections.selectors;

import com.khmelyuk.core.BaseTestCase;
import com.khmelyuk.core.code.Warnings;
import com.khmelyuk.core.fp.collections.selectors.*;
import com.khmelyuk.core.utils.collections.ListUtils;

import java.util.Collection;

/**
 * @author Ruslan Khmelyuk
 * @since 2009-01-11 17:32
 */
public class SelectorsTestCase extends BaseTestCase {

    @SuppressWarnings(Warnings.Unchecked)
    public void testSelectorsFactory() {
        assertNotNull(Selectors.firstElement());
        assertNotNull(Selectors.lastElement());
        assertNotNull(Selectors.minElement());
        assertNotNull(Selectors.maxElement());
    }

    public void testFirstSelector() {
        Collection<Integer> values = ListUtils.listOf(10, 12, 23, 4, 1, 12, 12, 23, 123);
        assertTrue(new FirstElement<Integer>().run(values) == 10);
    }

    public void testLastSelector() {
        Collection<Integer> values = ListUtils.listOf(10, 12, 23, 4, 1, 12, 12, 23, 123);
        assertTrue(new LastElement<Integer>().run(values) == 123);
    }

    public void testMinSelector() {
        Collection<Integer> values = ListUtils.listOf(10, 12, 23, 423, 1, 12, 12, 23, 123);
        assertTrue(new MinElement<Integer>().run(values) == 1);
    }

    public void testMaxSelector() {
        Collection<Integer> values = ListUtils.listOf(10, 12, 23, 423, 1, 12, 12, 23, 123);
        assertTrue(new MaxElement<Integer>().run(values) == 423);
    }
}
