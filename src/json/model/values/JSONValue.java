package json.model.values;

import json.JSONFormatException;
import json.model.JSONArray;
import json.model.JSONObject;

/**
 * Created by Alex on 12/17/2016.
 */
public interface JSONValue<T>
{
    public default boolean isString()
    {
        return getValue() instanceof String;
    }
    public default boolean isNumber()
    {
        return getValue() instanceof Number;
    }
    public default boolean isJSONObject()
    {
        return getValue() instanceof JSONObject;
    }
    public default boolean isJSONArray()
    {
        return getValue() instanceof JSONArray;
    }
    public default boolean isTrue()
    {
        if(!isBoolean())
            throw new JSONFormatException(getValue() + " is not a boolean");

        return isBoolean() && ((Boolean) getValue());
    }
    public default boolean isFalse()
    {
        return !isTrue();
    }
    public default boolean isNull()
    {
        return getValue() == null;
    }

    public T getValue();

    public default boolean isBoolean()
    {
        return getValue() instanceof Boolean;
    }
    public default boolean isPrimitave()
    {
        return isNumber() || isBoolean();
    }
}
