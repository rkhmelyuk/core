/*
 * Copyright 2008-2010 Ruslan Khmelyuk, Prutsoft.
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

import com.prutsoft.core.utils.ObjectUtils;
import com.prutsoft.core.code.Warnings;
import com.prutsoft.core.asserts.ArgumentAssert;

import java.util.Collection;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2008-10-31 19:56
 */
public class ArrayUtils {

    /**
     * Returns an array of parameters.
     *
     * @param elements the parameters.
     * @return the array of parameters.
     */
    public static <T> T[] arrayOf(T... elements) {
        return elements;
    }

    /**
     * Gets the array from the collection.
     * @param collection the collection to get array from; can't be null.
     * @param <T> the collection and result array elements type.
     * @return the array from collection.
     */
    @SuppressWarnings({Warnings.Unchecked, "SuspiciousToArrayCall"})
    public static <T> T[] arrayFrom(Collection<T> collection) {
        ArgumentAssert.isNotNull(collection, "Collection can't be null.");
        return (T[]) collection.toArray(new Object[collection.size()]);
    }

    public static <T> boolean contains(T[] array, T value) {
        if (array == null || array.length == 0) return false;

        for (T eachElement : array) {
            if (ObjectUtils.equals(eachElement, value)) {
                return true;
            }
        }

        return false;
    }
}
