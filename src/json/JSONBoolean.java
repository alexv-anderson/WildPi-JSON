package json;

/**
 * Created by Alex on 4/27/2017.
 */
public interface JSONBoolean extends JSONValue
{
    public boolean isTrue();
    public boolean isFalse();
    public boolean toBoolean();
}
