/*
 *  Copyright 2017 Alex Anderson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wildpi.utils.data.json;

/**
 * Marks an object that represents a boolean JSON value.
 *
 * Some examples would be:
 * {
 *     "thisIsTrue" : true,
 *     "thisIsFalse" : false
 * }
 *
 * @author Alex
 */
public interface JSONBoolean extends JSONValue
{
    /**
     * Indicates if the JSON value is true
     * @return True if the value is true, else false
     */
    public boolean isTrue();

    /**
     * Indicates if the JSON value is false
     *
     * Note this is the same as NOT {@link JSONBoolean#isTrue()}
     * @return True if the original value was false, else false
     */
    public boolean isFalse();

    /**
     * Supplies the actual boolean value which was parse from the JSON
     * @return The actual boolean value
     */
    public boolean toBoolean();
}
