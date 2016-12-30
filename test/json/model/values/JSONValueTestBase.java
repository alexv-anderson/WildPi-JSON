package json.model.values;

import json.JSONFormatException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public abstract class JSONValueTestBase
{
    protected abstract JSONValue getJSONValue();

    @Test
    public abstract void testValue();

    @Test
    public void testNullCheck()
    {
        assertThat("JSON value should not be null", !getJSONValue().isNull());
    }

    @Test
    public void testObjectCheck()
    {
        assertThat("JSON value should not be an object", !getJSONValue().isJSONObject());
    }

    @Test
    public void testArrayCheck()
    {
        assertThat("JSON value should not be an array", !getJSONValue().isJSONArray());
    }

    @Test
    public void testStringCheck()
    {
        assertThat("JSON value should not be a string", !getJSONValue().isString());
    }

    @Test
    public void testNumberCheck()
    {
        assertThat("JSON value should not be a number", !getJSONValue().isNumber());
    }

    @Test
    public void testBooleanCheck()
    {
        assertThat("JSON value should not be a boolean", !getJSONValue().isBoolean());
    }

    @Test
    public void testTrueCheck()
    {
        JSONValue value = getJSONValue();
        if(value.isBoolean())
            assertThat("JSON value should not be true", !getJSONValue().isTrue());
        else
        {
            try
            {
                getJSONValue().isTrue();
                fail("Testing a non-boolean JSON value for true should have thrown an exception.");
            }
            catch(JSONFormatException e)
            {

            }
        }
    }

    @Test
    public void testFalseCheck()
    {
        JSONValue value = getJSONValue();
        if(value.isBoolean())
            assertThat("JSON value should not be true", !getJSONValue().isFalse());
        else
        {
            try
            {
                getJSONValue().isFalse();
                fail("Testing a non-boolean JSON value for false should have thrown an exception.");
            }
            catch(JSONFormatException e)
            {

            }
        }
    }

    @Test
    public void testPrimitiveCheck()
    {
        if(getJSONValue().isNumber() || getJSONValue().isBoolean())
            assertThat("JSON value should be marked as primitive", getJSONValue().isPrimitave());
        else
            assertThat("JSON value should not be marked as primitive", !getJSONValue().isPrimitave());
    }
}
