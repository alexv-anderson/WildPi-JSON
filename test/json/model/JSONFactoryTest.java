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
        assertThat("An empty JSON object should have no members", JSONFactory.getEmptyJSONObject().getMembers().size(), is(0));
    }

    @Test
    public void testEmptyArray()
    {
        assertThat("An empty JSON array should have no elements", JSONFactory.getEmptyJSONArray().getElements().size(), is(0));
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
}
