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

import com.khmelyuk.core.utils.ObjectUtils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The filter that filters only for equal to specified value elements.
 * If element is not equal than specified as constructor value, then it will
 * be not added to result collection.
 *
 * @author Ruslan Khmelyuk
 * @since 2009-01-08 01:50
 */
public final class EqualTo<_T extends Comparable> extends AbstractFilter<_T> {

    /**
     * The value used to fitler collection.
     */
    private final _T value;

    public EqualTo(_T value) {
        this.value = value;
    }

    protected Collection<_T> runInternal(Collection<_T> ts) {
        Collection<_T> result = new ArrayList<_T>(ts.size());
        for (_T each : ts) {
            if (ObjectUtils.compareTo(each, value) == 0) {
                result.add(each);
            }
        }
        return result;
    }
}
