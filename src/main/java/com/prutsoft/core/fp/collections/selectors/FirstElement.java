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

package com.prutsoft.core.fp.collections.selectors;

import com.prutsoft.core.fp.Function;

import java.util.Collection;

/**
 * The selector of the first collection element.
 * If collection is {@code null} or empty then {@code null} is returned.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2009-01-05 01:50
 */
public class FirstElement<T> implements Function<Collection<T>, T> {

    public T run(Collection<T> ts) {
        if (ts != null && !ts.isEmpty()) {
            for (T first : ts) {
                return first;
            }
        }
        return null;
    }
}
