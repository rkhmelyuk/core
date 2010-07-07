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

package com.prutsoft.core.fp.collections.filters;

import com.prutsoft.core.fp.Function;

import java.util.Collection;

/**
 * Filters are used to filter incoming collections and as result
 * return not null collection.
 * <p>Incoming collection can't be null and if it is empty
 * than it will be returned without any work. That will help to increase
 * the performance.
 * <p>Filters also supports chainings, when one filter runs next filter
 * on its results. It is also possible to chain more than on filter:
 * <code>
 *  filter.then(filter1).then(filter2).then(filter3.then(filter3_1));
 * </code>
 *
 * @see com.prutsoft.core.fp.Function
 *
 * @author Ruslan Khmelyuk
 * @version $Rev$
 * @since 2009-01-08 01:48
 */
public interface Filter<_T> extends Function<Collection<_T>, Collection<_T>> {

    /**
     * Adds filter to the list of chained filters and return reference to
     * the current filter to support multiple chainings.
     *
     * @param nextFilter the next filter to run, can't be null.
     * @return the reference to the current filter
     */
    Filter<_T> then(Filter<_T> nextFilter);
}
