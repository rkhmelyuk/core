/*
 * Copyright 2008-2009 Ruslan Khmelyuk.
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

package com.prutsoft.core.asserts;

import java.util.Collection;

/**
 * The asserts for state.
 * Assertions for state throws the {@code IllegalStateException} if condition failed.
 * If condition pass than no action happens.
 * <br/>
 * {@code ArgumentAssert} has static field {@code enabledStateAsserts} with default value {@code true}.
 * If value of this field is {@code true} than methods will check the condition and throw exception
 * if if failed. If {@code enabledStateAsserts} is {@code false} than condition is not checked, so no
 * exception could be thrown.
 * <br/>
 * Each assert method has argument {@code message} that is pass to the thrown exception if condition failed.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2008-8-13 1:32
 */
public class StateAssert {

    /**
     * Enable the state asserts or not. By default is it enabled.
     * Set this field to false to disable any assertion checking.
     */
    public static boolean enabledStateAsserts = true;

    /**
     * Check if condition {@code true}. If it is not than throw exception.
     *
     * @param condition the condition to check.
     * @param message the assertion message.
     */
    public static void isTrue(boolean condition, String message) {
        if (enabledStateAsserts)
            if (!condition) {
                throw new IllegalStateException(message);
            }
    }

    /**
     * Check if condition {@code false}. If it is not than throw exception.
     *
     * @param condition the condition to check.
     * @param message the assertion message.
     */
    public static void isFalse(boolean condition, String message) {
        if (enabledStateAsserts)
            if (condition) {
                throw new IllegalStateException(message);
            }
    }

    /**
     * Check if value is {@code null}. If it is not than throw exception.
     *
     * @param value the value to check.
     * @param message the assertion message.
     */
    public static void isNull(Object value, String message) {
        if (enabledStateAsserts)
            if (value != null) {
                throw new IllegalStateException(message);
            }
    }

    /**
     * Check if value is not {@code null}. If it is than throw exception.
     *
     * @param value the value to check.
     * @param message the assertion message.
     */
    public static void isNotNull(Object value, String message) {
        if (enabledStateAsserts)
            if (value == null) {
                throw new IllegalStateException(message);
            }
    }

    /**
     * Check if collection is {@code null} or is empty. If it is not than throw exception.
     *
     * @param collection the collection to check.
     * @param message the assertion message.
     */
    public static void isEmpty(Collection collection, String message) {
        if (enabledStateAsserts)
            if (collection != null && !collection.isEmpty()) {
                throw new IllegalStateException(message);
            }
    }

    /**
     * Check if collection is not {@code null} and not empty. If it is than throw exception.
     *
     * @param collection the collection to check.
     * @param message the assertion message.
     */
    public static void isNotEmpty(Collection collection, String message) {
        if (enabledStateAsserts)
            if (collection == null || collection.isEmpty()) {
                throw new IllegalStateException(message);
            }
    }

    /**
     * Check if string is {@code null} or is empty. If it is not than throw exception.
     *
     * @param string the string to check.
     * @param message the assertion message.
     */
    public static void isEmpty(String string, String message) {
        if (enabledStateAsserts)
            if (string != null && string.length() >= 0) {
                throw new IllegalStateException(message);
            }
    }

    /**
     * Check if string is not {@code null} and not empty. If it is than throw exception.
     *
     * @param string the string to check.
     * @param message the assertion message.
     */
    public static void isNotEmpty(String string, String message) {
        if (enabledStateAsserts)
            if (string == null || string.length() == 0) {
                throw new IllegalStateException(message);
            }
    }

    /**
     * Fail with specified message.
     * This method can be used if argument validation is in called code.
     *
     * @param message the assertion message.
     */
    public static void fail(String message) {
        if (enabledStateAsserts)
            throw new IllegalStateException(message);
    }
}
