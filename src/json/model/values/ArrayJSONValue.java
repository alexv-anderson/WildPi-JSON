package json.model.values;

import json.model.JSONArray;

/**
 * Created by Alex on 12/17/2016.
 */
public class ArrayJSONValue<T> implements JSONValue<JSONArray<T>>
{
    public ArrayJSONValue(JSONArray<T> jsonArray)
    {
        this.jsonArray = jsonArray;
    }

    @Override
    public JSONArray<T> getValue()
    {
        return jsonArray;
    }

    private JSONArray<T> jsonArray;
}
