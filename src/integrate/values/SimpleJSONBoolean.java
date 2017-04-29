package integrate.values;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONBoolean implements JSONBoolean
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

    private boolean value;
}
