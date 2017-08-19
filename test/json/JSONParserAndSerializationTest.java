package json;

import json.standard.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JSONParserAndSerializationTest
{
    @Test
    public void testObject()
    {
        JSONObject originalObject = new StandardJSONObject();
        originalObject.put("key", new StandardJSONNull());

        assertThat("Incorrect serialization and parse of object", JSONParser.parse(originalObject.serialize()), is(originalObject));
    }

    @Test
    public void testArray()
    {
        String key = "key";
        JSONArray array = new StandardJSONArray();
        array.add(new StandardJSONNull());
        JSONObject object = new StandardJSONObject();
        object.put(key, array);

        assertThat("Incorrect serialziation and parse of array", JSONParser.parse(object.serialize()).getArray(key), is(array));
    }

    @Test
    public void testString()
    {
        String key = "key", value = "hello \" hello";
        JSONObject originalObject = new StandardJSONObject();
        originalObject.put(key, new StandardJSONString(value));

        assertThat("Incorrect serialization and parse of JSON string", JSONParser.parse(originalObject.serialize()).getString(key), is(new StandardJSONString("hello \" hello")));
    }

    @Test
    public void testDouble()
    {
        String lKey = "lessThanKey", gKey = "greaterThanKey";
        JSONDouble lValue = new StandardJSONDouble(Double.MIN_VALUE), gValue = new StandardJSONDouble(Double.MAX_VALUE);
        JSONObject originalObject = new StandardJSONObject();
        originalObject.put(lKey, lValue);
        originalObject.put(gKey, gValue);

        assertThat("Incorrect serialization and parse of negative double", JSONParser.parse(originalObject.serialize()).getDouble(lKey), is(lValue));
        assertThat("Incorrect serialization and parse of positive double", JSONParser.parse(originalObject.serialize()).getDouble(gKey), is(gValue));
    }

    @Test
    public void testLong()
    {
        String lKey = "lessThanKey", gKey = "greaterThanKey";
        JSONLong lValue = new StandardJSONLong(Long.MIN_VALUE), gValue = new StandardJSONLong(Long.MAX_VALUE);
        JSONObject originalObject = new StandardJSONObject();
        originalObject.put(lKey, lValue);
        originalObject.put(gKey, gValue);

        assertThat("Incorrect serialization and parse of negative long", JSONParser.parse(originalObject.serialize()).getLong(lKey), is(lValue));
        assertThat("Incorrect serialization and parse of positive long", JSONParser.parse(originalObject.serialize()).getLong(gKey), is(gValue));
    }

    @Test
    public void testBoolean()
    {
        String tKey = "trueKey", fKey = "falseKey";
        JSONBoolean tValue = new StandardJSONBoolean(true), fValue  = new StandardJSONBoolean(false);
        JSONObject originalObject = new StandardJSONObject();
        originalObject.put(tKey, tValue);
        originalObject.put(fKey, fValue);

        assertThat("Incorrect serialization and parse of true boolean", JSONParser.parse(originalObject.serialize()).getBoolean(tKey), is(tValue));
        assertThat("Incorrect serialization and parse of false boolean", JSONParser.parse(originalObject.serialize()).getBoolean(fKey), is(fValue));
    }

    @Test
    public void testNull()
    {
        String key = "key";
        JSONObject originalObject = new StandardJSONObject();
        originalObject.put(key, new StandardJSONNull());

        assertThat("Incorrect serialization and parse of object", JSONParser.parse(originalObject.serialize()).isNull(key));
    }
}
