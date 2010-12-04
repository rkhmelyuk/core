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
import com.prutsoft.core.utils.CalendarUtils;

/**
 * The test cases for {@link com.prutsoft.core.utils.CalendarUtils}.
 *
 * @author Ruslan Khmelyuk
 * @since 1.0.2, 2009-12-20 20:47
 */
public class CalendarUtilsTestCase extends BaseTestCase {

    public void testDaysInMonth() {
        assertEquals(31, CalendarUtils.daysInMonth(2009, 1));
        assertEquals(28, CalendarUtils.daysInMonth(2009, 2));
        assertEquals(29, CalendarUtils.daysInMonth(2008, 2));
        assertEquals(31, CalendarUtils.daysInMonth(2008, 3));
        assertEquals(30, CalendarUtils.daysInMonth(2008, 4));
    }

    public void testWithinRange() {
        assertTrue(CalendarUtils.isWithinRange(
                CalendarUtils.createDate(2009, 12, 20),
                CalendarUtils.createDate(2009, 12, 19),
                CalendarUtils.createDate(2009, 12, 21)));
        assertTrue(CalendarUtils.isWithinRange(
                CalendarUtils.createDate(2009, 12, 20),
                CalendarUtils.createDate(2009, 12, 19), null));
        assertTrue(CalendarUtils.isWithinRange(
                CalendarUtils.createDate(2009, 12, 20),
                null, CalendarUtils.createDate(2009, 12, 21)));

        assertFalse(CalendarUtils.isWithinRange(
                CalendarUtils.createDate(2009, 12, 20),
                CalendarUtils.createDate(2010, 12, 19),
                CalendarUtils.createDate(2010, 12, 21)));
        assertFalse(CalendarUtils.isWithinRange(
                CalendarUtils.createDate(2009, 12, 20),
                null, CalendarUtils.createDate(2009, 12, 20)));
        assertFalse(CalendarUtils.isWithinRange(
                CalendarUtils.createDate(2009, 12, 20),
                CalendarUtils.createDate(2009, 12, 20), null));
    }
}
