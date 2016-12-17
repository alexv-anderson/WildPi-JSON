package json.model;

import json.model.values.JSONValue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 12/17/2016.
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
