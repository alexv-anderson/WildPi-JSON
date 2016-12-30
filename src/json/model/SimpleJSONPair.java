package json.model;

import json.model.values.JSONValue;

/**
 * A simple bare-bones implementation of {@link JSONPair}
 *
 * @param <T>    The type of value stored in this pair.
 *
 * @author Alex
 */
class SimpleJSONPair<T> implements JSONPair<T>
{
    public SimpleJSONPair(String name, JSONValue<T> jsonValue)
    {
        this.name = name;
        this.jsonValue = jsonValue;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public JSONValue<T> getValue()
    {
        return jsonValue;
    }

    private String name;
    private JSONValue<T> jsonValue;
}
