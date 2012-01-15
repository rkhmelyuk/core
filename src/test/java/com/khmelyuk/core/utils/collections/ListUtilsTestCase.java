package com.khmelyuk.core.utils.collections;

import com.khmelyuk.core.BaseTestCase;
import com.khmelyuk.core.code.Warnings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruslan Khmelyuk
 * @since 2009-01-02 23:30
 */
public class ListUtilsTestCase extends BaseTestCase {

    @SuppressWarnings(Warnings.Unchecked)
    public void testAsLinkedList() {
        List list = ListUtils.arrayList(10, 12, 23);
        assertTrue(ListUtils.asLinkedList(list) instanceof LinkedList);

        list = ListUtils.linkedList(10, 12, 44);
        assertSame(ListUtils.asLinkedList(list), list);
    }

    @SuppressWarnings(Warnings.Unchecked)
    public void testAsArrayList() {
        List list = ListUtils.linkedList(10, 12, 23);
        assertTrue(ListUtils.asArrayList(list) instanceof ArrayList);

        list = ListUtils.arrayList(10, 12, 44);
        assertSame(ListUtils.asArrayList(list), list);
    }
}
