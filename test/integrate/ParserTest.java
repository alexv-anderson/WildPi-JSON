package integrate;

import integrate.values.JSONObject;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alex on 4/29/2017.
 */
public class ParserTest
{
    //region Raw
    @Test
    public void testString()
    {
        String key = "greeting", value = "Allow me to say, \\\"hello, JSON\\\"";
        String json = " { \"" + key + "\" : \"" + value + "\" } ";

        JSONObject object = Parser.parse(json);
        assertThat("Did not correctly parse string value", object.getString(key).toString(), is(value));
    }

    //region Numbers
    @Test
    public void testPositiveWholeNumber()
    {
        String key = "value", value = "32", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = Parser.parse(json);
        assertThat("Did not correctly parse positive whole number", object.getLong(key).toInt(), is(32));
    }
    @Test
    public void testNegativeWholeNumber()
    {
        String key = "value", value = "-32", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = Parser.parse(json);
        assertThat("Did not correctly parse positive whole number", object.getLong(key).toInt(), is(-32));
    }
    @Test
    public void testPositiveRealNumber()
    {
        String key = "value", value = "32.0", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = Parser.parse(json);
        assertThat("Did not correctly parse positive real number", object.getDouble(key).toDouble(), is(32.0));
    }
    @Test
    public void testNegativeRealNumber()
    {
        String key = "value", value = "-32.0", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = Parser.parse(json);
        assertThat("Did not correctly parse positive real number", object.getDouble(key).toDouble(), is(-32.0));
    }
    //endregion

    //region Boolean
    @Test
    public void testTrue()
    {
        boolean value = true;
        String key = "value", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = Parser.parse(json);
        assertThat("Did not correctly parse boolean true", object.getBoolean(key).toBoolean(), is(value));
    }
    @Test
    public void testFalse()
    {
        boolean value = false;
        String key = "value", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = Parser.parse(json);
        assertThat("Did not correctly parse boolean false", object.getBoolean(key).toBoolean(), is(value));
    }
    //endregion

    @Test
    public void testNull()
    {
        String key = "value", value = "null", json = " { \"" + key + "\" : " + value + " } ";

        JSONObject object = Parser.parse(json);
        assertThat("Did not correctly parse null", object.isNull(key));
    }
    //endregion
}
