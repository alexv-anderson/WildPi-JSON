package json.model.values;

/**
 * Created by Alex on 12/17/2016.
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
