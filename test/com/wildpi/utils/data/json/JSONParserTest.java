package com.wildpi.utils.data.json;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JSONParserTest
{
    //region Complex
    @Test
    public void testSubObject()
    {
        String objectKey = "object", valueKey = "value", value = "hello hello",
            json = " { \"" + objectKey + "\" : { \"" + valueKey + "\" : \"" + value + "\" } } ";

        JSONObject object = JSONParser.parse(json);
        JSONObject subObject = object.getObject(objectKey);
        assertThat("Did not correctly parse sub-object", subObject.getString(valueKey).toString(), is(value));
    }

    @Test
    public void testArray()
    {
        String key = "array", json = "{\"" + key + "\":[32,-32,32.0,-32.0,\"hello, hello\",{\"key\":null},null,true,false,[null]]}";

        JSONObject object = JSONParser.parse(json);

        assertThat("Did not correctly parse positive whole number in array", object.getArray(key).getLongAt(0).toInt(), is(32));
        assertThat("Did not correctly parse negative whole negative in array", object.getArray(key).getLongAt(1).toInt(), is(-32));
        assertThat("Did not correctly parse positive real number in array", object.getArray(key).getDoubleAt(2).toDouble(), is(32.0));
        assertThat("Did not correctly parse negative real number in array", object.getArray(key).getDoubleAt(3).toDouble(), is(-32.0));
        assertThat("Did not correctly parse string in array", object.getArray(key).getStringAt(4).toString(), is("hello, hello"));
        assertThat("Did not correctly parse object in array", object.getArray(key).getObjectAt(5).isNull("key"));
        assertThat("Did not correctly parse null in array", object.getArray(key).isNullAt(6));
        assertThat("Did not correctly parse true boolean in array", object.getArray(key).getBooleanAt(7).toBoolean(), is(true));
        assertThat("Did not correctly parse false boolean in array", object.getArray(key).getBooleanAt(8).toBoolean(), is(false));
        assertThat("Did not correctly parse array in array", object.getArray(key).getArrayAt(9).isNullAt(0));
    }

    @Test
    public void testFullObject()
    {
        String key = "object", json = " {" +
                "\"subObject\":{\"key\":null}," +
                "\"array\":[null]," +
                "\"null\":null," +
                "\"true\":true," +
                "\"false\":false," +
                "\"posWholeNum\":32," +
                "\"negWholeNum\":-32," +
                "\"posRealNum\":32.0," +
                "\"negRealNum\":-32.0," +
                "\"string\":\"hello: hello\"" +
                "}";

        JSONObject object = JSONParser.parse(json);

        assertThat("Did not correctly parse sub-object in object", object.getObject("subObject").isNull("key"));
        assertThat("Did not correctly parse array in object", object.getArray("array").isNullAt(0));
        assertThat("Did not correctly parse null in object", object.isNull("null"));
        assertThat("Did not correctly parse true boolean in object", object.getBoolean("true").toBoolean(), is(true));
        assertThat("Did not correctly parse false boolean in object", object.getBoolean("false").toBoolean(), is(false));
        assertThat("Did not correctly parse positive whole number in object", object.getLong("posWholeNum").toInt(), is(32));
        assertThat("Did not correctly parse negative whole number in object", object.getLong("negWholeNum").toInt(), is(-32));
        assertThat("Did not correctly parse positive real number in object", object.getDouble("posRealNum").toDouble(), is(32.0));
        assertThat("Did not correctly parse negative real number in object", object.getDouble("negRealNum").toDouble(), is(-32.0));
        assertThat("Did not correctly parse string in object", object.getString("string").toString(), is("hello: hello"));
    }
    //endregion

    //region Raw
    @Test
    public void testString()
    {
        String key = "greeting",
                jsonFormat = "Allow me to say, \\\"hello, JSON\\\"",
                parsedFormat = "Allow me to say, \"hello, JSON\"";
        String json = " { \"" + key + "\" : \"" + jsonFormat + "\" } ";

        JSONObject object = JSONParser.parse(json);
        assertThat("Did not correctly parse string value", object.getString(key).toString(), is(parsedFormat));
    }

    //region Numbers
    @Test
    public void testPositiveWholeNumber()
    {
        String key = "value", value = "32", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = JSONParser.parse(json);
        assertThat("Did not correctly parse positive whole number", object.getLong(key).toInt(), is(32));
    }
    @Test
    public void testNegativeWholeNumber()
    {
        String key = "value", value = "-32", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = JSONParser.parse(json);
        assertThat("Did not correctly parse positive whole number", object.getLong(key).toInt(), is(-32));
    }
    @Test
    public void testPositiveRealNumber()
    {
        String key = "value", value = "32.0", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = JSONParser.parse(json);
        assertThat("Did not correctly parse positive real number", object.getDouble(key).toDouble(), is(32.0));
    }
    @Test
    public void testNegativeRealNumber()
    {
        String key = "value", value = "-32.0", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = JSONParser.parse(json);
        assertThat("Did not correctly parse positive real number", object.getDouble(key).toDouble(), is(-32.0));
    }
    //endregion

    //region Boolean
    @Test
    public void testTrue()
    {
        boolean value = true;
        String key = "value", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = JSONParser.parse(json);
        assertThat("Did not correctly parse boolean true", object.getBoolean(key).toBoolean(), is(value));
    }
    @Test
    public void testFalse()
    {
        boolean value = false;
        String key = "value", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = JSONParser.parse(json);
        assertThat("Did not correctly parse boolean false", object.getBoolean(key).toBoolean(), is(value));
    }
    //endregion

    @Test
    public void testNull()
    {
        String key = "value", value = "null", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = JSONParser.parse(json);
        assertThat("Did not correctly parse null", object.isNull(key));
    }
    //endregion
}
