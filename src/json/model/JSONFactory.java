package json.model;

import json.model.values.JSONValue;

/**
 * Created by Alex on 12/17/2016.
 */
public class JSONFactory
{
    public static JSONObject getEmptyJSONObject()
    {
        return new SimpleJSONObject();
    }

    public static <T> JSONArray<T> getEmptyJSONArray(Class<T> clazz)
    {
        return new SimpleJSONArray<>();
    }

    public static JSONPair getJSONPair(String name, JSONValue value)
    {
        return new SimpleJSONPair(name, value);
    }
}
