package json;

/**
 * Standard implementation of {@link JSONLong}
 *
 * @author Alex
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
