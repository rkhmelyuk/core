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
import com.prutsoft.core.utils.ObjectUtils;

import java.util.*;

/**
 * The utils methods to work with maps.
 *
 * @author Ruslan Khmelyuk
 * @since 2008-11-02 02:14
 */
public class MapUtils {

    /**
     * Checks whether map is empty or {@code null}.
     *
     * @param map the map to check.
     * @return {@code true} if map is empty or {@code null}, otherwise {@code false}.
     */
    public boolean isEmpty(Map map) {
        return (map == null || map.keySet().isEmpty());
    }

    /**
     * Checks whether map is not empty.
     *
     * @param map the map to check.
     * @return {@code true} if map is not empty, otherwise {@code false}.
     */
    public boolean isNotEmpty(Map map) {
        return (map != null && !map.keySet().isEmpty());
    }

    public static <K, V> Map<K, V> map(List<K> keys, List<V> values) {
        if (keys == null || values == null) {
            throw new NullPointerException("Keys and/or values is null.");
        }
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("Keys and Values collections have different length.");
        }
        Map<K, V> map = new HashMap<K, V>(keys.size());
        int index = 0;
        for (K key : keys) {
            V value = values.get(index++);
            map.put(key, value);
        }
        return map;
    }

    @SuppressWarnings(Warnings.Unchecked)
    public static Map map(Collection collection) {
        ArgumentAssert.isNotNull(collection, "Collection should not be null.");

        int size = collection.size();
        if (size == 0) return new HashMap();

        if (size % 2 != 0) {
            throw new IllegalStateException("Collection contains odd count of elements.");
        }

        Map map = new HashMap(size / 2);
        for (Iterator _itr = collection.iterator(); _itr.hasNext();) {
            map.put(_itr.next(), _itr.next());
        }
        return map;
    }

    public static <K, V> K keyByValue(Map<K, V> map, V value) {
        ArgumentAssert.isNotNull(map, "Map can't be null.");
        for (Map.Entry<K, V> each : map.entrySet()) {
            if (ObjectUtils.equals(each.getValue(), value)) {
                return each.getKey();
            }
        }
        return null;
    }

    public static <K, V> Map<V, K> revertPair(Map<K, V> source) {
        ArgumentAssert.isNotNull(source, "Source can't be null.");

        Map<V, K> target = new HashMap<V, K>(source.size());
        for (Map.Entry<K, V> each : source.entrySet()) {
            target.put(each.getValue(), each.getKey());
        }
        return target;
    }

    public static <K, V> Map<K, V> map(K key, V value) {
        Map<K, V> result = new HashMap<K, V>();
        result.put(key, value);
        return result;
    }

    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2) {
        Map<K, V> result = new HashMap<K, V>();
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }

    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3) {
        Map<K, V> result = new HashMap<K, V>();
        result.put(key1, value1);
        result.put(key2, value2);
        result.put(key3, value3);
        return result;
    }

    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2,
                                       K key3, V value3, K key4, V value4) {
        Map<K, V> result = new HashMap<K, V>();
        result.put(key1, value1);
        result.put(key2, value2);
        result.put(key3, value3);
        result.put(key4, value4);
        return result;
    }

    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2,
                                       K key3, V value3, K key4, V value4,
                                       K key5, V value5, K key6, V value6) {
        Map<K, V> result = new HashMap<K, V>();
        result.put(key1, value1);
        result.put(key2, value2);
        result.put(key3, value3);
        result.put(key4, value4);
        result.put(key5, value5);
        result.put(key6, value6);
        return result;
    }

}
