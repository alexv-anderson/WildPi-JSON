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

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StandardJSONArrayTest
{
    @Test
    public void testSize()
    {
        JSONArray array = new StandardJSONArray();
        array.add(new StandardJSONNull());
        array.add(new StandardJSONNull());

        assertThat("Incorrect array size", array.size(), is(2));
    }

    @Test
    public void testInsert()
    {
        JSONBoolean value = new StandardJSONBoolean(true);
        JSONArray array = new StandardJSONArray();
        array.add(new StandardJSONNull());
        array.add(new StandardJSONNull());
        array.addAt(value, 1);

        assertThat("Incorrect insertion of value into array", array.getBooleanAt(1), is(value));
    }

    //region Add and Retrieve
    @Test
    public void testObject()
    {
        JSONObject object = new StandardJSONObject();
        object.put("key", new StandardJSONNull());
        JSONArray array = new StandardJSONArray();
        array.add(object);

        assertThat("Should contain JSON object at zero", array.getObjectAt(0), is(object));
    }

    @Test
    public void testArray()
    {
        JSONArray outerArray = new StandardJSONArray();
        JSONArray innerArray = new StandardJSONArray();
        outerArray.add(innerArray);

        assertThat("Should contain JSON array at zero", outerArray.getArrayAt(0), is(innerArray));
    }

    @Test
    public void testString()
    {
        JSONString s = new StandardJSONString("hello \" hello");
        JSONArray array = new StandardJSONArray();
        array.add(s.toString());

        assertThat("Should contain JSON string at zero", array.getStringAt(0), is(s));
    }

    @Test
    public void testDouble()
    {
        JSONDouble value = new StandardJSONDouble(Double.MAX_VALUE);
        JSONArray array = new StandardJSONArray();
        array.add(value.toDouble());

        assertThat("Should contain JSON double at zero", array.getDoubleAt(0), is(value));
    }

    @Test
    public void testLong()
    {
        JSONLong value = new StandardJSONLong(Long.MAX_VALUE);
        JSONArray array = new StandardJSONArray();
        array.add(value.toLong());

        assertThat("Should contain JSON long at zero", array.getLongAt(0), is(value));
    }

    @Test
    public void testBoolean()
    {
        JSONBoolean value = new StandardJSONBoolean(true);
        JSONArray array = new StandardJSONArray();
        array.add(value.toBoolean());

        assertThat("Should contain JSON boolean at zero", array.getBooleanAt(0), is(value));
    }

    @Test
    public void testNull()
    {
        JSONArray array = new StandardJSONArray();
        array.add(new StandardJSONNull());

        assertThat("Should contain JSON null at zero", array.isNullAt(0));
    }
    //endregion

    //region Serialization
    @Test
    public void testEmptyArray()
    {
        JSONArray jsonArray = new StandardJSONArray();

        assertThat("Did not correctly serialize empty JSON array", jsonArray.serialize(), is("[]"));
    }

    @Test
    public void testSingleElementArray()
    {
        JSONArray jsonArray = new StandardJSONArray();
        jsonArray.add(new StandardJSONNull());

        assertThat("Did not correctly serialize single element JSON array", jsonArray.serialize(), is("[null]"));
    }

    @Test
    public void testDoubleElementArray()
    {
        JSONArray jsonArray = new StandardJSONArray();
        jsonArray.addJSONNull();
        jsonArray.add(new StandardJSONNull());

        assertThat("Did not correctly serialize single element JSON array", jsonArray.serialize(), is("[null,null]"));
    }
    //endregion

    @Test
    public void testValue()
    {
        List<JSONValue> list = new LinkedList<>();
        list.add(new StandardJSONNull());
        list.add(new StandardJSONNull());

        StandardJSONArray array = new StandardJSONArray();
        for(JSONValue value : list)
            array.add(value);

        assertThat("Incorrect value from JSON array", array.getValue(), is(list));
    }
}
