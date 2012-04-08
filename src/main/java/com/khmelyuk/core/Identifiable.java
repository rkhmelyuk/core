package com.khmelyuk.core;

/**
 * The interface that allows to access to the id of value.
 *
 * @author Ruslan Khmelyuk
 * @since 1.1.3
 */
public interface Identifiable<T> {

    /**
     * Gets the id value.
     * @return the id value.
     */
    T getId();

}
