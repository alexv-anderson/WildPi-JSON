package json.standard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbstractSimpleJSONValueTest
{
    @Test
    public void testEquals()
    {
        SimpleJSONValue value1 = new SimpleJSONValue(1);
        SimpleJSONValue value1d = new SimpleJSONValue(1);
        SimpleJSONValue value2 = new SimpleJSONValue(2);

        assertThat("Object should be equal to itself", value1, is(value1));
        assertThat("Object should be equal to other equal objects", value1, is(value1d));
        assertThat("Object should not be equal to another unequal object", value1, is(not(value2)));
        assertThat("Objects should not be equal to null", !value1.equals(null));
        assertThat("Objects should not be equal to objects of another class", value1, is(not(new Object())));
    }

    @Test
    public void testHashCode()
    {
        SimpleJSONValue value1 = new SimpleJSONValue(1);
        SimpleJSONValue value1d = new SimpleJSONValue(1);
        SimpleJSONValue value2 = new SimpleJSONValue(2);

        assertThat("Object should have consistent hash code", value1.hashCode(), is(value1.hashCode()));
        assertThat("Equal objects should have equal hash codes", value1.hashCode(), is(value1d.hashCode()));
        assertThat("Unequal objects should have unequal hash codes", value1.hashCode(), is(not(value2.hashCode())));
    }
}
