/*
 * Copyright 2008-2010 Ruslan Khmelyuk.
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

package com.khmelyuk.core.utils;

import com.khmelyuk.core.annotation.NotNull;
import com.khmelyuk.core.annotation.Nullable;
import com.khmelyuk.core.asserts.ArgumentAssert;

/**
 * The utils method to work with strings.
 *
 * @author Ruslan Khmelyuk
 * @since 2008-8-13 1:33
 */
public class StringUtils {

    /**
     * The line delimiter. It is OS specific.
     */
    public static final String NEWLINE = System.getProperty("line.separator");

    /**
     * Empty string in constant.
     */
    public static final String EMPTY = "";

    /**
     * Check whether string is {@code null} or it length is 0.
     *
     * @param string the string to check.
     * @return {@code true} if check pass, otherwise {@code false}.
     */
    public static boolean isEmpty(String string) {
        return (string == null || string.length() == 0);
    }

    /**
     * Check whether string is {@code null} or if it trimmed than length is 0.
     *
     * @param string the string to check.
     * @return {@code true} if check pass, otherwise {@code false}.
     */
    public static boolean isEmptyTrimmed(String string) {
        return (string == null || string.trim().length() == 0);
    }

    /**
     * Check whether string is not {@code null} and it length is not 0.
     *
     * @param string the string to check.
     * @return {@code true} if check pass, otherwise {@code false}.
     */
    public static boolean isNotEmpty(String string) {
        return (string != null && string.length() > 0);
    }

    /**
     * Check whether string is not {@code null} and if it trimmed than length is not 0.
     *
     * @param string the string to check.
     * @return {@code true} if check pass, otherwise {@code false}.
     */
    public static boolean isNotEmptyTrimmed(String string) {
        return (string != null && string.trim().length() > 0);
    }

    /**
     * Check whether string is not {@code null} and it length is 0.
     *
     * @param string the string to check.
     * @return {@code true} if check pass, otherwise {@code false}.
     */
    public static boolean isBlank(String string) {
        return (string != null && string.length() == 0);
    }

    /**
     * Check whether string is not {@code null} and if it trimmed than length is 0.
     *
     * @param string the string to check.
     * @return {@code true} if check pass, otherwise {@code false}.
     */
    public static boolean isBlankTrimmed(String string) {
        return (string != null && string.trim().length() == 0);
    }

    /**
     * Check whether string is not {@code null} and if it trimmed than length is not 0.
     *
     * @param string the string to check.
     * @return {@code true} if check pass, otherwise {@code false}.
     */
    public static boolean isNotBlankTrimmed(String string) {
        return (string != null && string.trim().length() > 0);
    }

    /**
     * Concatenate two and more strings.
     * If there are no arguments, then {@code null} is returned. If it is only one argument,
     * then it is returned.<br/>
     * In other case it will return the concatenation of all <i>not null</i> strings.
     * <br/>
     * The function returns empty string if all input strings are {@code null}.
     *
     * @param strings the strings to concatenate
     * @return the concatenated string.
     */
    public static String concatStrings(String... strings) {
        if (strings == null || strings.length == 0) {
            return null;
        }
        if (strings.length == 1) {
            return strings[0];
        }

        StringBuilder resultStringBuffer = new StringBuilder();
        for (String string : strings) {
            if (string != null) {
                resultStringBuffer.append(string);
            }
        }
        return resultStringBuffer.toString();
    }

