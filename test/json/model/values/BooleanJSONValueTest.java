package json.model.values;

import json.TestHelper;
import org.junit.Test;

public class BooleanJSONValueTest
{
    @Test
    public void testEqualsAndHashcode()
    {
        BooleanJSONValue t1 = new BooleanJSONValue(true);
        BooleanJSONValue t2 = new BooleanJSONValue(true);
        BooleanJSONValue f = new BooleanJSONValue(false);

        TestHelper.equalityAndHashcodeChecker(t1, t2, f);
    }
}
