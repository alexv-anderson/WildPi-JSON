package json;

import json.SimpleJSONNull;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleJSONNullTest
{
    @Test
    public void testSerialization()
    {
        assertThat("Did not correctly serialize null JSON value", new SimpleJSONNull().serialize(), is("null"));
    }
}
