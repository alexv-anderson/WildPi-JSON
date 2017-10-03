package com.wildpi.json.standard;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StandardJSONNullTest
{
    @Test
    public void testSerialization()
    {
        assertThat("Did not correctly serialize null JSON value", new StandardJSONNull().serialize(), is("null"));
    }
}
