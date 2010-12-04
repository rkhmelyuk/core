/*
 * Copyright 2008-2010 Ruslan Khmelyuk.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.prutsoft.core;

/**
 * Simple toString() builder implementation.
 *
 * @author Ruslan Khmelyuk
 * @since 1.0.3, 2010-01-04
 */
public class ToStringBuilder {

    private StringBuilder builder;
    private boolean first = true;
    private boolean finished = false;

    public ToStringBuilder(Class clazz, int length) {
        this(clazz.getSimpleName(), length);
    }

    public ToStringBuilder(Class clazz) {
        this(clazz.getSimpleName(), 32);
    }

    public ToStringBuilder(String name, int length) {
        this.builder = new StringBuilder(length);
        builder.append(name).append("[");
    }

    public ToStringBuilder(String name) {
        this(name, 32);
    }

    public ToStringBuilder field(String name, Object value) {
        if (!first) {
            builder.append(", ");
        }
        else {
            first = false;
        }
        builder.append(name).append("=").append(String.valueOf(value));

        return this;
    }

    @Override
    public String toString() {
        if (!finished) {
            builder.append("]");
            finished = true;
        }
        return builder.toString();
    }
}
