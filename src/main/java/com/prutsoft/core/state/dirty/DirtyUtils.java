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

package com.prutsoft.core.state.dirty;

import com.prutsoft.core.asserts.ArgumentAssert;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * The utils to work with dirty wrappers.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2008-09-26 01:49
 */
public class DirtyUtils {

    /**
     * Gets the collection of dirty wrappers for specified input collection.
     * The dirty state is {@code DirtyState.UNMODIFIED}.
     *
     * @param values the collection of values; can't be null.
     * @return the dirty wrapped values.
     */
    public static <T> Collection<DirtyWrapper<T>> wrapValues(Collection<T> values) {
        return wrapValues(values, DirtyState.UNMODIFIED);
    }

    /**
     * Gets the collection of dirty wrappers for specified input collection.
     *
     * @param values the collection of values; can't be null.
     * @param defaultState the default dirty state; can't be null.
     * @return the dirty wrapped values.
     */
    public static <T> Collection<DirtyWrapper<T>> wrapValues(Collection<T> values, DirtyState defaultState) {
        ArgumentAssert.isNotNull(values, "Values can't be null.");
        ArgumentAssert.isNotNull(defaultState, "Dirty state can't be null.");

        List<DirtyWrapper<T>> result = new ArrayList<DirtyWrapper<T>>(values.size());
        for (T eachValue : values) {
            result.add(new DirtyWrapper<T>(eachValue, defaultState));
        }
        return result;
    }

    /**
     * Gets the collection of values from wrapped values.
     *
     * @param dirtyValues the collection of wrapped dirty values; can't be null.
     * @return the unwrapped values.
     */
    public static <T> Collection<T> unwrapValues(Collection<DirtyWrapper<T>> dirtyValues) {
        ArgumentAssert.isNotNull(dirtyValues, "Dirty values can't be null.");

        List<T> result = new ArrayList<T>(dirtyValues.size());
        for (DirtyWrapper<T> eachDirtyValue : dirtyValues) {
            result.add(eachDirtyValue.getValue());
        }
        return result;
    }

    /**
     * Gets the values from dirty wrapped collection that have specified dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty values; can't be null.
     * @param state the dirty state; can be null.
     * @return the collection with values that have specified state.
     */
    public static <T> Collection<T> getValuesWithState(Collection<DirtyWrapper<T>> dirtyValues, DirtyState state) {
        ArgumentAssert.isNotNull(dirtyValues, "Dirty values can't be null.");

        List<T> result = new ArrayList<T>(dirtyValues.size());
        for (DirtyWrapper<T> eachDirtyValue : dirtyValues) {
            if (eachDirtyValue.getState() == state) {
                result.add(eachDirtyValue.getValue());
            }
        }
        return result;
    }

    /**
     * Gets the values from dirty wrapped collection that haven't specified dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty values; can't be null.
     * @param state the dirty state; can be null.
     * @return the collection with values that haven't  specified state.
     */
    public static <T> Collection<T> getValuesWithoutState(Collection<DirtyWrapper<T>> dirtyValues, DirtyState state) {
        ArgumentAssert.isNotNull(dirtyValues, "Dirty values can't be null.");

        List<T> result = new ArrayList<T>(dirtyValues.size());
        for (DirtyWrapper<T> eachDirtyValue : dirtyValues) {
            if (eachDirtyValue.getState() != state) {
                result.add(eachDirtyValue.getValue());
            }
        }
        return result;
    }

    /**
     * Gets the values from dirty wrapped collection that have ADDED dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty values; can't be null.
     * @return the collection with values that have ADDED dirty state.
     */
    public static <T> Collection<T> getAddedValues(Collection<DirtyWrapper<T>> dirtyValues) {
        return getValuesWithState(dirtyValues, DirtyState.ADDED);
    }

    /**
     * Gets the values from dirty wrapped collection that have REMOVED dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty values; can't be null.
     * @return the collection with values that have REMOVED dirty state.
     */
    public static <T> Collection<T> getRemovedValues(Collection<DirtyWrapper<T>> dirtyValues) {
        return getValuesWithState(dirtyValues, DirtyState.REMOVED);
    }

