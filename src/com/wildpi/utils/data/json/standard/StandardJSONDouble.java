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
