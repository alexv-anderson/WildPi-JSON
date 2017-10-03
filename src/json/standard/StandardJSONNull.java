package json.standard;

import json.JSONNull;

/**
 * Standard implementation of {@link JSONNull}
 *
 * @author Alex
 */
public class StandardJSONNull extends AbstractJSONValue<Object> implements JSONNull
{
    @Override
    public String serialize()
    {
        return "null";
    }

    @Override
    protected Object getValue()
    {
        return NULL;
    }

    private static final Object NULL = new Object();
}
