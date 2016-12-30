package json.model;

import json.TestHelper;
import json.model.values.JSONValue;
import json.model.values.NumberJSONValue;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleJSONPairTest
{
    @Test
    public void testEquality()
    {
        SimpleJSONPair p1 = new SimpleJSONPair("name", new NumberJSONValue(1));
        SimpleJSONPair p2 = new SimpleJSONPair("name", new NumberJSONValue(1));
        SimpleJSONPair q1 = new SimpleJSONPair("name", new NumberJSONValue(2));
        SimpleJSONPair q2 = new SimpleJSONPair("hello", new NumberJSONValue(1));

        TestHelper.equalityAndHashcodeChecker(p1, p2, q1, q2);
    }

    @Test
    public void preserveName()
    {
        String name = "name";
        assertThat("JSON pair should preserve name", new SimpleJSONPair(name, new NumberJSONValue(1)).getName(), is(name));
    }

    @Test
    public void preserveValue()
    {
        JSONValue value = new NumberJSONValue(1);
        assertThat("JSON pair should preserve name", new SimpleJSONPair("name", value).getValue(), is(value));
    }
}
