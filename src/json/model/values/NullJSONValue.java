package json.model.values;

/**
 * Represents a JSON null value
 *
 * @author Alex
 */
public final class NullJSONValue implements JSONValue<Object>
{
    @Override
    public Object getValue()
    {
        return null;
    }
}
