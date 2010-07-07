/*
 * Copyright 2008-2009 Ruslan Khmelyuk, Prutsoft.
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
 * The interface for the resource that has order.
 *
 * @author Ruslan Khmelyuk
 * @since 1.0.2, 2009-12-20 21:47
 */
public interface Ordered {

    /**
     * The order of the element.
     * @return the integer value of the element order.
     */
    int getOrder();
}
