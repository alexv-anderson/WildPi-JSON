package json.standard;

import json.JSONBoolean;

/**
 * Standard implementation of {@link JSONBoolean}
 *
 * @author Alex
 */
public class StandardJSONBoolean extends AbstractJSONValue<Boolean> implements JSONBoolean
{
    public StandardJSONBoolean(boolean value)
    {
        this.value = value;
    }

    @Override
    public boolean isTrue()
    {
        return value;
    }

    @Override
    public boolean isFalse()
    {
        return !value;
    }

    @Override
    public boolean toBoolean()
    {
        return value;
    }

    @Override
    public String serialize()
    {
        return value ? "true" : "false";
    }

    @Override
    protected Boolean getValue()
    {
        return value;
    }

    private boolean value;
}
