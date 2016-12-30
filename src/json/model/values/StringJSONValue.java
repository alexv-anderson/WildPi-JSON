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

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        StringJSONValue that = (StringJSONValue) o;

        return value.equals(that.value);

    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

    private String value;
}
