package json.model.values;

import json.TestHelper;
import json.model.JSONArray;
import json.model.JSONFactory;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArrayJSONValueTest extends JSONValueTestBase
{
    @Before
    public void setupValue()
    {
        value = JSONFactory.getEmptyJSONArray();
        value.getElements().add(new NumberJSONValue(1));
    }

    @Override
    protected JSONValue getJSONValue()
    {
        return new ArrayJSONValue(value);
    }

    @Override
    public void testValue()
    {
        assertThat("JSON array values should maintain the array", getJSONValue().getValue(), is(value));
    }

    @Override
    public void testArrayCheck()
    {
        assertThat("JSON value should not be an array", getJSONValue().isJSONArray());
    }

    @Test
    public void testEqualityAndHashcode()
    {
        JSONArray a1 = JSONFactory.getEmptyJSONArray();
        a1.getElements().add(new NumberJSONValue(1));
        JSONArray a2 = JSONFactory.getEmptyJSONArray();
        a2.getElements().add(new NumberJSONValue(1));
        JSONArray b = JSONFactory.getEmptyJSONArray();
        b.getElements().add(new NumberJSONValue(2));

        TestHelper.equalityAndHashcodeChecker(new ArrayJSONValue(a1), new ArrayJSONValue(a2), new ArrayJSONValue(b));
    }

    private JSONArray value;
}
