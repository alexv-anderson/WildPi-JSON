package json.model.values;

import json.model.JSONArray;

/**
 * Represents a {@link JSONArray} which is the the value of a name-value pair
 *
 * @author Alex
 */
public class ArrayJSONValue implements JSONValue<JSONArray>
{
    public ArrayJSONValue(JSONArray jsonArray)
    {
        this.jsonArray = jsonArray;
    }

    @Override
    public JSONArray getValue()
    {
        return jsonArray;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        ArrayJSONValue that = (ArrayJSONValue) o;

        return jsonArray.equals(that.jsonArray);

    }

    @Override
    public int hashCode()
    {
        return jsonArray.hashCode();
    }

    private JSONArray jsonArray;
}
