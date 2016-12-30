package json.model;

import json.model.values.JSONValue;

import java.util.List;

/**
 * Marks an object which is a JSON array
 *
 * @author Alex
 */
public interface JSONArray
{
    /**
     * Returns a list of {@link JSONValue} objects which are in the array
     * @return A list of {@link JSONValue} objects
     */
    public List<JSONValue> getElements();
}
