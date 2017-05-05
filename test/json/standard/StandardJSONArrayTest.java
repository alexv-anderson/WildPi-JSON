package json.standard;

import json.*;
import json.standard.*;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StandardJSONArrayTest
{
    @Test
    public void testSize()
    {
        JSONArray array = new StandardJSONArray();
        array.addJSONValue(new StandardJSONNull());
        array.addJSONValue(new StandardJSONNull());

        assertThat("Incorrect array size", array.size(), is(2));
    }

    @Test
    public void testInsert()
    {
        JSONBoolean value = new StandardJSONBoolean(true);
        JSONArray array = new StandardJSONArray();
        array.addJSONValue(new StandardJSONNull());
        array.addJSONValue(new StandardJSONNull());
        array.addJSONValueAt(value, 1);

        assertThat("Incorrect insertion of value into array", array.getBooleanAt(1), is(value));
    }

    //region Add and Retrieve
    @Test
    public void testObject()
    {
        JSONObject object = new StandardJSONObject();
        object.put("key", new StandardJSONNull());
        JSONArray array = new StandardJSONArray();
        array.addJSONValue(object);

        assertThat("Should contain JSON object at zero", array.getObjectAt(0), is(object));
    }

    @Test
    public void testArray()
    {
        JSONArray outerArray = new StandardJSONArray();
        JSONArray innerArray = new StandardJSONArray();
        outerArray.addJSONValue(innerArray);

        assertThat("Should contain JSON array at zero", outerArray.getArrayAt(0), is(innerArray));
    }

    @Test
    public void testString()
    {
        JSONString s = new StandardJSONString("hello \" hello");
        JSONArray array = new StandardJSONArray();
        array.addJSONValue(s);

        assertThat("Should contain JSON string at zero", array.getStringAt(0), is(s));
    }

    @Test
    public void testDouble()
    {
        JSONDouble value = new StandardJSONDouble(Double.MAX_VALUE);
        JSONArray array = new StandardJSONArray();
        array.addJSONValue(value);

        assertThat("Should contain JSON double at zero", array.getDoubleAt(0), is(value));
    }

    @Test
    public void testLong()
    {
        JSONLong value = new StandardJSONLong(Long.MAX_VALUE);
        JSONArray array = new StandardJSONArray();
        array.addJSONValue(value);

        assertThat("Should contain JSON long at zero", array.getLongAt(0), is(value));
    }

    @Test
    public void testBoolean()
    {
        JSONBoolean value = new StandardJSONBoolean(true);
        JSONArray array = new StandardJSONArray();
        array.addJSONValue(value);

        assertThat("Should contain JSON boolean at zero", array.getBooleanAt(0), is(value));
    }

    @Test
    public void testNull()
    {
        JSONArray array = new StandardJSONArray();
        array.addJSONValue(new StandardJSONNull());

        assertThat("Should contain JSON null at zero", array.isNullAt(0));
    }
    //endregion

    //region Serialization
    @Test
    public void testEmptyArray()
    {
        JSONArray jsonArray = new StandardJSONArray();

        assertThat("Did not correctly serialize empty JSON array", jsonArray.serialize(), is("[]"));
    }

    @Test
    public void testSingleElementArray()
    {
        JSONArray jsonArray = new StandardJSONArray();
        jsonArray.addJSONValue(new StandardJSONNull());

        assertThat("Did not correctly serialize single element JSON array", jsonArray.serialize(), is("[null]"));
    }

    @Test
    public void testDoubleElementArray()
    {
        JSONArray jsonArray = new StandardJSONArray();
        jsonArray.addJSONValue(new StandardJSONNull());
        jsonArray.addJSONValue(new StandardJSONNull());

        assertThat("Did not correctly serialize single element JSON array", jsonArray.serialize(), is("[null,null]"));
    }
    //endregion

    @Test
    public void testValue()
    {
        List<JSONValue> list = new LinkedList<>();
        list.add(new StandardJSONNull());
        list.add(new StandardJSONNull());

        StandardJSONArray array = new StandardJSONArray();
        for(JSONValue value : list)
            array.addJSONValue(value);

        assertThat("Incorrect value from JSON array", array.getValue(), is(list));
    }
}
