package json.model;

import json.model.values.JSONValue;
import json.model.values.NumberJSONValue;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JSONFactoryTest
{
    @Test
    public void testEmptyObject()
    {
        assertThat("Empty JSON object isn't", JSONFactory.getEmptyJSONObject(), is(new SimpleJSONObject()));
    }
    @Test
    public void testEmptyArray()
    {
        assertThat("Empty JSON array isn't", JSONFactory.getEmptyJSONArray(), is(new SimpleJSONArray()));
    }

    @Test
    public void testPairCreation()
    {
        String name = "name";
        JSONValue value = new NumberJSONValue(1);
        JSONPair pair = JSONFactory.getJSONPair(name, value);

        assertThat("JSON pair's name is incorrect", pair.getName(), is(name));
        assertThat("JSON pair's value is incorrect", pair.getValue(), is(value));
    }

    @Test
    public void testCreation()
    {
        JSONFactory factory = new JSONFactory();
    }
}
