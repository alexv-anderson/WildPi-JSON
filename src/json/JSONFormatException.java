package json;

/**
 * Created by Alex on 6/4/2016.
 */
public class JSONFormatException extends RuntimeException
{
    public JSONFormatException()
    {

    }
    public JSONFormatException(String message)
    {
        super(message);
    }
    public JSONFormatException(Throwable throwable)
    {
        super(throwable);
    }
    public JSONFormatException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
