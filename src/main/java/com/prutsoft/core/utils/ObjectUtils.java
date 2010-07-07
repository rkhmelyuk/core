/*
 * Copyright 2008-2009 Ruslan Khmelyuk, Prutsoft.
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

package com.prutsoft.core.utils;

import com.prutsoft.core.code.Warnings;

/**
 * The utils to work with objects.
 * Because all classes are objects, then this utils methods are usefull for all objects.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2008-8-13 01:48
 */
public class ObjectUtils {

    /**
     * Checks two values for equivalence.
     * This method is also prevents {@code NullPointerException} if any argument is null.
     * If both arguments are null, then {@code true} is returned.
     *
     * @param left the first argument.
     * @param right the second argument.
     * @return {@code true} if check pass, otherwise {@code false}.
     */
    public static boolean equals(Object left, Object right) {
        if (left == right) {
            return true;
        }
        else if (left != null) {
            return left.equals(right);
        }
        else {
            return right.equals(left);
        }
    }

    /**
     * Checks three values for equivalence.
     * This method is also prevents {@code NullPointerException} if any argument is null.
     * If all arguments are null, then {@code true} is returned.
     *
     * @param left the first argument.
     * @param middle the second argument.
     * @param right the third argument.
     * @return {@code true} if check pass, otherwise {@code false}.
     */
    public static boolean equals(Object left, Object middle, Object right) {
        if (left == middle && middle == right) {
            return true;
        }
        else if (left != null) {
            return (left.equals(middle) && left.equals(right));
        }
        else if (middle != null) {
            return (middle.equals(left) && middle.equals(right));
        }
        else {
            return (right.equals(left) && right.equals(middle));
        }
    }

    /**
     * Returns the hash code of object. If object is equal {@code null} then 0 is returned.
     *
     * @param value the object to get hash code for.
     * @return the hash code of value.
     */
    public static int hashCode(Object value) {
        if (value != null) {
            return value.hashCode();
        }
        return 0;
    }

    /**
     * Returns the hash code of objects. If any object is equal {@code null} then 0 is returned.
     *
     * @param values the objects to get hash code for.
     * @return the hash code of value.
     *
     * @since 1.0.2
     */
    public static int hashCode(Object... values) {
        if (values == null) return 0;

        int result = 0;
        for (Object each : values) {
            result += hashCode(each);
        }
        return result ^ 31;
    }


    /**
     * Returns the result of compare to operation for
     * arguments. This method prevents any problems related to <code>null</code> arguments values.
     *
     * @param left the left value; can be null.
     * @param right the right value; can be null.
     * @return a negative integer, zero, or a positive integer as this object
     *		is less than, equal to, or greater than the specified object.
     */
    @SuppressWarnings(Warnings.Unchecked)
    public static <T extends Comparable> int compareTo(T left, T right) {
        if (left != null && right != null) {
            return left.compareTo(right);
        }
        if (right == null && left == null) {
            return 0;
        }
        return (left == null ? -1 : 1);
    }
}
