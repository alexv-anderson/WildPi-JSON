package json.model;

import json.model.values.JSONValue;

/**
 * Marks an object which is a JSON name-value pair
 *
 * @param <T>    The type of value stored in this pair.
 *
 * @author Alex
 */
public interface JSONPair<T>
{
    /**
     * Supplies the name of the pair.
     * @return The pair's name
     */
    public String getName();

    /**
     * Supplies the value of the pair.
     * @return The pair's value
     */
    public JSONValue<T> getValue();
}
