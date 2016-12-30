package json;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestHelper
{
    public static <T> void equalityAndHashcodeChecker(T same1, T same2, T... differentThings)
    {
        assertThat("Objects should not be equal to null", !same1.equals(null));
        assertThat("Object of different types should not be equal", same1, is(not(new Object())));
        assertThat("An object should be equal to itself", same1, is(same1));
        assertThat("Equal objects should be equal", same1, is(same2));
        assertThat("Equal objects should have equal hashcodes", same1.hashCode(), is(same2.hashCode()));
        for(T different : differentThings)
        {
            assertThat("Unequal objects should not be equal", same1, is(not(different)));
            assertThat("Unequal objects should not have the same hashcodes", same1.hashCode(), is(not(different.hashCode())));
        }
    }
}
