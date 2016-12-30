package json.model.values;

import json.JSONFormatException;
import json.model.JSONArray;
import json.model.JSONObject;

/**
 * Marks an object which represents the value portion of a JSON name-value pair
 *
 * @param <T>    The type of value
 *
 * @author Alex
 */
public interface JSONValue<T>
{
    /**
     * Indicates if the value is a string.
     * @return True if the value is a string, false otherwise
     */
    public default boolean isString()
    {
        return getValue() instanceof String;
    }

    /**
     * Indicates if the value is a number.
     * @return True if the value is a number, false otherwise
     */
    public default boolean isNumber()
    {
        return getValue() instanceof Number;
    }

    /**
     * Indicates if the value is a {@link JSONObject}.
     * @return True if the value is a {@link JSONObject}, false otherwise
     */
    public default boolean isJSONObject()
    {
        return getValue() instanceof JSONObject;
    }

    /**
     * Indicates if the value is a {@link JSONArray}.
     * @return True if the value is a {@link JSONArray}, false otherwise
     */
    public default boolean isJSONArray()
    {
        return getValue() instanceof JSONArray;
    }

    /**
     * Indicates if the value is true.
     * @throws JSONFormatException If the value is not a boolean value
     * @return True if the value is a true, false otherwise
     */
    public default boolean isTrue()
    {
        if(!isBoolean())
            throw new JSONFormatException(getValue() + " is not a boolean");

        return isBoolean() && ((Boolean) getValue());
    }

    /**
     * Indicates if the value is false.
     * @throws JSONFormatException If the value is not a boolean value
     * @return True if the value is false, false otherwise
     */
    public default boolean isFalse()
    {
        return !isTrue();
    }

    /**
     * Indicates if the value is null.
     * @return True if the value is null, false otherwise
     */
    public default boolean isNull()
    {
        return getValue() == null;
    }

    /**
     * Supplies the value encapsulated by this object
     * @return The value encapsulated by this object
     */
    public T getValue();

    /**
     * Indicates if the value is a boolean.
     * @return True if the value is a boolean, false otherwise
     */
    public default boolean isBoolean()
    {
        return getValue() instanceof Boolean;
    }

    /**
     * Indicates if the value is a primitive type (e.g. boolean or numerical).
     * @return True if the value is a primitive, false otherwise
     */
    public default boolean isPrimitave()
    {
        return isNumber() || isBoolean();
    }
}
