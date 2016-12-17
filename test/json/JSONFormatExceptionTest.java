package json;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

public class JSONFormatExceptionTest
{
    @Test(expected = JSONFormatException.class)
    public void testThrow() throws JSONFormatException
    {
        throw new JSONFormatException();
    }

    @Test
    public void testMessage()
    {
        String physicsMessage = "Physics Message";
        try
        {
            throw new JSONFormatException(physicsMessage);
        }
        catch(JSONFormatException e)
        {
            assertThat("Incorrect Message", e.getMessage(), endsWith(physicsMessage));
        }
    }

    @Test
    public void testChain()
    {
        String nullMessage = "Null Message";
        try
        {
            throw new JSONFormatException(new NullPointerException(nullMessage));
        }
        catch(JSONFormatException e)
        {
            assertThat("Incorrect Message", e.getMessage(), endsWith(nullMessage));
        }
    }

    @Test
    public void testChainMessage()
    {
        String nullMessage = "Null Message", physicsMessage = "Physics Message";
        try
        {
            throw new JSONFormatException(physicsMessage, new NullPointerException(nullMessage));
        }
        catch(JSONFormatException e)
        {
            assertThat("Incorrect Message", e.getMessage(), endsWith(physicsMessage));
        }
    }
}
