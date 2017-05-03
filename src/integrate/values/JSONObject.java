package integrate.values;

import java.util.Set;

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
    public boolean isNull(String key);

    public Set<String> getKeySet();

    public void put(String key, JSONValue value);
}
