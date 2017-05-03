package json;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONNull extends AbstractSimpleJSONValue<Object> implements JSONNull
{
    @Override
    public String serialize()
    {
        return "null";
    }

    @Override
    protected Object getValue()
    {
        return NULL;
    }

    private static final Object NULL = new Object();
}
