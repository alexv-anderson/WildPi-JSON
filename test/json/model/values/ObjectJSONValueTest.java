package json.model.values;

import json.TestHelper;
import json.model.JSONFactory;
import json.model.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ObjectJSONValueTest extends JSONValueTestBase
{
    @Before
    public void setupValue()
    {
        value = JSONFactory.getEmptyJSONObject();
        value.getMembers().add(JSONFactory.getJSONPair("name", new NumberJSONValue(1)));
    }

    @Override
    protected JSONValue getJSONValue()
    {
        return new ObjectJSONValue(value);
    }

    @Override
    public void testValue()
    {
        assertThat("JSON object should maintain the pairs", getJSONValue().getValue(), is(value));
    }

    @Override
    public void testObjectCheck()
    {
        assertThat("JSON value should be an object", getJSONValue().isJSONObject());
    }

    @Test
    public void testEqualityAndHashcode()
    {
        JSONObject o1 = JSONFactory.getEmptyJSONObject();
        o1.getMembers().add(JSONFactory.getJSONPair("name", new NumberJSONValue(1)));
        JSONObject o2 = JSONFactory.getEmptyJSONObject();
        o2.getMembers().add(JSONFactory.getJSONPair("name", new NumberJSONValue(1)));
        JSONObject p1 = JSONFactory.getEmptyJSONObject();
        p1.getMembers().add(JSONFactory.getJSONPair("hello", new NumberJSONValue(1)));
        JSONObject p2 = JSONFactory.getEmptyJSONObject();
        p2.getMembers().add(JSONFactory.getJSONPair("name", new NumberJSONValue(2)));

        TestHelper.equalityAndHashcodeChecker(new ObjectJSONValue(o1), new ObjectJSONValue(o2), new ObjectJSONValue(p1), new ObjectJSONValue(p2));
    }

    private JSONObject value;
}
