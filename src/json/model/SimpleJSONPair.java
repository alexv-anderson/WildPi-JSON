package json.model;

import json.model.values.JSONValue;

/**
 * Created by Alex on 12/17/2016.
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
