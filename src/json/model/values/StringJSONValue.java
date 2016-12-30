package json.model.values;

/**
 * Represents a JSON string value
 *
 * @author Alex
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
