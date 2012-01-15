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

package com.khmelyuk.core.fp.collections.filters;

import com.khmelyuk.core.asserts.ArgumentAssert;
import com.khmelyuk.core.utils.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The abstract basic implementation of {@code Filter} interface.
 * This implementation provides support for chaining filters and
 * also general final implementation of the {@code run()} method.
 * <p>Classes, that extends this base filter should implement
 * protected method {@code runInternal()} with the same
 * as {@code run()} method syntax to process only own filter
 * feature, but not chained filters too.
 *
 * @see Filter
 *
 * @author Ruslan Khmelyuk
 * @since 2009-01-08 01:53
 */
public abstract class AbstractFilter<_T> implements Filter<_T> {

    /**
     * The list of filters.
     */
    private List<Filter<_T>> filters;

    /**
     * Run only filtering of current filter on specified collection.
     * The incoming collection is always not null and not empty.
     *
     * @param collection the incoming collection, than need to be filtered.
     * @return the filtered collection.
     */
    protected abstract Collection<_T> runInternal(Collection<_T> collection);

    /**
     * Run filter for incoming collection {@code ts}.
     *
     * @param ts the incoming collection; can't be null.
     * @return the result of filtering.
     */
    public final Collection<_T> run(Collection<_T> ts) {
        ArgumentAssert.isNotNull(ts, "Collection can't be null.");

        if (ts.isEmpty()) return ts;

        Collection<_T> result = runInternal(ts);

        if (CollectionUtils.isNotEmpty(result)
                && CollectionUtils.isNotEmpty(filters))
        {
            for (Filter<_T> each : filters) {
                result = each.run(result);
                if (result == null || result.isEmpty()) break;
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public Filter<_T> then(Filter<_T> nextFilter) {
        ArgumentAssert.isNotNull(nextFilter, "Next filter should be not null.");

        if (filters == null) {
            filters = new ArrayList<Filter<_T>>();
        }
        filters.add(nextFilter);

        return this;
    }
}
