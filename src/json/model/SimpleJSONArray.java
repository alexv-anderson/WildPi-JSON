package json.model;

import json.model.values.JSONValue;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple bare-bones implementation of {@link JSONArray}
 *
 * @author Alex
 */
class SimpleJSONArray implements JSONArray
{
    public SimpleJSONArray()
    {
        this.values = new LinkedList<>();
    }

    public SimpleJSONArray(List<JSONValue> values)
    {
        this.values = new LinkedList<>(values);
    }

    @Override
    public List<JSONValue> getElements()
    {
        return values;
    }

    private List<JSONValue> values;
}
