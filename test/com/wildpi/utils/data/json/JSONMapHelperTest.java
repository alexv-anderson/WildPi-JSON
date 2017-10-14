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

package com.wildpi.utils.data.json;

import com.wildpi.utils.data.json.standard.StandardJSONLong;
import com.wildpi.utils.data.json.standard.StandardJSONString;
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
