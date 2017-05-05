package json.standard;

import json.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Standard implementation of {@link JSONObject}
 *
 * @author Alex
 */
public class StandardJSONObject extends AbstractSimpleJSONValue<Map<String, JSONValue>> implements JSONObject
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
