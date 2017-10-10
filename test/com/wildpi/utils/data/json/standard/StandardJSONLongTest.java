package com.wildpi.utils.data.json.standard;

import com.wildpi.utils.data.json.JSONLong;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StandardJSONLongTest
{
    @Test
    public void testToInt()
    {
        int value1 = Integer.MAX_VALUE;
        JSONLong jsonValue1 = new StandardJSONLong(value1);

        int value2 = Integer.MIN_VALUE;
        JSONLong jsonValue2 = new StandardJSONLong(value2);

        assertThat("Did not preserve value", jsonValue1.toInt(), is(value1));
        assertThat("Incorrectly serialized max integer", jsonValue1.serialize(), is(Integer.toString(Integer.MAX_VALUE)));

        assertThat("Did not preserve value", jsonValue2.toInt(), is(value2));
        assertThat("Incorrectly serialized min integer", jsonValue2.serialize(), is(Integer.toString(Integer.MIN_VALUE)));
    }

    @Test
    public void testToLong()
    {
        long value1 = Long.MAX_VALUE;
        JSONLong jsonValue1 = new StandardJSONLong(value1);

        long value2 = Long.MIN_VALUE;
        JSONLong jsonValue2 = new StandardJSONLong(value2);

        assertThat("Did not preserve value", jsonValue1.toLong(), is(value1));
        assertThat("Incorrectly serialized max long", jsonValue1.serialize(), is(Long.toString(Long.MAX_VALUE)));

        assertThat("Did not preserve value", jsonValue2.toLong(), is(value2));
        assertThat("Incorrectly serialized min long", jsonValue2.serialize(), is(Long.toString(Long.MIN_VALUE)));
    }

    @Test
    public void testValue()
    {
        assertThat("Did not pass the correct value", new StandardJSONLong(Long.MAX_VALUE).getValue(), is(Long.MAX_VALUE));
    }
}
