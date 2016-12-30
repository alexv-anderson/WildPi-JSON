package json.model;

import json.TestHelper;
import json.model.values.JSONValue;
import json.model.values.NumberJSONValue;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleJSONArrayTest
{
    @Test
    public void startEmpty()
    {
        assertThat("The simple array should start empty", new SimpleJSONArray().getElements().size(), is(0));
    }

    @Test
    public void preserveList()
    {
        List<JSONValue> values = new LinkedList<>();
        values.add(new NumberJSONValue(1));
        values.add(new NumberJSONValue(2));
        values.add(new NumberJSONValue(-1));

        assertThat("The array should preserve the values", new SimpleJSONArray(values).getElements(), is(values));
    }

    @Test
    public void testEqualityAndHashcode()
    {
        SimpleJSONArray a1 = new SimpleJSONArray();
        a1.getElements().add(new NumberJSONValue(1));
        SimpleJSONArray a2 = new SimpleJSONArray();
        a2.getElements().add(new NumberJSONValue(1));
        SimpleJSONArray b = new SimpleJSONArray();
        b.getElements().add(new NumberJSONValue(2));

        TestHelper.equalityAndHashcodeChecker(a1, a2, b);
    }
}
