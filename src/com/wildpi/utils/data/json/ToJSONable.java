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
 * Similar to {@link java.io.Serializable}, but uses {@link JSONObject}s instead of strings.
 *
 * Marks an object which can be transformed into a valid JSON string.
 *
 * @author Alex
 */
public interface ToJSONable
{
    /**
     * Supplies a {@link JSONObject} which represents the object.
     * @return A {@link JSONObject} which represents the object.
     */
    public JSONObject asJSON();
}
