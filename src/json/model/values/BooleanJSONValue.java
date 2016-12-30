package json.model.values;

/**
 * Represents a JSON boolean value
 *
 * @author Alex
 */
public class BooleanJSONValue implements JSONValue<Boolean>
{
    public BooleanJSONValue(Boolean value)
    {
        this.value = value;
    }

    @Override
    public Boolean getValue()
    {
        return value;
    }

    private Boolean value;
}
