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

package com.prutsoft.core.state.dirty;

/**
 * Enumaration of possible entity lifecycle states.
 * It can be new, modified or removed or unmodified.
 *
 * @author Ruslan Khmelyuk
 * @version $Rev: 25 $
 * @since 2008-09-25 20:52
 */
public enum DirtyState {

    /** The new entity is added state. */
    ADDED,

    /** The entity is modified state. */
    MODIFIED,

    /** The entity is removed state. */
    REMOVED,

    /** The entity is unmodified state. */
    UNMODIFIED
}
