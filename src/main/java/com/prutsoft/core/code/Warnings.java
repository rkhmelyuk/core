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

package com.prutsoft.core.code;

/**
 * The type of compiler and IDE warnings.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2008-8-13 22:50
 */
public interface Warnings {

    /**
     * Unchecked operation.
     */
    String Unchecked = "unchecked";

    /**
     * JavaDoc is not defined or is not complete.
     * (IntellijIdea specific).
     */
    String JavaDoc = "javaDoc";

    /**
     * Used deprecated API.
     */
    String Deprecation = "deprecation";

    /**
     * Serial version UID is not specified.
     * (Eclipse specific).
     */
    String Serial = "serial";

    /**
     * Unused declaration of type, method, argument etc.
     */
    String UnusedDeclaration = "UnusedDeclaration";

}
