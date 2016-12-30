package json.model.values;

import json.model.JSONObject;

/**
 * Represents a {@link JSONObject} which is the the value of a name-value pair
 *
 * @author Alex
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
