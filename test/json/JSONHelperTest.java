package json;

import org.junit.Before;
import org.junit.Test;

import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JSONHelperTest
{
    @Before
    public void testSetup()
    {
        name = "name";
        expectedIdentifier = "\"" + name + "\":";
    }
    @Test
    public void testBoolean()
    {
        assertThat("Bad JSON for boolean value", JSONHelper.makeJSON(name, true), is(expectedIdentifier + "true"));
        assertThat("Bad JSON for boolean value", JSONHelper.makeJSON(name, false), is(expectedIdentifier + "false"));
    }
    @Test
    public void testLong()
    {
        assertThat("Bad JSON for long value",
                JSONHelper.makeJSON(name, 1000000000000000L),
                is(expectedIdentifier + Long.toString(1000000000000000L))
        );
        assertThat("Bad JSON for long value",
                JSONHelper.makeJSON(name, -1000000000000000L),
                is(expectedIdentifier + Long.toString(-1000000000000000L))
        );
    }
    @Test
    public void testDouble() throws JSONFormatException
    {
        assertThat("Bad JSON for double value",
                JSONHelper.makeJSON(name, 0.00000025),
                is(expectedIdentifier + Double.toString(0.00000025))
        );
        assertThat("Bad JSON for double value",
                JSONHelper.makeJSON(name, 99999999999999999999999999999999999999999999999999999999999999999999999.0),
                is(expectedIdentifier +
                        Double.toString(99999999999999999999999999999999999999999999999999999999999999999999999.0))
        );
    }
    @Test(expected = JSONFormatException.class)
    public void testDoubleNaN() throws JSONFormatException
    {
        JSONHelper.makeJSON("test", Double.NaN);
    }
    @Test(expected = JSONFormatException.class)
    public void testDoublePosInf() throws JSONFormatException
    {
        JSONHelper.makeJSON("test", Double.POSITIVE_INFINITY);
    }
    @Test(expected = JSONFormatException.class)
    public void testDoubleNegInf() throws JSONFormatException
    {
        JSONHelper.makeJSON("test", Double.NEGATIVE_INFINITY);
    }
    @Test
    public void testString()
    {
        assertThat("Bad JSON for string",
                JSONHelper.makeJSON(name, "hello"),
                is(expectedIdentifier + "\"hello\"")
        );
    }
    @Test
    public void testList()
    {
        //test empty list
        assertThat("Bad JSON for empty list",
                JSONHelper.makeJSON(name, new LinkedList<>()),
                is(expectedIdentifier + "[]")
        );

        //test list with items in it
        List<ToJSONable> list = new LinkedList<>();
        list.add(new MockToJSONable());
        list.add(new MockToJSONable());
        assertThat("Bad JSON for list with items in it",
                JSONHelper.makeJSON(name, list),
                is(expectedIdentifier + "[" + new MockToJSONable().toJSON() + "," + new MockToJSONable().toJSON() + "]")
        );
    }
    @Test(expected =  JSONFormatException.class)
    public void testListFail()
    {
        List<MockToJSONable> list = new LinkedList<>();
        list.add(new MockToJSONable());
        list.add(new MockToJSONable(Double.NaN));
        JSONHelper.makeJSON("myList", list);
    }

    @Test
    public void testInstantiation()
    {
        JSONHelper helper = new JSONHelper();
    }

    private String name, expectedIdentifier;
}
