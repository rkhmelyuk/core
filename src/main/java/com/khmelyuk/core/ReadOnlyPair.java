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

package com.khmelyuk.core;

import com.khmelyuk.core.utils.ObjectUtils;

import java.io.Serializable;

/**
 * The read only pair of two values. This type is parametrized, so that
 * could be a pair of values of diff types.
 *
 * @author Ruslan Khmelyuk
 * @since 2008-8-13 9:35
 */
public class ReadOnlyPair<F, S> implements Serializable {

    private final F first;
    private final S second;

    /**
     * Creates new {@code ReadOnlyPair} instance and sets first and second values to specified arguments values.
     *
     * @param first the first value.
     * @param second the second value.
     */
    public ReadOnlyPair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Gets the first value.
     * @return the first value.
     */
    public F getFirst() {
        return first;
    }

    /**
     * Gets the second value.
     * @return the second value.
     */
    public S getSecond() {
        return second;
    }

    /**
     * Creates and returns new {@code Pair} with
     * the same first and second value as this pair has.
     *
     * @return the new {@code Pair} with this pair first and second values.
     */
    public Pair<F, S> asMutualPair() {
        return new Pair<F, S>(first, second);
    }

    /**
     * The hash code of this object.
     *
     * @return the hash code of this object.
     */
    @Override
    public int hashCode() {
        return (ObjectUtils.hashCode(first) + ObjectUtils.hashCode(second)) ^ 19;
    }

    /**
     * Check if this object is equal to the incoming object.
     * If this is the same object, then result is true.
     *
     * If incoming object is {@code Pair} or {@code ReadOnlyPair} than check equality
     * of first and second values. If they are equal then return {@code true}, otherwise {@code false}.
     * @param obj the object to check for equals.
     * @return {@code} true of objects are equal, otherwise {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (obj instanceof ReadOnlyPair) {
            ReadOnlyPair other = (ReadOnlyPair) obj;
            return (ObjectUtils.equals(this.first, other.first) && ObjectUtils.equals(this.second, other.second));
        }
        else if (obj instanceof Pair) {
            Pair other = (Pair) obj;
            return (ObjectUtils.equals(this.first, other.getFirst()) && ObjectUtils.equals(this.second, other.getSecond()));
        }
        return false;
    }
}
