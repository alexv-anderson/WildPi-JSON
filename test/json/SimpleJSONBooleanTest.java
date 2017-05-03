package json;

import json.JSONBoolean;
import json.SimpleJSONBoolean;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleJSONBooleanTest
{
    @Test
    public void testToBoolean()
    {
        boolean b1 = true;
        JSONBoolean jsonBoolean1 = new SimpleJSONBoolean(b1);

        boolean b2 = false;
        JSONBoolean jsonBoolean2 = new SimpleJSONBoolean(b2);

        assertThat("Did not preserve true value",  jsonBoolean1.toBoolean(), is(b1));
        assertThat("Did not correctly serialize true boolean", jsonBoolean1.serialize(), is("true"));

        assertThat("Did not preserve true value",  jsonBoolean2.toBoolean(), is(b2));
        assertThat("Did not correctly serialize true boolean", jsonBoolean2.serialize(), is("false"));
    }

    @Test
    public void testIsTrue()
    {
        JSONBoolean trueJSON = new SimpleJSONBoolean(true);
        JSONBoolean falseJSON = new SimpleJSONBoolean(false);

        assertThat("Incorrect isTrue result for true boolean", trueJSON.isTrue(), is(true));
        assertThat("Incorrect isTrue result for false boolean", falseJSON.isTrue(), is(false));
    }

    @Test
    public void testIsFalse()
    {
        JSONBoolean trueJSON = new SimpleJSONBoolean(true);
        JSONBoolean falseJSON = new SimpleJSONBoolean(false);

        assertThat("Incorrect isFalse result for true boolean", trueJSON.isFalse(), is(false));
        assertThat("Incorrect isFalse result for false boolean", falseJSON.isFalse(), is(true));
    }

    @Test
    public void testValue()
    {
        assertThat("Did not pass the correct value", new SimpleJSONBoolean(true).getValue(), is(true));
        assertThat("Did not pass the correct value", new SimpleJSONBoolean(false).getValue(), is(false));
    }
}
