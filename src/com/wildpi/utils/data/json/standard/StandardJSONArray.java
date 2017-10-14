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

import com.wildpi.utils.data.json.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Standard implementation of {@link JSONArray}
 *
 * @author Alex
 */
public class StandardJSONArray extends AbstractJSONValue<List<JSONValue>> implements JSONArray
{
    @Override
    public void add(JSONValue value)
    {
        values.add(value);
    }

    @Override
    public void addAt(JSONValue value, int index)
    {
        values.add(index, value);
    }

    @Override
    public JSONObject getObjectAt(int index)
    {
        return (JSONObject) values.get(index);
    }

    @Override
    public JSONArray getArrayAt(int index)
    {
        return (JSONArray) values.get(index);
    }

    @Override
    public JSONString getStringAt(int index)
    {
        return (JSONString) values.get(index);
    }

    @Override
    public JSONLong getLongAt(int index)
    {
        return (JSONLong) values.get(index);
    }

    @Override
    public JSONDouble getDoubleAt(int index)
    {
        return (JSONDouble) values.get(index);
    }

    @Override
    public JSONBoolean getBooleanAt(int index)
    {
        return (JSONBoolean) values.get(index);
    }

    @Override
    public boolean isNullAt(int index)
    {
        return values.get(index) instanceof JSONNull;
    }

    @Override
    public int size()
    {
        return values.size();
    }

    @Override
    public String serialize()
    {
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0; i < values.size(); i++)
        {
            if(i > 0)
                sb.append(",");

            sb.append(values.get(i).serialize());
        }

        sb.append("]");

        return sb.toString();
    }

    @Override
    protected List<JSONValue> getValue()
    {
        return values;
    }

    private List<JSONValue> values = new ArrayList<>();
}
