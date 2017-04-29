package integrate.values;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONString implements JSONString
{
    public SimpleJSONString(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value;
    }

    private String value;
}
