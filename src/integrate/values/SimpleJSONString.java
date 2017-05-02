package integrate.values;

/**
 * Created by Alex on 4/29/2017.
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
        return "\"" + value + "\"";
    }

    @Override
    protected String getValue()
    {
        return value;
    }

    private String value;
}
