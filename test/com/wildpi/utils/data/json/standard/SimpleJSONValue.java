package com.wildpi.utils.data.json.standard;

public class SimpleJSONValue extends AbstractJSONValue<Integer>
{
    public SimpleJSONValue(int value)
    {
        this.value = value;
    }

    @Override
    protected Integer getValue()
    {
        return value;
    }

    private int value;
}
