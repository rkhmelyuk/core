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

package com.prutsoft.core.test;

import com.prutsoft.core.ToStringBuilder;

/**
 * The test cases for the {@link com.prutsoft.core.ToStringBuilder}.
 *
 * @author Ruslan Khmelyuk
 * @since 2010-01-04
 */
public class ToStringBuilderTestCase extends BaseTestCase {

    public void testNothing() {
        ToStringBuilder builder = new ToStringBuilder("Test");
        assertEquals("Test[]", builder.toString());
    }

    public void testOneField() {
        ToStringBuilder builder = new ToStringBuilder("Test");
        builder.field("field", "value");
        assertEquals("Test[field=value]", builder.toString());
    }

    public void testNullField() {
        ToStringBuilder builder = new ToStringBuilder("Test");
        builder.field(null, "value");
        assertEquals("Test[null=value]", builder.toString());
    }

    public void testNullValue() {
        ToStringBuilder builder = new ToStringBuilder("Test");
        builder.field("field", null);
        assertEquals("Test[field=null]", builder.toString());
    }

    public void testNullFieldValue() {
        ToStringBuilder builder = new ToStringBuilder("Test");
        builder.field(null, null);
        assertEquals("Test[null=null]", builder.toString());
    }

    public void testFewNullFieldValues() {
        ToStringBuilder builder = new ToStringBuilder("Test");
        builder.field(null, null);
        builder.field(null, null);
        assertEquals("Test[null=null, null=null]", builder.toString());
    }

    public void testFewFields() {
        ToStringBuilder builder = new ToStringBuilder("Test");
        builder.field("field1", "value1");
        builder.field("field2", "value2");
        builder.field("field3", "value3");
        assertEquals("Test[field1=value1, field2=value2, field3=value3]", builder.toString());
    }

    public void testNullName() {
        ToStringBuilder builder = new ToStringBuilder((String) null);
        assertEquals("null[]", builder.toString());

        try {
            builder = new ToStringBuilder((Class) null);
            builder.toString();
            unexpected("Not field for null class");
        }
        catch (Exception e) {
            // that's OK
        }
    }
}
