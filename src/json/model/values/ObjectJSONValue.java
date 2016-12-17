package json.model.values;

import json.model.JSONObject;

/**
 * Created by Alex on 12/17/2016.
 */
public class ObjectJSONValue implements JSONValue<JSONObject>
{
    public ObjectJSONValue(JSONObject jsonObject)
    {
        this.jsonObject = jsonObject;
    }

    @Override
    public JSONObject getValue()
    {
        return jsonObject;
    }

    private JSONObject jsonObject;
}
