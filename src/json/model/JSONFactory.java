package json.model;

import json.model.values.JSONValue;

/**
 * Factory for creating simple JSON objects, arrays, and pairs
 *
 * @author Alex
 */
public class JSONFactory
{
    /**
     * Constructs an empty {@link JSONObject}
     * @return An empty {@link JSONObject}
     */
    public static JSONObject getEmptyJSONObject()
    {
        return new SimpleJSONObject();
    }

    /**
     * Constructs an empty {@link JSONArray}
     * @return An empty {@link JSONArray}
     */
    public static JSONArray getEmptyJSONArray()
    {
        return new SimpleJSONArray();
    }

    /**
     * Creates a pairing between a {@link JSONValue} and a name
     * @param name     The pair's name
     * @param value    The pair's value
     * @param <T>      The value's type
     * @return A {@link JSONPair} with the given name and value
     */
    public static <T> JSONPair<T> getJSONPair(String name, JSONValue<T> value)
    {
        return new SimpleJSONPair<>(name, value);
    }
}
