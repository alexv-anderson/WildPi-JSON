package json.model.values;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class NullJSONValueTest extends JSONValueTestBase
{
    @Override
    protected JSONValue getJSONValue()
    {
        return new NullJSONValue();
    }

    @Override
    public void testValue()
    {
        assertThat("Null JSON value should be null", new NullJSONValue().getValue(), nullValue());
    }

    @Override
    public void testNullCheck()
    {
        assertThat("Null JSON value should be null", getJSONValue().isNull());
    }
}
