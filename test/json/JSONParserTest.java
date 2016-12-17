package json;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JSONParserTest
{
    public void pairEquality()
    {

    }

    //@Test
    public void singleValuePair()
    {
        String json = JSONHelper.makeJSON("name", "value");
        List<JSONParser.Pair> pairs = JSONParser.parseJSON(json);
        assertThat("message", pairs.get(0), is(new JSONParser.Pair("name", "value")));
    }
}
