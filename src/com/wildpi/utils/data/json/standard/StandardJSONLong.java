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

import com.wildpi.utils.data.json.JSONLong;

/**
 * Standard implementation of {@link JSONLong}
 *
 * @author Alex
 */
public class StandardJSONLong extends AbstractJSONValue<Long> implements JSONLong
{
    public StandardJSONLong(long value)
    {
        this.value = value;
    }

    @Override
    public long toLong()
    {
        return value;
    }

    @Override
    public int toInt()
    {
        return (int) value;
    }

    @Override
    public String serialize()
    {
        return Long.toString(value);
    }

    @Override
    protected Long getValue()
    {
        return value;
    }

    private long value;
}
