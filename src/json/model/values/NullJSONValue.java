package json.model.values;

/**
 * Created by Alex on 12/17/2016.
 */
public final class NullJSONValue implements JSONValue<Object>
{
    @Override
    public Object getValue()
    {
        return null;
    }
}
