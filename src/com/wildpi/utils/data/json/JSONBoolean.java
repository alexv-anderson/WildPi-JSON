package com.wildpi.utils.data.json;

/**
 * Marks an object that represents a boolean JSON value.
 *
 * Some examples would be:
 * {
 *     "thisIsTrue" : true,
 *     "thisIsFalse" : false
 * }
 *
 * @author Alex
 */
public interface JSONBoolean extends JSONValue
{
    /**
     * Indicates if the JSON value is true
     * @return True if the value is true, else false
     */
    public boolean isTrue();

    /**
     * Indicates if the JSON value is false
     *
     * Note this is the same as NOT {@link JSONBoolean#isTrue()}
     * @return True if the original value was false, else false
     */
    public boolean isFalse();

    /**
     * Supplies the actual boolean value which was parse from the JSON
     * @return The actual boolean value
     */
    public boolean toBoolean();
}
