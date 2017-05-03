package json;

import json.AbstractSimpleJSONValue;

public class SimpleJSONValue extends AbstractSimpleJSONValue<Integer>
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
