package integrate.values;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONDouble extends AbstractSimpleJSONValue<Double> implements JSONDouble
{
    public SimpleJSONDouble(double value)
    {
        this.value = value;
    }

    @Override
    public double toDouble()
    {
        return value;
    }

    @Override
    public float toFloat()
    {
        return (float) value;
    }

    @Override
    public String serialize()
    {
        return Double.toString(value);
    }

    @Override
    protected Double getValue()
    {
        return value;
    }

    private double value;
}
