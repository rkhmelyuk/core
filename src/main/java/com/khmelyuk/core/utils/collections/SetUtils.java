/*
 * Copyright 2008-2012 Ruslan Khmelyuk.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.khmelyuk.core.utils.collections;

import com.khmelyuk.core.asserts.ArgumentAssert;

import java.util.*;

import static com.khmelyuk.core.utils.collections.ListUtils.arrayList;
import static com.khmelyuk.core.utils.collections.ListUtils.listOf;

/**
 * The utils for work with sets.
 *
 * @author Ruslan Khmelyuk
 * @since 2008-11-02 02:14
 */
public final class SetUtils {

    /**
     * Gets collection as <code>HashSet</code>. If collection is of <code>HashSet</code> type
     * then it is returned, otherwise new <code>HashSet</code> instance is created
     * with collection data.
     *
     * @param collection the collection of elements of T type; can't be null.
     * @param <T>        the incoming collection and result set elements type.
     * @return the collection as hash set.
     */
    public static <T> Set<T> asHashSet(Collection<T> collection) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");

        if (collection instanceof HashSet) {
            return (HashSet<T>) collection;
        }
        return new HashSet<T>(collection);
    }

    public static <T> Set<T> set(T... elems) {
        return set(listOf(elems));
    }

    public static <T> Set<T> hashSet(T... elems) {
        return set(arrayList(elems));
    }

    public static <T> Set<T> treeSet(T... elems) {
        return new TreeSet<T>(arrayList(elems));
    }

    /**
     * Returns the set with elements give as list.
     * Used {@code java.util.HashSet} implementation.
     *
     * @param elems the list of elements; can't be null.
     * @return the set of elements from list.
     */
    public static <T> Set<T> set(List<T> elems) {
        return new HashSet<T>(elems);
    }

    /**
     * The singleton set. Used <code>java.utils.Collections.singleton()</code> method.
     *
     * @param elem the element.
     * @param <T>  the element type.
     * @return the singleton set.
     */
    public static <T> Set<T> singletonSet(T elem) {
        return Collections.singleton(elem);
    }

    /**
     * Merge few collections in one.
     * The result list is of <code>HashSet</code> type.
     * If parameter is <code>null</code>, then result set is empty.
     *
     * @param elems the array of collections of type T
     * @param <T>   the collections type and result set type.
     * @return the set of all merged values.
     */
    public static <T> Set<T> merge(Collection<T>... elems) {
        Set<T> resultSet = hashSet();
        if (elems != null) {
            for (Collection<T> eachCollection : elems) {
                resultSet.addAll(eachCollection);
            }
        }
        return resultSet;
    }

    /**
     * Splits the string with strings separated by commas and returns them as set.
     * Trims each string in the list.
     *
     * @param string the string with strings separated by commas.
     * @return the set with parsed strings.
     */
    public static Set<String> strSetFromString(String string) {
        return strSetFromString(string, ",");
    }

    /**
     * Splits the string with strings separated by delimiter and returns them as set.
     * Trims each string in the set.
     *
     * @param string    the string with strings separated by delimiter.
     * @param delimiter the delimiter between strings in the string.
     * @return the set with parsed strings.
     */
    public static Set<String> strSetFromString(String string, String delimiter) {
        if (string == null || string.isEmpty()) return Collections.emptySet();

        Set<String> result = new HashSet<String>();

        String[] strings = string.split(delimiter);
        for (String each : strings) {
            each = each.trim();
            if (each.isEmpty()) {
                continue;
            }
            result.add(each);
        }

        return result;
    }

}
