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

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class AbstractJSONValueTest
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
