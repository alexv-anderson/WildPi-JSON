package json;

import json.standard.StandardJSONLong;
import json.standard.StandardJSONString;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alex on 8/18/2017.
 */
public class JSONMapHelperTest
{
    @Test
    public void test()
    {
        String mapKey = "myKey";
        int value = 1;

        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put(mapKey, value);

        Map<String, Integer> afterMap = JSONMapHelper.extractMap(
                JSONMapHelper.<String, Integer>jsonifyMap(originalMap, StandardJSONString::new, StandardJSONLong::new),
                (json, key) -> json.getString(key).toString(),
                (json, key) -> json.getLong(key).toInt()
                                                                );

        assertThat("Maps should be equal", afterMap, is(originalMap));
    }
}
