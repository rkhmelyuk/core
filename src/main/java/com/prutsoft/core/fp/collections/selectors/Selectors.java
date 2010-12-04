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

package com.prutsoft.core.fp.collections.selectors;

/**
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2009-01-05 02:03
 */
public class Selectors {

    private static final FirstElement firstElementSelector;
    private static final LastElement lastElementSelector;
    private static final MinElement minElementSelector;
    private static final MaxElement maxElementSelector;

    static {
        firstElementSelector = new FirstElement();
        lastElementSelector = new LastElement();
        minElementSelector = new MinElement();
        maxElementSelector = new MaxElement();
    }

    /**
     * Gets the first element selector.
     * @return the first element selector.
     */
    public static FirstElement firstElement() {
        return firstElementSelector;
    }

    /**
     * Gets the last element selector.
     * @return the last element selector.
     */
    public static LastElement lastElement() {
        return lastElementSelector;
    }

    /**
     * Gets the minimal element selector.
     * @return the minimal element selector.
     */
    public static MinElement minElement() {
        return minElementSelector;
    }

    /**
     * Gets the maximal element selector.
     * @return the maximal element selector.
     */
    public static MaxElement maxElement() {
        return maxElementSelector;
    }
}
