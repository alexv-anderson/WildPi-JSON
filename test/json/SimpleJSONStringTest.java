package json;

import json.JSONString;
import json.SimpleJSONString;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleJSONStringTest
{
    @Test
    public void testToString()
    {
        String s = "hello \" hello";
        JSONString jsonString = new SimpleJSONString(s);
        assertThat("Did not preserve string", jsonString.toString(), is(s));
    }

    @Test
    public void testSerialize()
    {
        String value = "hello \" hello", jsonValue = "\"hello \\\" hello\"";
        JSONString jsonString = new SimpleJSONString(value);

        assertThat("Did not correctly serialize JSON string", jsonString.serialize(), is(jsonValue));
    }

    @Test
    public void testValue()
    {
        assertThat("Did not pass the correct value", new SimpleJSONString("hello \" hello").getValue(), is("hello \" hello"));
    }
}
