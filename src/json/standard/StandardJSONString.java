package json.standard;

import json.JSONString;

/**
 * Standard implementation of {@link JSONString}
 *
 * @author Alex
 */
public class StandardJSONString extends AbstractSimpleJSONValue<String> implements JSONString
{
    public StandardJSONString(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value;
    }

    @Override
    public String serialize()
    {
        return "\"" + value.replace("\"", "\\\"") + "\"";
    }

    @Override
    protected String getValue()
    {
        return value;
    }

    private String value;
}
