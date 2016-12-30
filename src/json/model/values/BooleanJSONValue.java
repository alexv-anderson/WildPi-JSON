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

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        BooleanJSONValue that = (BooleanJSONValue) o;

        return value.equals(that.value);

    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

    private Boolean value;
}
