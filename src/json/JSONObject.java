package json;

import json.standard.*;

import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Marks an object that represents a JSON array.
 *
 * An example would be:
 * {
 *     "anotherObject" : {
 *         "key": true
 *     }
 * }
 *
 * @author Alex
 */
public interface JSONObject extends JSONValue, ToJSONable
{
    //region Getters

    /**
     * Casts and returns the value for the given {@param key} to a {@link JSONObject}
     * If the {@param key} does not exist, then null is returned
     * @param key The key of the value to be returned
     * @return The value cast to a {@link JSONObject} or null if the {@param key} doesn't exist
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONObject}
     */
    public JSONObject getObject(String key) throws ClassCastException;

    /**
     * Casts and returns the value for the given {@param key} to a {@link JSONArray}
     * If the {@param key} does not exist, then null is returned
     * @param key The key of the value to be returned
     * @return The value cast to a {@link JSONArray} or null if the {@param key} doesn't exist
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONArray}
     */
    public JSONArray getArray(String key) throws ClassCastException;

    /**
     * Casts and returns the value for the given {@param key} to a {@link JSONString}
     * If the {@param key} does not exist, then null is returned
     * @param key The key of the value to be returned
     * @return The value cast to a {@link JSONString} or null if the {@param key} doesn't exist
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONString}
     */
    public JSONString getString(String key) throws ClassCastException;

    /**
     * Casts and returns the value for the given {@param key} to a {@link JSONLong}
     * If the {@param key} does not exist, then null is returned
     * @param key The key of the value to be returned
     * @return The value cast to a {@link JSONLong} or null if the {@param key} doesn't exist
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONLong}
     */
    public JSONLong getLong(String key) throws ClassCastException;

    /**
     * Casts and returns the value for the given {@param key} to a {@link JSONDouble}
     * If the {@param key} does not exist, then null is returned
     * @param key The key of the value to be returned
     * @return The value cast to a {@link JSONDouble} or null if the {@param key} doesn't exist
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONDouble}
     */
    public JSONDouble getDouble(String key) throws ClassCastException;

    /**
     * Casts and returns the value for the given {@param key} to a {@link JSONBoolean}
     * If the {@param key} does not exist, then null is returned
     * @param key The key of the value to be returned
     * @return The value cast to a {@link JSONBoolean} or null if the {@param key} doesn't exist
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONBoolean}
     */
    public JSONBoolean getBoolean(String key) throws ClassCastException;

    /**
     * Extracts a mapping of {@link JSONValue}s from the specified key in the object
     *
     * @param key        The key from which to extract the mapping
     * @param getKeyAt   A function which extracts the {@link JSONValue} which is the mapping's key
     * @param getValueAt A function which extracts the {@link JSONValue} which is the mapping's value
     * @param <K>        The type of {@link JSONValue} which represents the mapping's keys
     * @param <V>        The type of {@link JSONValue} which represents the mapping's values
     * @return A mapping of extracted values
     */
    public default <K extends JSONValue, V extends JSONValue> Map<K, V> getMap(String key, BiFunction<JSONObject, String, K> getKeyAt, BiFunction<JSONObject, String, V> getValueAt)
    {
        return JSONMapHelper.extractMap(getArray(key), getKeyAt, getValueAt);
    }

    /**
     * Indicates if the value at the given {@param key} is a {@link JSONNull}
     * @param key The index of the value
     * @return True if the value is a {@link JSONNull}, otherwise false
     */
    public boolean isNull(String key);

    /**
     * Supplies a set of all the keys in the {@link JSONObject}.
     * @return A set of all the keys
     */
    public Set<String> getKeySet();
    //endregion

    //region Putters

    /**
     * Inserts a new {@param key} and {@link JSONValue} into the the object.
     * If the {@param key} already exists, then the old {@link JSONValue} will be overridden
     * @param key   The key for the value
     * @param value The value being inserted
     */
    public void put(String key, JSONValue value);

    /**
     * Inserts a new {@param key} and {@link JSONBoolean} into the the object.
     * If the {@param key} already exists, then the old {@link JSONValue} will be overridden
     * @param key   The key for the value
     * @param value The value being inserted
     */
    public default void put(String key, boolean value)
    {
        put(key, new StandardJSONBoolean(value));
    }

    /**
     * Inserts a new {@param key} and {@link JSONDouble} into the the object.
     * If the {@param key} already exists, then the old {@link JSONValue} will be overridden
     * @param key   The key for the value
     * @param value The value being inserted
     */
    public default void put(String key, double value)
    {
        put(key, new StandardJSONDouble(value));
    }

    /**
     * Inserts a new {@param key} and {@link JSONLong} into the the object.
     * If the {@param key} already exists, then the old {@link JSONValue} will be overridden
     * @param key   The key for the value
     * @param value The value being inserted
     */
    public default void put(String key, long value)
    {
        put(key, new StandardJSONLong(value));
    }

    /**
     * Inserts a new {@param key} and {@link JSONString} into the the object.
     * If the {@param key} already exists, then the old {@link JSONValue} will be overridden
     * @param key   The key for the value
     * @param value The value being inserted
     */
    public default void put(String key, String value)
    {
        put(key, new StandardJSONString(value));
    }

    /**
     * Inserts a mapping of {@link JSONValue}s into the object under the given key.
     * If the {@param key} already exists, then the old {@link JSONValue} will be overridden
     * @param key         The key for the map in this object
     * @param map         The map to be put into this object
     * @param keyToJSON   Function which transforms a key in the map to a {@link JSONValue}
     * @param valueToJSON Function which transforms a value in the map to a {@link JSONValue}
     * @param <K>         The type of keys in the map
     * @param <V>         The type of values in the map
     */
    public default <K, V> void put(String key, Map<K, V> map, Function<K, JSONValue> keyToJSON, Function<V, JSONValue> valueToJSON)
    {
        put(key, JSONMapHelper.jsonifyMap(map, keyToJSON, valueToJSON));
    }

    /**
     * Inserts a new {@param key} and {@link JSONNull} into the the object.
     * If the {@param key} already exists, then the old {@link JSONValue} will be overridden
     * @param key   The key for the value
     */
    public default void putNull(String key)
    {
        put(key, new StandardJSONNull());
    }

    //endregion

    @Override
    public default JSONObject asJSON()
    {
        return this;
    }
}
