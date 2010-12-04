/*
 * Copyright 2008-2009 Ruslan Khmelyuk.
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

package com.prutsoft.core.test.utils;

import com.prutsoft.core.test.BaseTestCase;
import com.prutsoft.core.utils.ValueUtils;

/**
 * @author Ruslan Khmelyuk
 * @since 1.0.2, 2009-12-20 20:34
 */
public class ValueUtilsTestCase extends BaseTestCase {

    public void testIfNull() {
        assertEquals(new Integer(10), ValueUtils.ifNull(null, 10));
        assertEquals(new Integer(10), ValueUtils.ifNull(10, 12));
        assertEquals(new Integer(10), ValueUtils.ifNull(10, 12));
        assertNotNull(ValueUtils.ifNull(10, null));
        assertNull(ValueUtils.ifNull(null, null));
    }

    public void testIfTrue() {
        assertEquals(new Integer(10), ValueUtils.ifTrue(true, 10));
        assertEquals(new Integer(12), ValueUtils.ifTrue(true, 12));
        assertNull(ValueUtils.ifTrue(true, null));
        assertNull(ValueUtils.ifTrue(false, null));
    }

    public void testIfFalse() {
        assertEquals(new Integer(10), ValueUtils.ifFalse(false, 10));
        assertEquals(new Integer(12), ValueUtils.ifFalse(false, 12));
        assertNull(ValueUtils.ifFalse(false, null));
        assertNull(ValueUtils.ifFalse(true, null));
    }
}
