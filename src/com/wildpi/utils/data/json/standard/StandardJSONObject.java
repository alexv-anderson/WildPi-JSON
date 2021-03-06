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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Standard implementation of {@link JSONObject}
 *
 * @author Alex
 */
public class StandardJSONObject extends AbstractJSONValue<Map<String, JSONValue>> implements JSONObject
{
    @Override
    public JSONObject getObject(String key)
    {
        return (JSONObject) valueMap.get(key);
    }

    @Override
    public JSONArray getArray(String key)
    {
        return (JSONArray) valueMap.get(key);
    }

    @Override
    public JSONString getString(String key)
    {
        return (JSONString) valueMap.get(key);
    }

    @Override
    public JSONLong getLong(String key)
    {
        return (JSONLong) valueMap.get(key);
    }

    @Override
    public JSONDouble getDouble(String key)
    {
        return (JSONDouble) valueMap.get(key);
    }

    @Override
    public JSONBoolean getBoolean(String key)
    {
        return (JSONBoolean) valueMap.get(key);
    }

    @Override
    public boolean isNull(String key)
    {
        return valueMap.get(key) instanceof JSONNull;
    }

    @Override
    public Set<String> getKeySet()
    {
        return valueMap.keySet();
    }

    @Override
    public void put(String key, JSONValue value)
    {
        valueMap.put(key, value);
    }

    @Override
    public String serialize()
    {
        StringBuilder sb = new StringBuilder("{");

        boolean isFirst = true;
        for(Map.Entry<String, JSONValue> entry : valueMap.entrySet())
        {
            if(!isFirst)
                sb.append(",");
            else
                isFirst = false;

            sb.append("\"");
            sb.append(entry.getKey());
            sb.append("\":");
            sb.append(entry.getValue().serialize());
        }

        sb.append("}");

        return sb.toString();
    }

    @Override
    protected Map<String, JSONValue> getValue()
    {
        return valueMap;
    }

    private Map<String, JSONValue> valueMap = new HashMap<>();
}
