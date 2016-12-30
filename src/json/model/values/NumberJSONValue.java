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

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        NumberJSONValue that = (NumberJSONValue) o;

        return number.equals(that.number);

    }

    @Override
    public int hashCode()
    {
        return number.hashCode();
    }

    private Number number;
}
