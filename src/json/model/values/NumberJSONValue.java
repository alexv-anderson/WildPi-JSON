package json.model.values;

/**
 * Represents a JSON Number value
 *
 * @author Alex
 */
public class NumberJSONValue implements JSONValue<Number>
{
    public NumberJSONValue(Number number)
    {
        this.number = number;
    }

    @Override
    public Number getValue()
    {
        return number;
    }

    private Number number;
}
