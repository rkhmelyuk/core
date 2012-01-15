/*
 * Copyright 2008-2012 Ruslan Khmelyuk.
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

package com.khmelyuk.core.utils;

import com.khmelyuk.core.BaseTestCase;

/**
 * @author Ruslan Khmelyuk
 * @since 1.0.2, 2009-05-30
 */
public class ConversionUtilsTestCase extends BaseTestCase {

    public void testGetIntValue() {        
        assertNull(ConversionUtils.getInteger(null));
        assertEquals(123, ConversionUtils.getInteger("123").intValue());
        assertEquals(123, ConversionUtils.getInteger("123", 80).intValue());
        assertEquals(80, ConversionUtils.getInteger("asdf", 80).intValue());
        assertNull(ConversionUtils.getInteger("asdf", null));
    }

    public void testGetDoubleValue() {
        assertNull(ConversionUtils.getDouble(null));
        assertEquals(123d, ConversionUtils.getDouble("123").doubleValue());
        assertEquals(123d, ConversionUtils.getDouble("123", 80d).doubleValue());
        assertEquals(80d, ConversionUtils.getDouble("asdf", 80d).doubleValue());
        assertNull(ConversionUtils.getDouble("asdf", null));
    }

    public void testGetFloatValue() {
        assertNull(ConversionUtils.getFloat(null));
        assertEquals(123f, ConversionUtils.getFloat("123").floatValue());
        assertEquals(123f, ConversionUtils.getFloat("123", 80f).floatValue());
        assertEquals(80f, ConversionUtils.getFloat("asdf", 80f).floatValue());
        assertNull(ConversionUtils.getFloat("asdf", null));
    }

    public void testGetBooleanValue() {
        assertNull(ConversionUtils.getFloat(null));
        assertFalse(ConversionUtils.getBoolean("123"));
        assertFalse(ConversionUtils.getBoolean("123", true));
        assertFalse(ConversionUtils.getBoolean("123", false));
        assertTrue(ConversionUtils.getBoolean("true", false));
    }
}
