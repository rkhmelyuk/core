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

import com.prutsoft.core.utils.ObjectUtils;

import java.io.Serializable;

/**
 * The wrapper for values with dirty states.
 * The default value is null and dirty state is unmodified too.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2008-09-25 20:53
 */
public class DirtyWrapper<T> implements Serializable {

    private T value;
    private DirtyState state;

    public DirtyWrapper() {
        value = null;
        state = DirtyState.UNMODIFIED;
    }

    public DirtyWrapper(T value, DirtyState state) {
        this.value = value;
        this.state = state;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DirtyState getState() {
        return state;
    }

    public void setState(DirtyState state) {
        if (state == null) {
            throw new IllegalArgumentException("State can't be null. Please, specify correct enumerated value.");
        }
        this.state = state;
    }

    public boolean isModified() {
        return (this.value == DirtyState.MODIFIED);
    }

    public boolean isAdded() {
        return (this.value == DirtyState.ADDED);
    }

    public boolean isRemoved() {
        return (this.value == DirtyState.REMOVED);
    }

    @Override
    public int hashCode() {
        return (ObjectUtils.hashCode(value) + ObjectUtils.hashCode(state)) ^ 19;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DirtyWrapper) {
            DirtyWrapper that = (DirtyWrapper) obj;
            return ObjectUtils.equals(this.value, that.value) &&
                    ObjectUtils.equals(this.state, that.state);
        }
        return false;
    }
}
