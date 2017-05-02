package integrate.values;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleJSONObjectTest
{
    @Test
    public void testObject()
    {
        JSONObject innerObject = new SimpleJSONObject();
        innerObject.put("key", new SimpleJSONNull());
        JSONObject outerObject = new SimpleJSONObject();
        outerObject.put("key", innerObject);

        assertThat("\"key\" should be mapped to a JSON object", outerObject.getObject("key"), is(innerObject));
    }

    @Test
    public void testArray()
    {
        JSONArray array = new SimpleJSONArray();
        array.addJSONValue(new SimpleJSONNull());
        JSONObject outerObject = new SimpleJSONObject();
        outerObject.put("key", array);

        assertThat("\"key\" should be mapped to a JSON array", outerObject.getArray("key"), is(array));
    }

    @Test
    public void testString()
    {
        JSONString value = new SimpleJSONString("hello \" hello");
        JSONObject outerObject = new SimpleJSONObject();
        outerObject.put("key", value);

        assertThat("\"key\" should be mapped to a JSON string", outerObject.getString("key"), is(value));
    }

    @Test
    public void testDouble()
    {
        JSONDouble value = new SimpleJSONDouble(Double.MAX_VALUE);
        JSONObject outerObject = new SimpleJSONObject();
        outerObject.put("key", value);

        assertThat("\"key\" should be mapped to a JSON double", outerObject.getDouble("key"), is(value));
    }

    @Test
    public void testLong()
    {
        JSONLong value = new SimpleJSONLong(Long.MAX_VALUE);
        JSONObject outerObject = new SimpleJSONObject();
        outerObject.put("key", value);

        assertThat("\"key\" should be mapped to a JSON double", outerObject.getLong("key"), is(value));
    }

    @Test
    public void testBoolean()
    {
        JSONBoolean value = new SimpleJSONBoolean(true);
        JSONObject outerObject = new SimpleJSONObject();
        outerObject.put("key", value);

        assertThat("\"key\" should be mapped to a JSON long", outerObject.getBoolean("key"), is(value));
    }

    @Test
    public void testNull()
    {
        JSONObject outerObject = new SimpleJSONObject();
        outerObject.put("key", new SimpleJSONNull());

        assertThat("\"key\" should be mapped to a JSON long", outerObject.isNull("key"));
    }

    //region Serialization
    @Test
    public void testEmptyObject()
    {
        JSONObject object = new SimpleJSONObject();

        assertThat("Did not correctly serialize empty object", object.serialize(), is("{}"));
    }

    @Test
    public void testSinglePairObject()
    {
        JSONObject object = new SimpleJSONObject();
        object.put("key", new SimpleJSONNull());

        assertThat("Did not correctly serialize single pair object", object.serialize(), is("{\"key\":null}"));
    }

    @Test
    public void testDualPairObject()
    {
        JSONObject object = new SimpleJSONObject();
        object.put("key1", new SimpleJSONNull());
        object.put("key2", new SimpleJSONNull());
        assertThat("Did not correctly serialize dual pair object", object.serialize(), is("{\"key1\":null,\"key2\":null}"));
    }
    //endregion

    @Test
    public void testValue()
    {
        Map<String, JSONValue> map = new HashMap<>();
        map.put("key1", new SimpleJSONNull());
        map.put("key2", new SimpleJSONNull());

        SimpleJSONObject object = new SimpleJSONObject();
        for(Map.Entry<String, JSONValue> entry : map.entrySet())
            object.put(entry.getKey(), entry.getValue());

        assertThat("Incorrect value from JSON object", object.getValue(), is(map));
    }
}
