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

import com.wildpi.utils.data.json.JSONString;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StandardJSONStringTest
{
    @Test
    public void testToString()
    {
        String s = "hello \" hello";
        JSONString jsonString = new StandardJSONString(s);
        assertThat("Did not preserve string", jsonString.toString(), is(s));
    }

    @Test
    public void testSerialize()
    {
        String value = "hello \" hello", jsonValue = "\"hello \\\" hello\"";
        JSONString jsonString = new StandardJSONString(value);

        assertThat("Did not correctly serialize JSON string", jsonString.serialize(), is(jsonValue));
    }

    @Test
    public void testValue()
    {
        assertThat("Did not pass the correct value", new StandardJSONString("hello \" hello").getValue(), is("hello \" hello"));
    }
}