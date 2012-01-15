/*
 * Copyright 2008-2012 Ruslan Khmelyuk.
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

import com.khmelyuk.core.asserts.ArgumentAssert;

import java.io.InputStream;

/**
 * Utils for working with class loader and loading resources etc.
 *
 * @author Ruslan Khmelyuk
 * @since 2008-8-19 23:5
 */
public class ClassLoaderUtils {

    /**
     * Loads the resource as {@code InputStream} and returns it.
     * The resource is specified by parameter {@code resource} and
     * used class loader of class {@code clazz}.
     *
     * @param resource the name of resource; can't be null or empty.
     * @param clazz the class used to get classloader; can't be null.
     * @return the input stream for loaded resource.
     */
    public static InputStream loadResource(String resource, Class<?> clazz) {
        ArgumentAssert.isNotEmpty(resource, "Resource cannot be null or empty.");
        ArgumentAssert.isNotNull(clazz, "Class cannot be null.");

        return clazz.getClassLoader().getResourceAsStream(resource);
    }

    /**
     * Loads the resource as {@code InputStream} and returns it.
     * The resource is specified by parameter {@code resource} and
     * used class loader given by parameter {@code classLoader}.
     *
     * @param resource the name of resource; can't be null or empty.
     * @param classLoader the class loader; can't be null.
     * @return the input stream for loaded resource.
     */
    public static InputStream loadResource(String resource, ClassLoader classLoader) {
        ArgumentAssert.isNotEmpty(resource, "Resource cannot be null or empty.");
        ArgumentAssert.isNotNull(classLoader, "Class loader cannot be null.");

        return classLoader.getResourceAsStream(resource);
    }
}
