package json.model.values;

import json.TestHelper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberJSONValueTest extends JSONValueTestBase
{
    @Override
    protected JSONValue getJSONValue()
    {
        return new NumberJSONValue(1);
    }

    @Override
    public void testValue()
    {
        assertThat("Number JSON values should maintain its value", getJSONValue().getValue(), is(1));
    }

    @Override
    public void testNumberCheck()
    {
        assertThat("JSON value should not be a number", getJSONValue().isNumber());
    }

    @Test
    public void testEqualityAndHashcode()
    {
        NumberJSONValue n1 = new NumberJSONValue(1);
        NumberJSONValue n2 = new NumberJSONValue(1);
        NumberJSONValue m = new NumberJSONValue(2);

        TestHelper.equalityAndHashcodeChecker(n1, n2, m);
    }
}
