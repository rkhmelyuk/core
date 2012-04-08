package com.khmelyuk.core;

import com.khmelyuk.core.asserts.ArgumentAssert;

import java.util.Iterator;

/**
 * Some helpers to work with {@link Identifiable} implementations.
 *
 * @author Ruslan Khmelyuk
 * @since 1.1.3
 */
public class Identifiables {

    /**
     * Gets the identifiable value by it's id.
     * Value type should implement {@link com.khmelyuk.core.Identifiable} interface to be able used in this method.
     *
     * @param values the array of values to get element from.
     * @param id     the id to get value by.
     * @param <E>    the value type.
     * @param <K>    the id value type.
     * @return the found value by id, or null.
     */
    public static <E extends Identifiable<K>, K> E getById(E[] values, K id) {
        ArgumentAssert.isNotNull(values, "Array of values is null");
        ArgumentAssert.isNotNull(id, "ID value is null.");

        for (E each : values) {
            if (id.equals(each.getId())) {
                return each;
            }
        }

        return null;
    }

    /**
     * Gets the value value by it's id.
     * Value type should implement {@link com.khmelyuk.core.Identifiable} interface to be able used in this method.
     *
     * @param values the iterable to get iterator of values.
     * @param id     the id to get value by.
     * @param <E>    the value type.
     * @param <K>    the id value type.
     * @return the found value by id, or null.
     */
    public static <E extends Identifiable<K>, K> E getById(Iterable<E> values, K id) {
        ArgumentAssert.isNotNull(values, "Iterable of values is null");

        return getById(values.iterator(), id);
    }


    /**
     * Gets the value value by it's id.
     * Value type should implement {@link com.khmelyuk.core.Identifiable} interface to be able used in this method.
     *
     * @param iterator the iterator of values.
     * @param id       the id to get value by.
     * @param <E>      the value type.
     * @param <K>      the id value type.
     * @return the found value by id, or null.
     */
    private static <E extends Identifiable<K>, K> E getById(Iterator<E> iterator, K id) {
        ArgumentAssert.isNotNull(iterator, "Iterator is null");
        ArgumentAssert.isNotNull(id, "ID value is null.");

        while (iterator.hasNext()) {
            E each = iterator.next();
            if (id.equals(each)) {
                return each;
            }
        }

        return null;
    }
}
