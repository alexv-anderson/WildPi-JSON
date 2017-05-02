package integrate.values;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleJSONArrayTest
{
    @Test
    public void testObject()
    {
        JSONObject object = new SimpleJSONObject();
        object.put("key", new SimpleJSONNull());
        JSONArray array = new SimpleJSONArray();
        array.addJSONValue(object);

        assertThat("Should contain JSON object at zero", array.getObjectAt(0), is(object));
    }

    @Test
    public void testArray()
    {
        JSONArray outerArray = new SimpleJSONArray();
        JSONArray innerArray = new SimpleJSONArray();
        outerArray.addJSONValue(innerArray);

        assertThat("Should contain JSON array at zero", outerArray.getArrayAt(0), is(innerArray));
    }

    @Test
    public void testString()
    {
        JSONString s = new SimpleJSONString("hello \" hello");
        JSONArray array = new SimpleJSONArray();
        array.addJSONValue(s);

        assertThat("Should contain JSON string at zero", array.getStringAt(0), is(s));
    }

    @Test
    public void testDouble()
    {
        JSONDouble value = new SimpleJSONDouble(Double.MAX_VALUE);
        JSONArray array = new SimpleJSONArray();
        array.addJSONValue(value);

        assertThat("Should contain JSON double at zero", array.getDoubleAt(0), is(value));
    }

    @Test
    public void testLong()
    {
        JSONLong value = new SimpleJSONLong(Long.MAX_VALUE);
        JSONArray array = new SimpleJSONArray();
        array.addJSONValue(value);

        assertThat("Should contain JSON long at zero", array.getLongAt(0), is(value));
    }

    @Test
    public void testBoolean()
    {
        JSONBoolean value = new SimpleJSONBoolean(true);
        JSONArray array = new SimpleJSONArray();
        array.addJSONValue(value);

        assertThat("Should contain JSON boolean at zero", array.getBooleanAt(0), is(value));
    }

    @Test
    public void testNull()
    {
        JSONArray array = new SimpleJSONArray();
        array.addJSONValue(new SimpleJSONNull());

        assertThat("Should contain JSON null at zero", array.isNullAt(0));
    }

    //region Serialization
    @Test
    public void testEmptyArray()
    {
        JSONArray jsonArray = new SimpleJSONArray();

        assertThat("Did not correctly serialize empty JSON array", jsonArray.serialize(), is("[]"));
    }

    @Test
    public void testSingleElementArray()
    {
        JSONArray jsonArray = new SimpleJSONArray();
        jsonArray.addJSONValue(new SimpleJSONNull());

        assertThat("Did not correctly serialize single element JSON array", jsonArray.serialize(), is("[null]"));
    }

    @Test
    public void testDoubleElementArray()
    {
        JSONArray jsonArray = new SimpleJSONArray();
        jsonArray.addJSONValue(new SimpleJSONNull());
        jsonArray.addJSONValue(new SimpleJSONNull());

        assertThat("Did not correctly serialize single element JSON array", jsonArray.serialize(), is("[null,null]"));
    }
    //endregion

    @Test
    public void testValue()
    {
        List<JSONValue> list = new LinkedList<>();
        list.add(new SimpleJSONNull());
        list.add(new SimpleJSONNull());

        SimpleJSONArray array = new SimpleJSONArray();
        for(JSONValue value : list)
            array.addJSONValue(value);

        assertThat("Incorrect value from JSON array", array.getValue(), is(list));
    }
}
