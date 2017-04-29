package integrate.values;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONObject implements JSONObject
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
    public void put(String key, JSONValue value)
    {
        valueMap.put(key, value);
    }

    @Override
    public void put(String key, JSONObject value)
    {
        valueMap.put(key, value);
    }

    @Override
    public void put(String key, JSONArray value)
    {
        valueMap.put(key, value);
    }

    @Override
    public void put(String key, JSONString value)
    {
        valueMap.put(key, value);
    }

    @Override
    public void put(String key, JSONLong value)
    {
        valueMap.put(key, value);
    }

    @Override
    public void put(String key, JSONDouble value)
    {
        valueMap.put(key, value);
    }

    @Override
    public void put(String key, JSONBoolean value)
    {
        valueMap.put(key, value);
    }

    @Override
    public void put(String key, JSONNull value)
    {
        valueMap.put(key, value);
    }

    private Map<String, JSONValue> valueMap = new HashMap<>();
}
