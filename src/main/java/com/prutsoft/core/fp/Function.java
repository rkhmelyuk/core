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

package com.prutsoft.core.fp;

/**
 * This is simple functor with one argument.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2009-01-05 01:00
 */
public interface Function<_Value, _Result> {

    _Result run(_Value value);

}
