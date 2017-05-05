package json;

/**
 * Standard implementation of {@link JSONString}
 *
 * @author Alex
 */
public class SimpleJSONString extends AbstractSimpleJSONValue<String> implements JSONString
{
    public SimpleJSONString(String value)
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
