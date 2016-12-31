package json.model;

import json.model.values.JSONValue;

/**
 * Marks an object which is a JSON object which allows a simple key-value lookup
 *
 * @author Alex
 */
public interface JSONObject
{
    /**
     * Puts a {@link JSONPair} in the mapping.
     * @param pair    The {@link JSONPair} to be placed in the mapping
     */
    public void put(JSONPair pair);

    /**
     * Places the given name and value in the mapping.
     * @param name     The name by which the value will be keyed
     * @param value    The value to be keyed with the given name
     */
    public void put(String name, JSONValue value);

    /**
     * Supplies the value which corresponds to the supplied key. If the given name is not mapped to a value, then
     * the method returns null.
     * @param name    The name of the value which should be retrieved.
     * @return The value mapped to the given name. Null if no such value exists
     */
    public JSONValue get(String name);
}
