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

import com.wildpi.utils.data.json.JSONDouble;

/**
 * Standard implementation of {@link JSONDouble}
 *
 * @author Alex
 */
public class StandardJSONDouble extends AbstractJSONValue<Double> implements JSONDouble
{
    public StandardJSONDouble(double value)
    {
        this.value = value;
    }

    @Override
    public double toDouble()
    {
        return value;
    }

    @Override
    public float toFloat()
    {
        return (float) value;
    }

    @Override
    public String serialize()
    {
        return Double.toString(value);
    }

    @Override
    protected Double getValue()
    {
        return value;
    }

    private double value;
}
