package json.standard;

import json.JSONString;
import json.standard.StandardJSONString;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StandardJSONStringTest
{
    @Test
    public void testToString()
    {
        String s = "hello \" hello";
        JSONString jsonString = new StandardJSONString(s);
        assertThat("Did not preserve string", jsonString.toString(), is(s));
    }

    @Test
    public void testSerialize()
    {
        String value = "hello \" hello", jsonValue = "\"hello \\\" hello\"";
        JSONString jsonString = new StandardJSONString(value);

        assertThat("Did not correctly serialize JSON string", jsonString.serialize(), is(jsonValue));
    }

    @Test
    public void testValue()
    {
        assertThat("Did not pass the correct value", new StandardJSONString("hello \" hello").getValue(), is("hello \" hello"));
    }
}
