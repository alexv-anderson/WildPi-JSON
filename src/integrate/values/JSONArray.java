package integrate.values;

/**
 * Created by Alex on 4/27/2017.
 */
public interface JSONArray extends JSONValue
{
    public void addJSONValue(JSONValue value);

    public JSONObject getObjectAt(int index);
    public JSONArray getArrayAt(int index);
    public JSONString getStringAt(int index);
    public JSONLong getLongAt(int index);
    public JSONDouble getDoubleAt(int index);
    public JSONBoolean getBooleanAt(int index);
    public JSONNull getNullAt(int index);
}