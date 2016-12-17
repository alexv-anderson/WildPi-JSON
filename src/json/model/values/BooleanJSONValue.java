package json.model.values;

/**
 * Created by Alex on 12/17/2016.
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
