package com.khmelyuk.core;

import com.khmelyuk.core.utils.collections.ListUtils;

/**
 * @author Ruslan Khmelyuk
 */
public class IdentifiablesTestCase extends BaseTestCase {

    public void testGetById_WithNullId() {
        try {
            Identifiables.getById(TestEnum.values(), null);
            unexpected("Should fail to get enum value by null id.");
        }
        catch (IllegalArgumentException e) {
            // that's OK
        }
        catch (Throwable t) {
            unexpectedException("Unexpected exception.");
        }
    }

    public void testGetById_WithNullValues() {
        try {
            Identifiables.getById((Identifiable[]) null, "A");
            unexpected("Should fail to get enum value by null values.");
        }
        catch (IllegalArgumentException e) {
            // that's OK
        }
        catch (Throwable t) {
            unexpectedException("Unexpected exception.");
        }
    }

    public void testGetById_FoundExistingElement() {
        assertEquals(TestEnum.EntryA, Identifiables.getById(TestEnum.values(), "A"));
    }

    public void testGetById_NotFoundAbsentElement() {
        assertNull(Identifiables.getById(TestEnum.values(), "E"));
    }

    public void testGetById_InList() {
        assertNull(Identifiables.getById(ListUtils.arrayList(TestEnum.EntryA, TestEnum.EntryB), "B"));
    }

    public static enum TestEnum implements Identifiable<String> {
        EntryA("A"),
        EntryB("B");

        final String id;

        private TestEnum(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

}
