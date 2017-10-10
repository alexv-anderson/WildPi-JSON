package com.wildpi.utils.data.json;

/**
 * Thrown to signal that a string of JSON was not properly formatted.
 *
 * @author Alex
 */
public class JSONFormatException extends RuntimeException
{
    /**
     * @param message A programmer friendly message
     */
    public JSONFormatException(String message)
    {
        super(message);
    }

    /**
     * @param throwable The exception/error which caused this exception
     */
    public JSONFormatException(Throwable throwable)
    {
        super(throwable);
    }

    /**
     * @param message   A programmer friendly message
     * @param throwable The exception/error which caused this exception
     */
    public JSONFormatException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}