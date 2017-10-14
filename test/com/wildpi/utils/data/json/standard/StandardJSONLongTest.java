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
