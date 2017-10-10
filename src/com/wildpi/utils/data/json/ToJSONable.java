package com.wildpi.utils.data.json;

/**
 * Similar to {@link java.io.Serializable}, but uses {@link JSONObject}s instead of strings.
 *
 * Marks an object which can be transformed into a valid JSON string.
 *
 * @author Alex
 */
public interface ToJSONable
{
    /**
     * Supplies a {@link JSONObject} which represents the object.
     * @return A {@link JSONObject} which represents the object.
     */
    public JSONObject asJSON();
}
