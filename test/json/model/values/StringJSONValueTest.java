package json.model.values;

import json.TestHelper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringJSONValueTest extends JSONValueTestBase
{
    @Override
    protected JSONValue getJSONValue()
    {
        return new StringJSONValue("Hello");
    }

    @Override
    public void testValue()
    {
        assertThat("String JSON values should maintain their value", getJSONValue().getValue(), is("Hello"));
    }

    @Override
    public void testStringCheck()
    {
        assertThat("JSON value should not be a string", getJSONValue().isString());
    }

    @Test
    public void testEqualityAndHashcode()
    {
        StringJSONValue s1 = new StringJSONValue("Hello");
        StringJSONValue s2 = new StringJSONValue("Hello");
        StringJSONValue t = new StringJSONValue("hello");

        TestHelper.equalityAndHashcodeChecker(s1, s2, t);
    }
}
