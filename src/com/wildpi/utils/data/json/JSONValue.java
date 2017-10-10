package com.wildpi.utils.data.json;

/**
 * Defines methods common to all JSON values
 *
 * @author Alex
 */
public interface JSONValue
{
    /**
     * Supplies the serialized form of the value in valid JSON format
     * @return JSON format of the value
     */
    public String serialize();
}
