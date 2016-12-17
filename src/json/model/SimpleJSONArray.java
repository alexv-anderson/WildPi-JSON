package json.model;

import json.model.values.JSONValue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 12/17/2016.
 */
public class SimpleJSONArray<T> implements JSONArray<T>
{
    public SimpleJSONArray()
    {
        this.values = new LinkedList<>();
    }

    public SimpleJSONArray(List<JSONValue<T>> values)
    {
        this.values = new LinkedList<>(values);
    }

    @Override
    public List<JSONValue<T>> getElements()
    {
        return values;
    }

    private List<JSONValue<T>> values;
}
