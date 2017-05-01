package integrate.values;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONArray implements JSONArray
{
    @Override
    public void addJSONValue(JSONValue value)
    {
        values.add(value);
    }

    @Override
    public JSONObject getObjectAt(int index)
    {
        return (JSONObject) values.get(index);
    }

    @Override
    public JSONArray getArrayAt(int index)
    {
        return (JSONArray) values.get(index);
    }

    @Override
    public JSONString getStringAt(int index)
    {
        return (JSONString) values.get(index);
    }

    @Override
    public JSONLong getLongAt(int index)
    {
        return (JSONLong) values.get(index);
    }

    @Override
    public JSONDouble getDoubleAt(int index)
    {
        return (JSONDouble) values.get(index);
    }

    @Override
    public JSONBoolean getBooleanAt(int index)
    {
        return (JSONBoolean) values.get(index);
    }

    @Override
    public boolean isNullAt(int index)
    {
        return values.get(index) instanceof JSONNull;
    }

    private List<JSONValue> values = new ArrayList<>();
}
