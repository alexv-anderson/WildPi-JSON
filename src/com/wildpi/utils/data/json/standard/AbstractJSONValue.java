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

package com.wildpi.utils.data.json.standard;

/**
 * Parent class which handles basic equality and hash codes
 *
 * @param <V> The type of object which determines the object's overall equality.
 *
 * @author Alex
 */
abstract class AbstractJSONValue<V>
{
    /**
     * Supplies the value which determines the object's equality
     * @return The value which determines the object's equality
     */
    protected abstract V getValue();

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        AbstractJSONValue<?> that = (AbstractJSONValue<?>) o;

        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode()
    {
        return getValue().hashCode();
    }
}
