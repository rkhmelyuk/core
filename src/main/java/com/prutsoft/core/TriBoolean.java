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

package com.prutsoft.core;

/**
 * The enumeration of three values:
 * <ul>
 *  <li>{@code TRUE} -  represents true. Method {@code isTrue()} returns {@code true},
 *                      other methods returns {@code false}.
 *  <li>{@code FALSE} - represents false. Method {@code isFalse()} returns {@code true},
 *                      other methods returns {@code false}.
 *  <li>{@code NONE} -  represents the state when not true and not false.
 *                      Method {@code isNone()} returns {@code true}, other methods returns {@code false}.
 * </ul>
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2008-8-23 3:19
 */
public enum TriBoolean {

    /**
     * The true value.
     */
    TRUE,

    /**
     * The false value.
     */
    FALSE,

    /**
     * Not true and not false.
     */
    NONE;

    /**
     * Check if current instance is {@code TRUE}.
     * @return returns true if current instance is {@code TRUE}, otherwise returns false.
     */
    public boolean isTrue() {
        return (this == TRUE);
    }

    /**
     * Check if current instance is {@code FALSE}.
     * @return returns true if current instance is {@code FALSE}, otherwise returns false.
     */
    public boolean isFalse() {
        return (this == FALSE);
    }

    /**
     * Check if current instance is {@code NONE}.
     * @return returns true if current instance is {@code NONE}, otherwise returns false.
     */
    public boolean isNone() {
        return (this == NONE);
    }

    /**
     * Gets the <code>java.util.Boolean</code> value.
     * If value is NONE then returns <code>null</code>.
     * @return the <code>java.util.Boolean</code> value.
     */
    public Boolean toBoolean() {
        if (this == TRUE) {
            return Boolean.TRUE;
        }
        else if (this == FALSE) {
            return Boolean.FALSE;
        }
        return null;
    }

    /**
     * Gets <code>TriBoolean</code> value from <code>java.util.Boolean</code> value.
     *
     * @param value the boolean value.
     * @return the appropriate <code>TriBoolean</code> value.
     */
    public static TriBoolean fromBoolean(Boolean value) {
        if (value == null) {
            return NONE;
        }
        return value ? TRUE : FALSE;
    }
}
