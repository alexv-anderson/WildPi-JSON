package json;

import java.util.Set;

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
public interface JSONObject extends JSONValue
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
     * Indicates if the value at the given {@param key} is a {@link JSONNull}
     * @param key The index of the value
     * @return True if the value is a {@link JSONNull}, otherwise false
     */
    public boolean isNull(String key);

    //endregion

    /**
     * Supplies a set of all the keys in the {@link JSONObject}.
     * @return A set of all the keys
     */
    public Set<String> getKeySet();

    /**
     * Inserts a new {@param key} and {@link JSONValue} into the the object.
     * If the {@param key} already exists, then the old {@link JSONValue} will be overridden
     * @param key   The key for the value
     * @param value The value being inserted
     */
    public void put(String key, JSONValue value);
}
