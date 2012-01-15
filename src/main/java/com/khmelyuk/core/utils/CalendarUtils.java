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

import com.khmelyuk.core.asserts.ArgumentAssert;
import com.khmelyuk.core.code.Warnings;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Ruslan Khmelyuk
 * @since 1.0.2, 2009-01-17 22:18
 */
public class CalendarUtils {

    /**
     * Gets current date.
     *
     * @return the current date.
     */
    public static Calendar now() {
        return Calendar.getInstance();
    }

    /**
     * Changes input calendar by resetting time fields to 0.
     *
     * @param calendar the calendar to change; can't be null.
     * @return the changed calendar.
     */
    public static Calendar dateOnly(Calendar calendar) {
        ArgumentAssert.isNotNull(calendar, "Calendar can't be null.");

        calendar.set(Calendar.HOUR, calendar.getMinimum(Calendar.HOUR));
        calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getMinimum(Calendar.MILLISECOND));

        return calendar;
    }

    /**
     * Changes input calendar by resetting time fields to the begin of day.
     *
     * @param calendar the calendar to change; can't be null.
     * @return the changed calendar.
     */
    public static Calendar dayBeginTime(Calendar calendar) {
        calendar.set(Calendar.HOUR, calendar.getMinimum(Calendar.HOUR));
        calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getMinimum(Calendar.MILLISECOND));

        return calendar;
    }

    /**
     * Changes input calendar by resetting time fields to the end of day.
     *
     * @param calendar the calendar to change; can't be null.
     * @return the changed calendar.
     */
    public static Calendar dayEndTime(Calendar calendar) {
        calendar.set(Calendar.HOUR, calendar.getMaximum(Calendar.HOUR));
        calendar.set(Calendar.MINUTE, calendar.getMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getMaximum(Calendar.MILLISECOND));

        return calendar;
    }

    /**
     * Create date with specified year, month and day.
     * The time is set to {@code 00:00:00}.
     *
     * @param year  the year.
     * @param month the month.
     * @param day   the day.
     * @return the date.
     */
    @SuppressWarnings(Warnings.Deprecation)
    public static Calendar dateOf(int year, int month, int day) {
        Calendar result = Calendar.getInstance();
        result.set(Calendar.YEAR, year);
        result.set(Calendar.MONTH, month - 1);
        result.set(Calendar.DATE, day);
        result.set(Calendar.HOUR_OF_DAY, 0);
        result.set(Calendar.MINUTE, 0);
        result.set(Calendar.SECOND, 0);
        result.set(Calendar.MILLISECOND, 0);
        return result;
    }

    /**
     * Creates date with specified year, month and day.
     * The time is set to {@code 00:00:00}.
     *
     * @param year  the year.
     * @param month the month.
     * @param day   the day.
     * @return the date.
     */
    @SuppressWarnings(Warnings.Deprecation)
    public static Date createDate(int year, int month, int day) {
        return createCalendar(year, month, day).getTime();
    }

    /**
     * Creates calendar with specified year, month and day.
     * The time is set to {@code 00:00:00}.
     *
     * @param year  the year.
     * @param month the month.
     * @param day   the day.
     * @return the calendar.
     */
    @SuppressWarnings(Warnings.Deprecation)
    public static Calendar createCalendar(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static int currentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int currentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    public static int currentDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static int daysInMonth(int year, int month) {
        return createCalendar(year, month, 1)
                .getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * Checks whether date is within range.
     * Range can't be opened, ie from or to can be null, but not both.
     *
     * @param date the date to check whether within range; can't be null.
     * @param from the range from date.
     * @param to the range to value.
     * @return <code>true</code> if date is within range, otherwise <code>false</code>.
     */
    public static boolean isWithinRange(Date date, Date from, Date to) {
        ArgumentAssert.isNotNull(date, "Date is required.");
        ArgumentAssert.isTrue(from != null || to != null, "Either From or To date is required.");

        return (from == null || date.after(from)) &&
                 (to == null || date.before(to));
    }

}
