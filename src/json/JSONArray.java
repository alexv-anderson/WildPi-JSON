package json;

/**
 * Created by Alex on 4/27/2017.
 */
public interface JSONArray extends JSONValue
{
    public void addJSONValue(JSONValue value);
    public void addJSONValueAt(JSONValue value, int index);

    public JSONObject getObjectAt(int index);
    public JSONArray getArrayAt(int index);
    public JSONString getStringAt(int index);
    public JSONLong getLongAt(int index);
    public JSONDouble getDoubleAt(int index);
    public JSONBoolean getBooleanAt(int index);
    public boolean isNullAt(int index);

    public int size();
}
