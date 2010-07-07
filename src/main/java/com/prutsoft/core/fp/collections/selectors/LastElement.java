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

package com.prutsoft.core.fp.collections.selectors;

import com.prutsoft.core.code.Warnings;
import com.prutsoft.core.fp.Function;

import java.util.Collection;
import java.util.List;
import java.util.SortedSet;

/**
 * The selector of the last collection element.
 * If collection is {@code null} or empty then {@code null} is returned.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2009-01-05 01:57
 */
public class LastElement<T> implements Function<Collection<T>, T> {

    @SuppressWarnings(Warnings.Unchecked)
    public T run(Collection<T> ts) {
        if (ts != null && !ts.isEmpty()) {
            if (ts instanceof List) {
                List list = (List) ts;
                return (T) list.get(list.size() - 1);
            }
            else if (ts instanceof SortedSet) {
                SortedSet set = (SortedSet) ts;
                return (T) set.last();
            }

            T last = null;
            for (T each : ts) {
                last = each;
            }
            return last;
        }
        return null;
    }
}
