package json.model.values;

import json.model.JSONArray;

/**
 * Created by Alex on 12/17/2016.
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

    private JSONArray jsonArray;
}
