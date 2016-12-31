package json.model;

import json.TestHelper;
import json.model.values.NumberJSONValue;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleJSONObjectTest
{
    @Test
    public void testEqualityAndHashcode()
    {
        SimpleJSONObject o1 = new SimpleJSONObject();
        o1.put("name", new NumberJSONValue(1));
        SimpleJSONObject o2 = new SimpleJSONObject();
        o2.put("name", new NumberJSONValue(1));
        SimpleJSONObject p1 = new SimpleJSONObject();
        p1.put("name", new NumberJSONValue(2));
        SimpleJSONObject p2 = new SimpleJSONObject();
        p2.put("hello", new NumberJSONValue(1));

        TestHelper.equalityAndHashcodeChecker(o1, o2, p1, p2);
    }

    @Test
    public void preserveList()
    {
        List<JSONPair> pairs = new LinkedList<>();
        pairs.add(new SimpleJSONPair("name", new NumberJSONValue(1)));
        pairs.add(new SimpleJSONPair("hello", new NumberJSONValue(2)));
        pairs.add(new SimpleJSONPair("world", new NumberJSONValue(-1)));

        JSONObject jsonObject = new SimpleJSONObject(pairs);
        assertThat("The object should preserve the pairs", jsonObject.get("name"), is(new NumberJSONValue(1)));
        assertThat("The object should preserve the pairs", jsonObject.get("hello"), is(new NumberJSONValue(2)));
        assertThat("The object should preserve the pairs", jsonObject.get("world"), is(new NumberJSONValue(-1)));
    }
}
