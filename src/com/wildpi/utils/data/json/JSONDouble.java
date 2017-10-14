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
 * Marks an object that represents a double/decimal JSON value.
 *
 * Some examples would be:
 * {
 *     "value1" : 3.14159
 *     "value2" : -1.5e2
 * }
 *
 * @author Alex
 */
public interface JSONDouble extends JSONValue
{
    /**
     * Supplies the value as a double
     * @return The value as a double
     */
    public double toDouble();

    /**
     * Casts the value to a float and returns the value
     * @return The value as a float
     */
    public float toFloat();
}
