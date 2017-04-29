package integrate.values;

/**
 * Created by Alex on 4/27/2017.
 */
public interface JSONObject extends JSONValue
{
    public JSONObject getObject(String key);
    public JSONArray getArray(String key);
    public JSONString getString(String key);
    public JSONLong getLong(String key);
    public JSONDouble getDouble(String key);
    public JSONBoolean getBoolean(String key);

    public void put(String key, JSONValue value);
    public void put(String key, JSONObject value);
    public void put(String key, JSONArray value);
    public void put(String key, JSONString value);
    public void put(String key, JSONLong value);
    public void put(String key, JSONDouble value);
    public void put(String key, JSONBoolean value);
    public void put(String key, JSONNull value);
}