    /**
     * Check the equivalence of input strings.
     * <br/>
     * If there are no input strings then result is {@code false}.
     * If there is 1 argument only then result of statement <code>arg1 != null</code> is the result of function.
     * If there are more then 1 arguments then check all of them for equivalence.
     *
     * @param strings the strings to check for equivalence.
     * @return {@code true} if check pass, otherwise {@code false}.
     */
    public static boolean equals(String... strings) {
        if (strings.length == 0) {
            return false;
        }
        else if (strings.length == 1) {
            return (strings[0] != null);
        }
        else {
            String firstString = strings[0];
            if (firstString == null) {
                return false;
            }
            for (int i = 1; i < strings.length; i++) {
                String current = strings[i];
                if (current == null || !current.equals(firstString)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Cut the string if it's size is greater then <code>maxLength</code> value and add the <code>suffix</code>
     * to the end of string. Cutting is made when the space (' ') character is placed; in such
     * case words are not break and stay complete.<br/>
     *
     * If <code>stringToCut</code> is <code>null</code>, that <code>null</code> will be returned.
     *
     * @param stringToCut the string to cut.
     * @param maxLength   the length to cut the string.
     * @param suffix      the suffix to add to the cut string; it cannot be null.
     * @return if string to cut length is greater than max length than returns cut string,
     *         otherwise returns the original string.
     */
    public static String cut(@NotNull String stringToCut, int maxLength, @NotNull String suffix) {
        if (stringToCut == null) {
            return null;
        }
        if (suffix == null) {
            return cut(stringToCut, maxLength);
        }

        if (StringUtils.isNotEmptyTrimmed(stringToCut)) {
            String shortDescription = stringToCut.trim();
            if (shortDescription.length() > maxLength) {
                // if greater than maxLength then cut it
                shortDescription = shortDescription.substring(0, maxLength);
                int lastIndex = shortDescription.lastIndexOf(" ");
                if (lastIndex != -1 && lastIndex < maxLength)
                    shortDescription = shortDescription.substring(0, lastIndex);
                return shortDescription.concat(suffix);
            }
        }
        return stringToCut;
    }

    /**
     * Cut string if it's length is more than specified by parameter <code>length</code>.
     * If string's length is less or equal to specified by parameter than incoming string will be returned.
     *
     * @param stringToCut the string to cut; cannot be null.
     * @param length      the length to cut the string.
     * @return the cut string if length is more than specified or incoming string otherwise.
     */
    public static String cut(String stringToCut, int length) {
        ArgumentAssert.isNotNull(stringToCut, "String to cut cannot be null.");

        if (stringToCut.length() <= length) return stringToCut;
        return stringToCut.substring(0, length);
    }

    /**
     * Gets the length of string.
     * This method is accurate with supplementary characters.
     * Read detail at <a href="http://java.sun.com/mailers/techtips/corejava/2006/tt0822.html">
     * Tech Tip #1: How long is your String object?</a>.
     *
     * @param string the string to get lengths for; cannot be null.
     * @return the length of string.
     */
    public static int getStringLength(String string) {
        ArgumentAssert.isNotNull(string, "String cannot be null.");
        if (string.length() == 0) return 0;
        return string.codePointCount(0, string.length());
    }

    /**
     * Checks whether string starts with specified prefix and if it is
     * then return string value that is after the prefix, otherwise returns null.
     *
     * @param string the string to check; can't be null; can't be null.
     * @param prefix the prefix; can't be null;
     * @return the string after prefix if prefix is matched, otherwise false.
     */
    public static String getStringWithPrefixValue(String string, String prefix) {
        ArgumentAssert.isNotNull(string, "String cannot be null.");
        ArgumentAssert.isNotNull(prefix, "Prefix cannot be null.");

        if (string.startsWith(prefix)) {
            return string.substring(prefix.length());
        }
        return null;
    }

    /**
     * Replace all not alphanumeric characters with specified {@code subs} character.
     *
     * @param string the string to replace chars in.
     * @param subs the char used as replacement.
     * @return the string with replaced not alphanumeric characters.
     */
    public static String replaceNotAlphaNumeric(String string, char subs) {
        ArgumentAssert.isNotNull(string, "String cannot be null.");

        if (string.isEmpty()) return string;

        StringBuilder result = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            else {
                result.append(subs);
            }
        }
        return result.toString();
    }

    /**
     * Replaces all not alphanumeric characters with {@code "_"} character.
     *
     * @param string the string to replace chars in; can't be null.
     * @return the string with replaced not alphanumeric characters.
     */
    public static String replaceNotAlphaNumeric(String string) {
        return replaceNotAlphaNumeric(string, '_');
    }

    /**
     * Trim the string if it's not null. If null, than return null value.
     * @param string the string to trim.
     * @return null if input string is null, otherwise trimmed input string. 
     */
    @Nullable
    public static String trimIfNotNull(@Nullable String string) {
        return (string == null ? null : string.trim());
    }

}
