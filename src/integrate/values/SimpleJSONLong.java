package integrate.values;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONLong implements JSONLong
{
    public SimpleJSONLong(long value)
    {
        this.value = value;
    }

    @Override
    public long toLong()
    {
        return value;
    }

    @Override
    public int toInt()
    {
        return (int) value;
    }

    private long value;
}
