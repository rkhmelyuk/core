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

package com.khmelyuk.core.state.checked;

import com.khmelyuk.core.utils.ObjectUtils;

import java.io.Serializable;

/**
 * Represents value that supports also checked state.
 * Checked state - is a boolean state, so value may be checked or unchecked.
 *
 * @author Ruslan Khmelyuk
 * @since 2009-01-25 01:03
 */
public class CheckedValue<_Value> implements Serializable {

    private boolean checked;
    private _Value value;

    public CheckedValue() {
        checked = false;
        value = null;
    }

    public CheckedValue(_Value value) {
        this.checked = false;
        this.value = value;
    }

    public CheckedValue(boolean checked, _Value value) {
        this.checked = checked;
        this.value = value;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public _Value getValue() {
        return value;
    }

    public void setValue(_Value value) {
        this.value = value;
    }

    public void check() {
        this.checked = true;
    }

    public void uncheck() {
        this.checked = false;
    }

    // -------------------------------------------- override Object methods

    @Override
    public int hashCode() {
        return ObjectUtils.hashCode(checked) + value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return false;
        if (o == null || !(o instanceof CheckedValue)) return false;

        CheckedValue other = (CheckedValue) o;
        return (checked == other.checked && ObjectUtils.equals(value, other.value));
    }

    @Override
    public String toString() {
        return (checked ? "Checked[" : "Unchecked[") + String.valueOf(value) + "]";
    }
}
