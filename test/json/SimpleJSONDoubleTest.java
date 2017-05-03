package json;

import json.JSONDouble;
import json.SimpleJSONDouble;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleJSONDoubleTest
{
    @Test
    public void testToFloat()
    {
        float value1 = Float.MAX_VALUE;
        JSONDouble jsonValue1 = new SimpleJSONDouble(value1);

        float value2 = Float.MIN_VALUE;
        JSONDouble jsonValue2 = new SimpleJSONDouble(value2);

        assertThat("Did not preserve value", jsonValue1.toFloat(), is(value1));
        assertThat("Incorrectly serialized max float", jsonValue1.serialize(), is(Double.toString(Float.MAX_VALUE)));

        assertThat("Did not preserve value", jsonValue2.toFloat(), is(value2));
        assertThat("Incorrectly serialized min float", jsonValue2.serialize(), is(Double.toString(Float.MIN_VALUE)));
    }

    @Test
    public void testToDouble()
    {
        double value1 = Double.MAX_VALUE;
        JSONDouble jsonValue1 = new SimpleJSONDouble(value1);

        double value2 = Double.MIN_VALUE;
        JSONDouble jsonValue2 = new SimpleJSONDouble(value2);

        assertThat("Did not preserve value", jsonValue1.toDouble(), is(value1));
        assertThat("Incorrectly serialized max double", jsonValue1.serialize(), is(Double.toString(Double.MAX_VALUE)));

        assertThat("Did not preserve value", jsonValue2.toDouble(), is(value2));
        assertThat("Incorrectly serialized min double", jsonValue2.serialize(), is(Double.toString(Double.MIN_VALUE)));
    }

    @Test
    public void testValue()
    {
        assertThat("Did not pass the correct value", new SimpleJSONDouble(Double.MAX_VALUE).getValue(), is(Double.MAX_VALUE));
    }
}
