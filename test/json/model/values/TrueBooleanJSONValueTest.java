package json.model.values;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrueBooleanJSONValueTest extends JSONValueTestBase
{
    @Override
    protected JSONValue getJSONValue()
    {
        return new BooleanJSONValue(true);
    }

    @Override
    public void testValue()
    {
        assertThat("True JSON values should be true", getJSONValue().getValue(), is(true));
    }

    @Override
    public void testBooleanCheck()
    {
        assertThat("JSON value should be a boolean", getJSONValue().isBoolean());
    }

    @Override
    public void testTrueCheck()
    {
        assertThat("JSON value should be true", getJSONValue().isTrue());
    }
}
