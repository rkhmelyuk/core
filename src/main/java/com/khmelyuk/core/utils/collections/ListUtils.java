/*
 * Copyright 2008-2010 Ruslan Khmelyuk.
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

import com.khmelyuk.core.code.Warnings;
import com.khmelyuk.core.utils.ConversionUtils;

import java.util.*;

/**
 * @author Ruslan Khmelyuk
 * @since 2008-11-02 02:08
 */
public final class ListUtils {

    /**
     * Returns the list that can be changes.
     * The list contains elements given as parameters.
     *
     * @param elems the elements to add to the list.
     * @return the array list with elements.
     */
    public static <T> List<T> arrayList(T... elems) {
        return new ArrayList<T>(listOf(elems));
    }

    /**
     * Returns the list that can be changes.
     * The list contains elements given as parameters.
     *
     * @param elems the elements to add to the list.
     * @return the array list with elements.
     */
    public static <T> List<T> linkedList(T... elems) {
        return new LinkedList<T>(listOf(elems));
    }

    /**
     * Returns the list of elements given as parameters.
     *
     * @param elems the elements to add to the list.
     * @return the list with elements.
     */
    public static <T> List<T> listOf(T... elems) {
        return java.util.Arrays.asList(elems);
    }

    /**
     * Creates the single list of one element.
     * The <code>Collections.singletonList()</code> is used to
     * get the result singleton list.
     *
     * @param elem the only element of singleton list.
     * @param <T>  the type of element and list type parameter.
     * @return the singleton list with one element got as argument of this method.
     */
    public static <T> List<T> singletonList(T elem) {
        return Collections.singletonList(elem);
    }

    /**
     * If input collection is {@code ArrayList} then return it.
     * Otherwise creates new {@code ArrayList} with elements from {@code collection} and return it.
     *
     * @param collection the collection.
     * @return the array list of elements of collection.
     */
    public static <T> List<T> asArrayList(Collection<T> collection) {
        if (collection instanceof ArrayList) {
            return (List<T>) collection;
        }
        return new ArrayList<T>(collection);
    }

    /**
     * If input collection is {@code LinkedList} then return it.
     * Otherwise creates new {@code LinkedList} with elements from {@code collection} and return it.
     *
     * @param collection the collection.
     * @return the linked list of elements of collection.
     */
    public static <T> List<T> asLinkedList(Collection<T> collection) {
        if (collection instanceof LinkedList) {
            return (List<T>) collection;
        }
        return new LinkedList<T>(collection);
    }


    /**
     * Merge few collections in one.
     * The result list is of <code>ArrayList</code> type.
     * If parameter is <code>null</code>, then result list is empty.
     *
     * @param elems the array of collections of type T
     * @param <T>   the collections type and result list type.
     * @return the list of all merged values.
     */
    public static <T> List<T> merge(Collection<T>... elems) {
        List<T> resultList = arrayList();
        if (elems != null) {
            for (Collection<T> eachCollection : elems) {
                resultList.addAll(eachCollection);
            }
        }
        return resultList;
    }

    /**
     * Replace elements in list.
     *
     * @param list        the list to replace elements in.
     * @param replaceFrom the index of first element.
     * @param replaceTo   the index of second element.
     * @return true, if elements are replaced, otherwise false.
     */
    @SuppressWarnings(Warnings.Unchecked)
    public static boolean replaceElements(List list, int replaceFrom, int replaceTo) {
        boolean replaced = false;
        if (replaceFrom >= 0 && replaceTo < list.size() && replaceFrom < replaceTo) {
            Object element = list.get(replaceFrom);
            list.set(replaceFrom, list.get(replaceTo));
            list.set(replaceTo, element);
            replaced = true;
        }
        return replaced;
    }

    /**
     * Splits the string with integers separated by commas and returns them as list.
     *
     * @param string the string with integers separated by commas.
     * @return the list with parsed integers.
     */
    public static List<Integer> intListFromString(String string) {
        return intListFromString(string, ",");
    }

    /**
     * Splits the list with integers separated by delimiter and returns them as list.
     *
     * @param string the string with integers separated by delimiter.
     * @param delimiter the delimiter between integers in the string.
     * @return the list with parsed integers.
     */
    public static List<Integer> intListFromString(String string, String delimiter) {
        if (string == null || string.isEmpty()) return Collections.emptyList();

        List<Integer> result = new ArrayList<Integer>();

        String[] strings = string.split(delimiter);
        for (String each : strings) {
            each = each.trim();
            if (each.isEmpty()) {
                continue;
            }
            Integer value = ConversionUtils.getInteger(each, null);
            if (value != null) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * Splits the string with strings separated by commas and returns them as list.
     * Trims each string in the list.
     *
     * @param string the string with strings separated by commas.
     * @return the list with parsed strings.
     */
    public static List<String> strListFromString(String string) {
        return strListFromString(string, ",");
    }

    /**
     * Splits the string with strings separated by delimiter and returns them as list.
     * Trims each string in the list.
     *
     * @param string the string with strings separated by delimiter.
     * @param delimiter the delimiter between strings in the string.
     * @return the list with parsed strings.
     */
    public static List<String> strListFromString(String string, String delimiter) {
        if (string == null || string.isEmpty()) return Collections.emptyList();

        List<String> result = new ArrayList<String>();

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
