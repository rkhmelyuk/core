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

package com.prutsoft.core.test;

import com.prutsoft.core.Ref;

/**
 * The test case for the {@link com.prutsoft.core.Ref} type.
 *
 * @author Ruslan Khmelyuk
 * @since 2009-12-20
 */
public class RefTestCase extends BaseTestCase {

    public void testRef() {
        Ref<Integer> ref = new Ref<Integer>(10);
        assertEquals(Integer.valueOf(10), ref.getValue());
    }

    public void testDeReferenceDeep() {
        Ref<Integer> ref1 = new Ref<Integer>(10);
        Ref<Ref> ref2 = new Ref<Ref>(ref1);
        Ref<Ref> ref3 = new Ref<Ref>(ref2);
        Ref<Ref> ref4 = new Ref<Ref>(ref3);

        assertEquals(Integer.valueOf(10), ref4.deReference());
    }

    public void testDeReferenceSingle() {
        Ref<Integer> ref = new Ref<Integer>(10);
        assertEquals(Integer.valueOf(10), ref.deReference());
    }
}
