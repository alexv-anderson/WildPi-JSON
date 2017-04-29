package integrate.values;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONDouble implements JSONDouble
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

    private double value;
}
