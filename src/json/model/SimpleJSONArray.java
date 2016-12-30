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

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        SimpleJSONArray that = (SimpleJSONArray) o;

        return values.equals(that.values);

    }

    @Override
    public int hashCode()
    {
        return values.hashCode();
    }

    private List<JSONValue> values;
}
