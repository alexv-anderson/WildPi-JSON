package json.model.values;

/**
 * Created by Alex on 12/17/2016.
 */
public class StringJSONValue implements JSONValue<String>
{
    public StringJSONValue(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue()
    {
        return value;
    }

    private String value;
}
