package json;

import json.model.JSONArray;
import json.model.JSONFactory;
import json.model.JSONObject;
import json.model.values.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class JSONModelParserTest
{
    @Test
    public void parseEmptyObject()
    {
        String emptyJSON = "{}";
        assertThat(emptyJSON + " should parse to an empty object", JSONModelParser.parseJSON(emptyJSON), is(JSONFactory.getEmptyJSONObject()));
    }

    @Test
    public void parseSingleNumber()
    {
        String positiveInteger = "{ \"name\": 1 }";
        String negativeInteger = "{ \"name\": -1 }";
        String positiveDouble = "{ \"name\": 1.0 }";
        String negativeDouble = "{ \"name\": -1.0 }";
        testSingleParse(JSONModelParser.parseJSON(positiveInteger), "name", NumberJSONValue.class, 1);
        testSingleParse(JSONModelParser.parseJSON(negativeInteger), "name", NumberJSONValue.class, -1);
        testSingleParse(JSONModelParser.parseJSON(positiveDouble), "name", NumberJSONValue.class, 1.0);
        testSingleParse(JSONModelParser.parseJSON(negativeDouble), "name", NumberJSONValue.class, -1.0);
    }
    @Test
    public void parseSingleTrue()
    {
        String json = "{ \"name\": true }";
        testSingleParse(JSONModelParser.parseJSON(json), "name", BooleanJSONValue.class, true);
    }
    @Test
    public void parseSingleFalse()
    {
        String json = "{ \"name\": false }";
        testSingleParse(JSONModelParser.parseJSON(json), "name", BooleanJSONValue.class, false);
    }
    @Test
    public void parseSingleNull()
    {
        JSONObject jObject = JSONModelParser.parseJSON("{ \"name\": null }");

        JSONValue parsedValue = jObject.get("name");
        assertThat("Name: \"name\" was not found in the object", parsedValue, is(notNullValue()));
        assertThat("Value should be a NullJSONValue", parsedValue, is(instanceOf(NullJSONValue.class)));
        assertThat("Value should not change", parsedValue.getValue(), is(nullValue()));
    }
    @Test
    public void parseSingleString()
    {
        String json = "{ \"name\": \"string\" }";
        testSingleParse(JSONModelParser.parseJSON(json), "name", StringJSONValue.class, "string");
    }
    @Test
    public void parseSingleEmptyArray()
    {
        String json = "{ \"name\": [] }";
        testSingleParse(JSONModelParser.parseJSON(json), "name", ArrayJSONValue.class, JSONFactory.getEmptyJSONArray());
    }
    @Test
    public void parseSingleEmptyObject()
    {
        String json = "{ \"name\": {} }";
        testSingleParse(JSONModelParser.parseJSON(json), "name", ObjectJSONValue.class, JSONFactory.getEmptyJSONObject());
    }

    @Test
    public void parseSingleFullArray()
    {
        String json = "{ \"name\": [1, 2, -1] }";
        JSONArray jArray = JSONFactory.getEmptyJSONArray();
        jArray.getElements().add(new NumberJSONValue(1));
        jArray.getElements().add(new NumberJSONValue(2));
        jArray.getElements().add(new NumberJSONValue(-1));

        testSingleParse(JSONModelParser.parseJSON(json), "name", ArrayJSONValue.class, jArray);
    }

    @Test
    public void parseSingleFullObject()
    {
        String json = "{ \"name\": { \"name2\": 1 } }";
        JSONObject jObject = JSONFactory.getEmptyJSONObject();
        jObject.put("name2", new NumberJSONValue(1));

        testSingleParse(JSONModelParser.parseJSON(json), "name", ObjectJSONValue.class, jObject);
    }

    private void testSingleParse(JSONObject jObject, String name, Class valueClass, Object value)
    {
        JSONValue parsedValue = jObject.get(name);
        assertThat("Name: \"" + name + "\" was not found in the object", parsedValue, is(notNullValue()));
        assertThat("Value should be a " + valueClass.getName(), parsedValue, is(instanceOf(valueClass)));
        assertThat("Value should not change", parsedValue.getValue(), is(value));
    }
}
