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

import com.khmelyuk.core.code.Warnings;
import com.khmelyuk.core.utils.ObjectUtils;

import java.io.Serializable;

/**
 * The modifiable pair of two values. This type is parametrized, so that
 * could be a pair of values of diff types.
 *
 * @author Ruslan Khmelyuk
 * @since 2008-8-13 1:43
 */
public class Pair<F, S> implements Serializable {

    private F first;
    private S second;

    /**
     * Creates new {@code Pair} instance and sets first and second values to {@code null}.
     */
    public Pair() {
    }

    /**
     * Creates new {@code Pair} instance and sets appropriate first and second value.
     * @param first the pair first value.
     * @param second the pair second value.
     */
    public Pair(F first, S second) {
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
     * Sets new first value.
     * @param first the new first value.
     */
    public void setFirst(F first) {
        this.first = first;
    }

    /**
     * Gets the second value.
     * @return the second value.
     */
    public S getSecond() {
        return second;
    }

    /**
     * Sets new second value.
     * @param second the new second value.
     */
    public void setSecond(S second) {
        this.second = second;
    }

    /**
     * Creates and returns new {@code ReadOnlyPair} with
     * the same first and second value as this pair has.
     *
     * @return the new {@code ReadOnlyPair} with this pair first and second values.
     */
    public ReadOnlyPair<F, S> asReadOnly() {
        return new ReadOnlyPair<F, S>(first, second);
    }

    /**
     * Returns new {@code Pair} with reverted types and values.
     * The result pair has first value equal to the second value of this pair,
     * and second value equal to the first value of this pair.
     *
     * @return the new reverted pair.
     */
    @SuppressWarnings(Warnings.Unchecked)
    public Pair<S, F> revert() {
        return new Pair<S,F>(second, first);
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
        else if (obj instanceof Pair) {
            Pair other = (Pair) obj;
            return (ObjectUtils.equals(this.first, other.first) && ObjectUtils.equals(this.second, other.second));
        }
        else if (obj instanceof ReadOnlyPair) {
            ReadOnlyPair other = (ReadOnlyPair) obj;
            return (ObjectUtils.equals(this.first, other.getFirst()) && ObjectUtils.equals(this.second, other.getSecond()));
        }
        return false;
    }

    /**
     * The hash code of this object.
     *
     * @return the hash code of this object.
     */
    @Override
    public int hashCode() {
        return (ObjectUtils.hashCode(this.first) + ObjectUtils.hashCode(this.second)) ^ 19;
    }
}
