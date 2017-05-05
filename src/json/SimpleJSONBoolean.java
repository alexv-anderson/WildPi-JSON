package json;

/**
 * Standard implementation of {@link JSONBoolean}
 *
 * @author Alex
 */
public class SimpleJSONBoolean extends AbstractSimpleJSONValue<Boolean> implements JSONBoolean
{
    public SimpleJSONBoolean(boolean value)
    {
        this.value = value;
    }

    @Override
    public boolean isTrue()
    {
        return value;
    }

    @Override
    public boolean isFalse()
    {
        return !value;
    }

    @Override
    public boolean toBoolean()
    {
        return value;
    }

    @Override
    public String serialize()
    {
        return value ? "true" : "false";
    }

    @Override
    protected Boolean getValue()
    {
        return value;
    }

    private boolean value;
}
