package json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONArray extends AbstractSimpleJSONValue<List<JSONValue>> implements JSONArray
{
    @Override
    public void addJSONValue(JSONValue value)
    {
        values.add(value);
    }

    @Override
    public void addJSONValueAt(JSONValue value, int index)
    {
        values.add(index, value);
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

    @Override
    public int size()
    {
        return values.size();
    }

    @Override
    public String serialize()
    {
        StringBuilder sb = new StringBuilder("[");

        for(int i = 0; i < values.size(); i++)
        {
            if(i > 0)
                sb.append(",");

            sb.append(values.get(i).serialize());
        }

        sb.append("]");

        return sb.toString();
    }

    @Override
    protected List<JSONValue> getValue()
    {
        return values;
    }

    private List<JSONValue> values = new ArrayList<>();
}
