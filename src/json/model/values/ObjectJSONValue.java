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

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        ObjectJSONValue that = (ObjectJSONValue) o;

        return jsonObject.equals(that.jsonObject);

    }

    @Override
    public int hashCode()
    {
        return jsonObject.hashCode();
    }

    private JSONObject jsonObject;
}
