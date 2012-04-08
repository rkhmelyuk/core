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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contains conversion tools for converting string to numbers, numbers to string etc.
 *
 * @author Ruslan Khmelyuk
 * @since 1.0.2, 2009-01-17 22:20
 */
public final class ConversionUtils {

    /**
     * Gets integer value from string. If string is {@code null} or empty or is not number
     * the returns {@code null}.
     * <p>
     * Calling this method is the same as {@code getIntValue(strValue, null);}.
     *
     * @param strValue the string value.
     * @return the integer value or {@code null}.
     */
    public static Integer getInteger(String strValue) {
        return getInteger(strValue, null);
    }

    /**
     * Gets integer value from string. If string is {@code null} or empty or is not number
     * the returns {@code defaultValue} value.
     *
     * @param strValue the string value.
     * @param defaultValue the default integer value if string is not integer or is empty.
     * @return the integer value or {@code defaultValue}.
     */
    public static Integer getInteger(String strValue, Integer defaultValue) {
        if (StringUtils.isEmpty(strValue) || "null".equals(strValue)) {
        	return defaultValue;
        }
        try {
            return Integer.valueOf(strValue);
        }
        catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Gets integer value from string and if it's not correct, than uses default value.
     * If result integer value is not within range from {@code min} to {@code max}, than
     * returns defaults value, otherwise result of getting integer from string using default value.
     *
     * @param strValue the string value to get as integer.
     * @param defaultValue the default value both for getting integer from string and range comparison.
     * @param min the minimum integer value.
     * @param max the maximum integer value.
     * @return the result integer value.
     */
    public static Integer getInteger(String strValue, Integer defaultValue, int min, int max) {
    	Integer intValue = getInteger(strValue, defaultValue);
    	if (intValue != null && (intValue < min || intValue > max)) {
    		return defaultValue;
    	}
    	return intValue;
    }

    /**
     * Gets double value from string. If string is {@code null} or empty or is not number
     * the returns {@code null}.
     * <p>
     * Calling this method is the same as {@code getDoubleValue(strValue, null);}.
     *
     * @param strValue the string value.
     * @return the double value or {@code null}.
     */
    public static Double getDouble(String strValue) {
    	return getDouble(strValue, null);
    }

    /**
     * Gets double value from string. If string is {@code null} or empty or is not number
     * the returns {@code defaultValue} value.
     *
     * @param strValue the string value.
     * @param defaultValue the default double value if string is not double or is empty.
     * @return the double value or {@code defaultValue}.
     */
    public static Double getDouble(String strValue, Double defaultValue) {
        if (StringUtils.isEmpty(strValue) || "null".equals(strValue)) {
            return defaultValue;
        }
        try {
            return Double.valueOf(strValue);
        }
        catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Gets double value from string and if it's not correct, than uses default value.
     * If result double value is not within range from {@code min} to {@code max}, than
     * returns defaults value, otherwise result of getting double from string using default value.
     *
     * @param strValue the string value to get as double.
     * @param defaultValue the default value both for getting double from string and range comparison.
     * @param min the minimum double value.
     * @param max the maximum double value.
     * @return the result double value.
     */
    public static Double getDouble(String strValue, Double defaultValue, double min, double max) {
    	Double value = getDouble(strValue, defaultValue);
    	if (value != null && (value < min || value > max)) {
    		return defaultValue;
    	}
    	return value;
    }

    /**
     * Gets float value from string. If string is {@code null} or empty or is not number
     * the returns {@code null}.
     * <p>
     * Calling this method is the same as {@code getFloatValue(strValue, null);}.
     *
     * @param strValue the string value.
     * @return the float value or {@code null}.
     */
    public static Float getFloat(String strValue) {
    	return getFloat(strValue, null);
    }

    /**
     * Gets float value from string. If string is {@code null} or empty or is not number
     * the returns {@code defaultValue} value.
     *
     * @param strValue the string value.
     * @param defaultValue the default float value if string is not float or is empty.
     * @return the float value or {@code defaultValue}.
     */
    public static Float getFloat(String strValue, Float defaultValue) {
        if (StringUtils.isEmpty(strValue) || "null".equals(strValue)) {
            return defaultValue;
        }
        try {
            return Float.valueOf(strValue);
        }
        catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Gets float value from string and if it's not correct, than uses default value.
     * If result float value is not within range from {@code min} to {@code max}, than
     * returns defaults value, otherwise result of getting float from string using default value.
     *
     * @param strValue the string value to get as double.
     * @param defaultValue the default value both for getting float from string and range comparison.
     * @param min the minimum float value.
     * @param max the maximum float value.
     * @return the result float value.
     */
    public static Float getFloat(String strValue, Float defaultValue, double min, double max) {
    	Float value = getFloat(strValue, defaultValue);
    	if (value != null && (value < min || value > max)) {
    		return defaultValue;
    	}
    	return value;
    }

    /**
     * Gets boolean value from string. If string is {@code null} or empty or is not boolean
     * Gets boolean value from string. If string is {@code null} or empty or is not boolean
     * the returns {@code null}.
     * <p>
     * Calling this method is the same as {@code getIntValue(strValue, null);}.
     *
     * @param strValue the string value.
     * @return the boolean value or {@code null}.
     */
    public static Boolean getBoolean(String strValue) {
        return getBoolean(strValue, null);
    }

    /**
     * Gets boolean value from string. If string is {@code null} or empty or is not boolean
     * the returns {@code defaultValue} value.
     *
     * @param strValue the string value.
     * @param defaultValue the default boolean value if string is not boolean or is empty.
     * @return the boolean value or {@code defaultValue}.
     */
    public static Boolean getBoolean(String strValue, Boolean defaultValue) {
        if (StringUtils.isEmpty(strValue) || "null".equals(strValue)) {
        	return defaultValue;
        }
        try {
            return Boolean.valueOf(strValue);
        }
        catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Gets long value from string. If string is {@code null} or empty or is not number
     * the returns {@code null}.
     * <p>
     * Calling this method is the same as {@code getLong(strValue, null);}.
     *
     * @param strValue the string value.
     * @return the long value or {@code null}.
     */
    public static Long getLong(String strValue) {
        return getLong(strValue, null);
    }

    /**
     * Gets long value from string. If string is {@code null} or empty or is not number
     * the returns {@code defaultValue} value.
     *
     * @param strValue the string value.
     * @param defaultValue the default integer value if string is not long or is empty.
     * @return the long value or {@code defaultValue}.
     */
    public static Long getLong(String strValue, Long defaultValue) {
        if (StringUtils.isEmpty(strValue) || "null".equals(strValue)) {
        	return defaultValue;
        }
        try {
            return Long.valueOf(strValue);
        }
        catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * Gets long value from string and if it's not correct, than uses default value.
     * If result long value is not within range from {@code min} to {@code max}, than
     * returns defaults value, otherwise result of getting long from string using default value.
     *
     * @param strValue the string value to get as long.
     * @param defaultValue the default value both for getting long from string and range comparison.
     * @param min the minimum long value.
     * @param max the maximum long value.
     * @return the result long value.
     */
    public static Long getLong(String strValue, Long defaultValue, long min, long max) {
    	Long longValue = getLong(strValue, defaultValue);
    	if (longValue != null && (longValue < min || longValue > max)) {
    		return defaultValue;
    	}
    	return longValue;
    }

    /**
     * Gets the date as result of parsing {@code value} using {@code pattern}.
     * If value or pattern are not specified than {@code defaultDate} will be returned.
     * If value is not correct date than {@code defaultDate} will be returned.
     * @param value the date as string value.
     * @param pattern the pattern used to parse date.
     * @param defaultDate the default date.
     * @return the parsed date.
     */
    public static Date getDate(String value, String pattern, Date defaultDate) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(pattern)) {
            return defaultDate;
        }

        try {
            return new SimpleDateFormat(pattern).parse(value);
        }
        catch (Exception e) {
            return defaultDate;
        }
    }
}
