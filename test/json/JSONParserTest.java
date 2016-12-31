package json;

import json.model.JSONArray;
import json.model.JSONFactory;
import json.model.JSONObject;
import json.model.values.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class JSONParserTest
{
    @Test
    public void parseEmptyObject()
    {
        String emptyJSON = "{}";
        assertThat(emptyJSON + " should parse to an empty object", JSONParser.parseJSON(emptyJSON), is(JSONFactory.getEmptyJSONObject()));
    }

    @Test
    public void parseSingleNumber()
    {
        String positiveInteger = "{ \"name\": 1 }";
        String negativeInteger = "{ \"name\": -1 }";
        String positiveDouble = "{ \"name\": 1.0 }";
        String negativeDouble = "{ \"name\": -1.0 }";
        testSingleParse(JSONParser.parseJSON(positiveInteger), "name", NumberJSONValue.class, 1);
        testSingleParse(JSONParser.parseJSON(negativeInteger), "name", NumberJSONValue.class, -1);
        testSingleParse(JSONParser.parseJSON(positiveDouble), "name", NumberJSONValue.class, 1.0);
        testSingleParse(JSONParser.parseJSON(negativeDouble), "name", NumberJSONValue.class, -1.0);
    }
    @Test
    public void parseSingleTrue()
    {
        String json = "{ \"name\": true }";
        testSingleParse(JSONParser.parseJSON(json), "name", BooleanJSONValue.class, true);
    }
    @Test
    public void parseSingleFalse()
    {
        String json = "{ \"name\": false }";
        testSingleParse(JSONParser.parseJSON(json), "name", BooleanJSONValue.class, false);
    }
    @Test
    public void parseSingleNull()
    {
        JSONObject jObject = JSONParser.parseJSON("{ \"name\": null }");

        JSONValue parsedValue = jObject.get("name");
        assertThat("Name: \"name\" was not found in the object", parsedValue, is(notNullValue()));
        assertThat("Value should be a NullJSONValue", parsedValue, is(instanceOf(NullJSONValue.class)));
        assertThat("Value should not change", parsedValue.getValue(), is(nullValue()));
    }
    @Test
    public void parseSingleString()
    {
        String json = "{ \"name\": \"string\" }";
        testSingleParse(JSONParser.parseJSON(json), "name", StringJSONValue.class, "string");
    }
    @Test
    public void parseSingleEmptyArray()
    {
        String json = "{ \"name\": [] }";
        testSingleParse(JSONParser.parseJSON(json), "name", ArrayJSONValue.class, JSONFactory.getEmptyJSONArray());
    }
    @Test
    public void parseSingleEmptyObject()
    {
        String json = "{ \"name\": {} }";
        testSingleParse(JSONParser.parseJSON(json), "name", ObjectJSONValue.class, JSONFactory.getEmptyJSONObject());
    }
    @Test
    public void parseSingleFullArray()
    {
        String json = "{ \"name\": [1, 2, -1] }";
        JSONArray jArray = JSONFactory.getEmptyJSONArray();
        jArray.getElements().add(new NumberJSONValue(1));
        jArray.getElements().add(new NumberJSONValue(2));
        jArray.getElements().add(new NumberJSONValue(-1));

        testSingleParse(JSONParser.parseJSON(json), "name", ArrayJSONValue.class, jArray);
    }
    @Test
    public void parseSingleFullObject()
    {
        String json = "{ \"name\": { \"name2\": 1 } }";
        JSONObject jObject = JSONFactory.getEmptyJSONObject();
        jObject.put("name2", new NumberJSONValue(1));

        testSingleParse(JSONParser.parseJSON(json), "name", ObjectJSONValue.class, jObject);
    }

    private void testSingleParse(JSONObject jObject, String name, Class valueClass, Object value)
    {
        JSONValue parsedValue = jObject.get(name);
        assertThat("Name: \"" + name + "\" was not found in the object", parsedValue, is(notNullValue()));
        assertThat("Value should be a " + valueClass.getName(), parsedValue, is(instanceOf(valueClass)));
        assertThat("Value should not change", parsedValue.getValue(), is(value));
    }

    @Test
    public void parseTwoWithArray()
    {
        String json = "{ \"name\": [ 1, 2 ], \"name2\": 1 }";

        JSONArray jsonArray = JSONFactory.getEmptyJSONArray();
        jsonArray.getElements().add(new NumberJSONValue(1));
        jsonArray.getElements().add(new NumberJSONValue(2));
        JSONObject jsonObject = JSONFactory.getEmptyJSONObject();
        jsonObject.put("name", new ArrayJSONValue(jsonArray));
        jsonObject.put("name2", new NumberJSONValue(1));

        assertThat("Identical JOSN Objects should be equal", JSONParser.parseJSON(json), is(jsonObject));
    }

    @Test
    public void parseTwoWithObject()
    {
        String json = "{ \"name\": { \"name3\": 2 }, \"name2\": 1 }";

        JSONObject innerOb = JSONFactory.getEmptyJSONObject();
        innerOb.put("name3", new NumberJSONValue(2));
        JSONObject jsonObject = JSONFactory.getEmptyJSONObject();
        jsonObject.put("name", new ObjectJSONValue(innerOb));
        jsonObject.put("name2", new NumberJSONValue(1));

        assertThat("Identical JSON Objects should be equal", JSONParser.parseJSON(json), is(jsonObject));
    }

    @Test
    public void parseArrayThenObject()
    {
        String json = "{ \"name\": [ 1 ], \"name2\": { \"name3\": 2 } }";

        JSONArray array = JSONFactory.getEmptyJSONArray();
        array.getElements().add(new NumberJSONValue(1));
        JSONObject innerOb = JSONFactory.getEmptyJSONObject();
        innerOb.put("name3", new NumberJSONValue(2));
        JSONObject outerOb = JSONFactory.getEmptyJSONObject();
        outerOb.put("name", new ArrayJSONValue(array));
        outerOb.put("name2", new ObjectJSONValue(innerOb));

        assertThat("Identical JSON Objects should be equal", JSONParser.parseJSON(json), is(outerOb));
    }

    @Test
    public void parseObjectThenArray()
    {
        String json = "{ \"name2\": { \"name3\": 2 }, \"name\": [ 1 ] }";

        JSONArray array = JSONFactory.getEmptyJSONArray();
        array.getElements().add(new NumberJSONValue(1));
        JSONObject innerOb = JSONFactory.getEmptyJSONObject();
        innerOb.put("name3", new NumberJSONValue(2));
        JSONObject outerOb = JSONFactory.getEmptyJSONObject();
        outerOb.put("name", new ArrayJSONValue(array));
        outerOb.put("name2", new ObjectJSONValue(innerOb));

        assertThat("Identical JSON Objects should be equal", JSONParser.parseJSON(json), is(outerOb));
    }

    @Test
    public void testConstruction()
    {
        JSONParser parser = new JSONParser();
    }
}
