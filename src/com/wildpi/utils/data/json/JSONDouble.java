package com.wildpi.utils.data.json;

/**
 * Marks an object that represents a double/decimal JSON value.
 *
 * Some examples would be:
 * {
 *     "value1" : 3.14159
 *     "value2" : -1.5e2
 * }
 *
 * @author Alex
 */
public interface JSONDouble extends JSONValue
{
    /**
     * Supplies the value as a double
     * @return The value as a double
     */
    public double toDouble();

    /**
     * Casts the value to a float and returns the value
     * @return The value as a float
     */
    public float toFloat();
}
