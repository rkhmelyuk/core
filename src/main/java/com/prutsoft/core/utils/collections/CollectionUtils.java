/*
 * Copyright 2008-2009 Ruslan Khmelyuk.
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

package com.prutsoft.core.utils.collections;

import com.prutsoft.core.asserts.ArgumentAssert;
import com.prutsoft.core.code.Warnings;
import com.prutsoft.core.fp.Predicate;
import com.prutsoft.core.fp.Procedure;
import com.prutsoft.core.fp.collections.filters.Filter;
import com.prutsoft.core.fp.collections.selectors.Selectors;
import com.prutsoft.core.utils.ObjectUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Utils for Java collections.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2008-8-13 1:33
 */
public class CollectionUtils {

    /**
     * Check whether collection is null or empty.
     *
     * @param collection the collection to check.
     * @return true if collection is null or empty.
     */
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * Check whether collection is not null and not empty.
     *
     * @param collection the collection to check.
     * @return true if collection isn't null and not empty.
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return (collection != null && !collection.isEmpty());
    }

    /**
     * Get the collection as array.
     *
     * @param collection the collection of elements of T type; can't be null.
     * @param <T> the type of collection and result array elements.
     * @return the array with collection's elements.
     */
    public static <T> T[] asArray(Collection<T> collection) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");
        return ArrayUtils.arrayFrom(collection);
    }

    /**
     * Gets the collection as list.
     * If collection is a list, then it is returned as list, otherwise
     * new array list is created and filled with collection elements.
     *
     * @param collection the collection; can't be null.
     * @param <T> the the of collection and result list elements.
     * @return the list of collection elements.
     */
    public static <T> List<T> asList(Collection<T> collection) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");
        if (collection instanceof List) {
            return (List<T>) collection;
        }
        return ListUtils.asArrayList(collection);
    }

    /**
     * Gets the collection as set.
     * If collection is a set, then it is returned as set, otherwise
     * new hash set is created and filled with collection elements.
     *
     * @param collection the collection; can't be null.
     * @param <T> the the of collection and result set elements.
     * @return the set of collection elements.
     */
    public static <T> Set<T> asSet(Collection<T> collection) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");
        if (collection instanceof Set) {
            return (Set<T>) collection;
        }
        return SetUtils.asHashSet(collection);
    }

    /**
     * Join collection elements with specified string and result result as string.
     * @param collection the collection to join; can't be null.
     * @param joinStr the join string; can't be null.
     * @return the string with collection elements joined by join string.
     */
    public static String join(Collection collection, String joinStr) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");
        ArgumentAssert.isNotNull(joinStr, "Join string can't be null.");

        StringBuilder result = new StringBuilder(collection.size() * joinStr.length());
        int size = collection.size();
        for (Object el : collection) {
            result.append(el);
            if ((--size) != 0) {
                result.append(joinStr);
            }
        }
        return result.toString();
    }

    /**
     * Gets the minimal value from the collection.
     * If collection is empty, than {@code null} is returned.
     *
     * @param collection the collection; can't be null.
     * @param <T> the collection elements type, should implement {@code Comparable} interface.
     * @return the minimal value or {@code null} if input collection is empty.
     */
    @SuppressWarnings(Warnings.Unchecked)
    public static <T extends Comparable> T min(Collection<T> collection) {
        return (T) Selectors.minElement().run(collection);
    }

    /**
     * Gets the index of the minimal value. If there are no value, then {@code -1}
     * is returned, otherwise 0 or positive value.
     * The collection elements should implement the {@code Comparable} interface.
     *
     * @param collection the collection of elements; can't be null.
     * @return the index of minimal value or -1 if collection is empty.
     */
    public static int minIndex(Collection<? extends Comparable> collection) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");

        Comparable min = null;
        int minIndex = -1;
        int index = 0;
        for (Comparable each : collection) {
            if (min == null || ObjectUtils.compareTo(min, each) > 0) {
                min = each;
                minIndex = index;
            }
            index++;
        }

        return minIndex;
    }

    /**
     * Gets the maximal value from the collection.
     * If collection is empty, than {@code null} is returned.
     *
     * @param collection the collection; can't be null.
     * @param <T> the collection elements type, should implement {@code Comparable} interface.
     * @return the maximal value or {@code null} if input collection is empty.
     */
    @SuppressWarnings(Warnings.Unchecked)
    public static <T extends Comparable> T max(Collection<T> collection) {
        return (T) Selectors.maxElement().run(collection);
    }

    /**
     * Gets the index of the maximal value. If there are no value, then {@code -1}
     * is returned, otherwise 0 or positive value.
     * The collection elements should implement the {@code Comparable} interface.
     *
     * @param collection the collection of elements; can't be null.
     * @return the index of maximal value or -1 if collection is empty.
     */
    public static int maxIndex(Collection<? extends Comparable> collection) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");

        Comparable max = null;
        int maxIndex = -1;
        int index = 0;
        for (Comparable each : collection) {
            if (max == null || ObjectUtils.compareTo(each, max) > 0) {
                max = each;
                maxIndex = index;
            }
            index++;
        }

        return maxIndex;
    }

    /**
     * Gets the first element of the collection.
     * If collection is {@code null} or empty, then {@code null} is returned.
     *
     * @param collection the collection.
     * @param <T> the type of collection elements and result value.
     * @return the first element or {@code null} if collection is empty or {@code null}.
     *
     * @see com.prutsoft.core.fp.collections.selectors.FirstElement
     */
    @SuppressWarnings(Warnings.Unchecked)
    public static <T> T first(Collection<T> collection) {
        return (T) Selectors.firstElement().run(collection);
    }

    /**
     * Gets the last element of the collection.
     * If collection is {@code null} or empty, then {@code null} is returned.
     *
     * @param collection the collection.
     * @param <T> the type of collection elements and result value.
     * @return the last element or {@code null} if collection is empty or {@code null}.
     *
     * @see com.prutsoft.core.fp.collections.selectors.LastElement
     */
    @SuppressWarnings(Warnings.Unchecked)
    public static <T> T last(Collection<T> collection) {
        return (T) Selectors.lastElement().run(collection);
    }

    // -------------------------------------------------------------

    /**
     * Run the procedure for the each element in the collection.
     *
     * @param collection the collection to run each for; can't be null.
     * @param procedure the procedure to run for each element in collection; can't be null.
     * @param <_T> the type of elements in collection and argument for procedure.
     */
    public static <_T> void each(Collection<_T> collection, Procedure<_T> procedure) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");
        ArgumentAssert.isNotNull(procedure, "Procedure can't be null.");

        for (_T each : collection) {
            procedure.run(each);
        }
    }

    /**
     * Filter the collection using specified filter.
     * If collection is empty, than it will be returned.
     *
     * @param collection the collection to filter; can't be null.
     * @param filter the filter to filter the collection; can't be null.
     * @param <_T> the type of collection elements.
     * @return the filtered collection or input collection if it is empty.
     */
    public static <_T> Collection<_T> filter(Collection<_T> collection, Filter<_T> filter) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");
        ArgumentAssert.isNotNull(filter, "Filter can't be null.");

        return (collection.isEmpty() ? collection : filter.run(collection));
    }

    /**
     * Finds all elements in the collection that pass the predicate check and return it as collection.
     * If input collection is empty, that it will be returned as result.
     *
     * @param collection the collection; can't be null.
     * @param predicate the predicate; can't be null.
     * @param <_T> the collection elements type.
     * @return the collection with results;
     */
    public static <_T> Collection<_T> findAll(Collection<_T> collection, Predicate<_T> predicate) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");
        ArgumentAssert.isNotNull(predicate, "Predicate can't be null.");

        if (collection.isEmpty()) return collection;
        Collection<_T> result = new ArrayList<_T>();
        for (_T each : collection) {
            if (predicate.check(each)) {
                result.add(each);
            }
        }
        return result;
    }

}
