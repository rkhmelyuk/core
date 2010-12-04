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

package com.prutsoft.core.fp.collections.filters;

/**
 * The factory for filters.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev$
 * @since 2009-01-08 02:00
 */
public final class Filters {

    /**
     * Gets the filter for filtering greater values.
     *
     * @param value the value used to filter collection.
     * @param <_T> the value type.
     * @return the filter.
     */
    public static <_T extends Comparable> Filter<_T> greaterThan(_T value) {
        return new GreaterThan<_T>(value);
    }

    /**
     * Gets the filter for filtering less values.
     *
     * @param value the value used to filter collection.
     * @param <_T> the value type.
     * @return the filter.
     */
    public static <_T extends Comparable> Filter<_T> lessThan(_T value) {
        return new LessThan<_T>(value);
    }

    /**
     * Gets the filter for filtering equal values.
     *
     * @param value the value used to filter collection.
     * @param <_T> the value type.
     * @return the filter.
     */
    public static <_T extends Comparable> Filter<_T> equalTo(_T value) {
        return new EqualTo<_T>(value);
    }

    /**
     * Gets the filter for filtering not null values.
     *
     * @param <_T> the type of filter parameter.
     * @return the filter.
     */
    public static <_T> Filter<_T> notNull() {
        return new NotNull<_T>();
    }
}
