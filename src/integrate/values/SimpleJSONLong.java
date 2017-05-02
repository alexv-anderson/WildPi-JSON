package integrate.values;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONLong extends AbstractSimpleJSONValue<Long> implements JSONLong
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

    @Override
    public String serialize()
    {
        return Long.toString(value);
    }

    @Override
    protected Long getValue()
    {
        return value;
    }

    private long value;
}
