package json.model.values;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FalseBooleanJSONValueTest extends JSONValueTestBase
{
    @Override
    protected JSONValue getJSONValue()
    {
        return new BooleanJSONValue(false);
    }

    @Override
    public void testValue()
    {
        assertThat("False JSON values should be false", getJSONValue().getValue(), is(false));
    }

    @Override
    public void testBooleanCheck()
    {
        assertThat("JSON value should be a boolean", getJSONValue().isBoolean());
    }

    @Override
    public void testFalseCheck()
    {
        assertThat("JSON value should be false", getJSONValue().isFalse());
    }
}
