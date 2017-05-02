package integrate.values;

/**
 * Created by Alex on 4/29/2017.
 */
public class SimpleJSONNull implements JSONNull
{
    @Override
    public String serialize()
    {
        return "null";
    }
}
