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

import java.util.ArrayList;
import java.util.Collection;

/**
 * Filters only not null collection elements. In result always will get
 * collection with not null elements.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev$
 * @since 2009-01-08 22:18
 */
public final class NotNull<_T> extends AbstractFilter<_T> {

    protected Collection<_T> runInternal(Collection<_T> ts) {

        Collection<_T> result = new ArrayList<_T>(ts.size());
        for (_T each : ts) {
            if (each != null) result.add(each);
        }

        return result;
    }

}
