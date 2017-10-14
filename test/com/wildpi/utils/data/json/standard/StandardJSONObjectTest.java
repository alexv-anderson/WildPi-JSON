/*
 *  Copyright 2017 Alex Anderson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wildpi.utils.data.json.standard;

import com.wildpi.utils.data.json.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StandardJSONObjectTest
{
    @Test
    public void testKeySet()
    {
        Set<String> keys = new HashSet<>();
        keys.add("key1");
        keys.add("key2");
        keys.add("key3");

        JSONObject object = new StandardJSONObject();
        for(String key : keys)
            object.put(key, new StandardJSONNull());

        assertThat("Incorrect key set returned by object", object.getKeySet(), is(keys));
    }

    //region Add and Retrieve
    @Test
    public void testObject()
    {
        JSONObject innerObject = new StandardJSONObject();
        innerObject.put("key", new StandardJSONNull());
        JSONObject outerObject = new StandardJSONObject();
        outerObject.put("key", innerObject);

        assertThat("\"key\" should be mapped to a JSON object", outerObject.getObject("key"), is(innerObject));
    }

    @Test
    public void testArray()
    {
        JSONArray array = new StandardJSONArray();
        array.add(new StandardJSONNull());
        JSONObject outerObject = new StandardJSONObject();
        outerObject.put("key", array);

        assertThat("\"key\" should be mapped to a JSON array", outerObject.getArray("key"), is(array));
    }

    @Test
    public void testString()
    {
        JSONString value = new StandardJSONString("hello \" hello");
        JSONObject outerObject = new StandardJSONObject();
        outerObject.put("key", value.toString());

        assertThat("\"key\" should be mapped to a JSON string", outerObject.getString("key"), is(value));
    }

    @Test
    public void testDouble()
    {
        JSONDouble value = new StandardJSONDouble(Double.MAX_VALUE);
        JSONObject outerObject = new StandardJSONObject();
        outerObject.put("key", value.toDouble());

        assertThat("\"key\" should be mapped to a JSON double", outerObject.getDouble("key"), is(value));
    }

    @Test
    public void testLong()
    {
        JSONLong value = new StandardJSONLong(Long.MAX_VALUE);
        JSONObject outerObject = new StandardJSONObject();
        outerObject.put("key", value.toLong());

        assertThat("\"key\" should be mapped to a JSON double", outerObject.getLong("key"), is(value));
    }

    @Test
    public void testBoolean()
    {
        JSONBoolean value = new StandardJSONBoolean(true);
        JSONObject outerObject = new StandardJSONObject();
        outerObject.put("key", value.toBoolean());

        assertThat("\"key\" should be mapped to a JSON long", outerObject.getBoolean("key"), is(value));
    }

    @Test
    public void testNull()
    {
        JSONObject outerObject = new StandardJSONObject();
        outerObject.putNull("key");

        assertThat("\"key\" should be mapped to a JSON long", outerObject.isNull("key"));
    }
    //endregion

    //region Serialization
    @Test
    public void testEmptyObject()
    {
        JSONObject object = new StandardJSONObject();

        assertThat("Did not correctly serialize empty object", object.serialize(), is("{}"));
    }

    @Test
    public void testSinglePairObject()
    {
        JSONObject object = new StandardJSONObject();
        object.put("key", new StandardJSONNull());

        assertThat("Did not correctly serialize single pair object", object.serialize(), is("{\"key\":null}"));
    }

    @Test
    public void testDualPairObject()
    {
        JSONObject object = new StandardJSONObject();
        object.put("key1", new StandardJSONNull());
        object.put("key2", new StandardJSONNull());
        assertThat("Did not correctly serialize dual pair object", object.serialize(), is("{\"key1\":null,\"key2\":null}"));
    }
    //endregion

    @Test
    public void testValue()
    {
        Map<String, JSONValue> map = new HashMap<>();
        map.put("key1", new StandardJSONNull());
        map.put("key2", new StandardJSONNull());

        StandardJSONObject object = new StandardJSONObject();
        for(Map.Entry<String, JSONValue> entry : map.entrySet())
            object.put(entry.getKey(), entry.getValue());

        assertThat("Incorrect value from JSON object", object.getValue(), is(map));
    }
}