    /**
     * Gets the values from dirty wrapped collection that have MODIFIED dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty values; can't be null.
     * @return the collection with values that have MODIFIED dirty state.
     */
    public static <T> Collection<T> getModifiedValues(Collection<DirtyWrapper<T>> dirtyValues) {
        return getValuesWithState(dirtyValues, DirtyState.MODIFIED);
    }

    /**
     * Gets the values from dirty wrapped collection that have UNMODIFIED dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty values; can't be null.
     * @return the collection with values that have UNMODIFIED dirty state.
     */
    public static <T> Collection<T> getUnmodifiedValues(Collection<DirtyWrapper<T>> dirtyValues) {
        return getValuesWithState(dirtyValues, DirtyState.UNMODIFIED);
    }

    /**
     * Gets the values from dirty wrapped collection that haven't UNMODIFIED dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty values; can't be null.
     * @return the collection with values that haven't UNMODIFIED dirty state.
     */
    public static <T> Collection<T> getValuesExceptUnmodified(Collection<DirtyWrapper<T>> dirtyValues) {
        return getValuesWithoutState(dirtyValues, DirtyState.UNMODIFIED);
    }

    /**
     * Gets the values from dirty map that have specified dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty values; can't be null.
     * @param state the dirty state; can be null.
     * @return the collection with values that have specified state.
     */
    public static <T> Collection<T> getValuesWithState(Map<T, DirtyState> dirtyValues, DirtyState state) {
        ArgumentAssert.isNotNull(dirtyValues, "Dirty values can't be null.");

        List<T> result = new ArrayList<T>(dirtyValues.size());
        for (Map.Entry<T, DirtyState> eachDirtyValue : dirtyValues.entrySet()) {
            if (eachDirtyValue.getValue() == state) {
                result.add(eachDirtyValue.getKey());
            }
        }
        return result;
    }

    /**
     * Gets the values from dirty map that haven't specified dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty values; can't be null.
     * @param state the dirty state; can be null.
     * @return the collection with values that haven't  specified state.
     */
    public static <T> Collection<T> getValuesWithoutState(Map<T, DirtyState> dirtyValues, DirtyState state) {
        ArgumentAssert.isNotNull(dirtyValues, "Dirty values can't be null.");

        List<T> result = new ArrayList<T>(dirtyValues.size());
        for (Map.Entry<T, DirtyState> eachDirtyValue : dirtyValues.entrySet()) {
            if (eachDirtyValue.getValue() != state) {
                result.add(eachDirtyValue.getKey());
            }
        }
        return result;
    }

    /**
     * Gets the values from dirty map that have ADDED dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the dirty map; can't be null.
     * @return the collection with values that have ADDED dirty state.
     */
    public static <T> Collection<T> getAddedValues(Map<T, DirtyState> dirtyValues) {
        return getValuesWithState(dirtyValues, DirtyState.ADDED);
    }

    /**
     * Gets the values from dirty map that have REMOVED dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty map; can't be null.
     * @return the collection with values that have REMOVED dirty state.
     */
    public static <T> Collection<T> getRemovedValues(Map<T, DirtyState> dirtyValues) {
        return getValuesWithState(dirtyValues, DirtyState.REMOVED);
    }

    /**
     * Gets the values from dirty map that have MODIFIED dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty map; can't be null.
     * @return the collection with values that have MODIFIED dirty state.
     */
    public static <T> Collection<T> getModifiedValues(Map<T, DirtyState> dirtyValues) {
        return getValuesWithState(dirtyValues, DirtyState.MODIFIED);
    }

    /**
     * Gets the values from dirty map that haven't UNMODIFIED dirty state.
     * If none is found than empty collection is returned.
     *
     * @param dirtyValues the collection of dirty map; can't be null.
     * @return the collection with values that haven't UNMODIFIED dirty state.
     */
    public static <T> Collection<T> getValuesExceptUnmodified(Map<T, DirtyState> dirtyValues) {
        return getValuesWithoutState(dirtyValues, DirtyState.UNMODIFIED);
    }
}
