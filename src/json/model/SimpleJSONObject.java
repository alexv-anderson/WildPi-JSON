package json.model;

import json.model.values.JSONValue;

import java.util.HashMap;
import java.util.List;

/**
 * A simple bare-bones implementation of {@link JSONObject}
 *
 * @author Alex
 */
class SimpleJSONObject implements JSONObject
{
    public SimpleJSONObject()
    {
        this.nameToValueMap = new HashMap<>();
    }
    public SimpleJSONObject(List<JSONPair> pairs)
    {
        this.nameToValueMap = new HashMap<>();

        pairs.forEach(this::put);
    }

    @Override
    public void put(JSONPair pair)
    {
        put(pair.getName(), pair.getValue());
    }

    @Override
    public void put(String name, JSONValue value)
    {
        nameToValueMap.put(name, value);
    }

    @Override
    public JSONValue get(String name)
    {
        return nameToValueMap.get(name);
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        SimpleJSONObject that = (SimpleJSONObject) o;

        return nameToValueMap.equals(that.nameToValueMap);

    }

    @Override
    public int hashCode()
    {
        return nameToValueMap.hashCode();
    }

    private HashMap<String, JSONValue> nameToValueMap;
}
