package json;

import json.standard.*;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Marks an object that represents a JSON array.
 *
 * An example would be:
 * {
 *     "array" : [1, true, "hello, world"]
 * }
 *
 * @author Alex
 */
public interface JSONArray extends JSONValue
{
    //region Append

    /**
     * Appends the given {@param value} to the array
     * @param value The value to be appended
     */
    public void add(JSONValue value);

    /**
     * Appends the given {@param value} to the array
     * @param value The value to be appended
     */
    public default void add(boolean value)
    {
        add(new StandardJSONBoolean(value));
    }

    /**
     * Appends the given {@param value} to the array
     * @param value The value to be appended
     */
    public default void add(double value)
    {
        add(new StandardJSONDouble(value));
    }

    /**
     * Appends the given {@param value} to the array
     * @param value The value to be appended
     */
    public default void add(long value)
    {
        add(new StandardJSONLong(value));
    }

    /**
     * Appends the given {@param value} to the array
     * @param value The value to be appended
     */
    public default void add(String value)
    {
        add(new StandardJSONString(value));
    }

    /**
     * Appends a null to the array
     */
    public default void addJSONNull()
    {
        add(new StandardJSONNull());
    }

    /**
     * Appends the given mapping to the array
     * @param map         The mapping to insert
     * @param keyToJSON   Function which transforms a key in the map to a {@link JSONValue}
     * @param valueToJSON Function which transforms a value in the map to a {@link JSONValue}
     * @param <K>         The type of keys in the map
     * @param <V>         The type of values in the map
     */
    public default <K, V> void add(Map<K, V> map, Function<K, JSONValue> keyToJSON, Function<V, JSONValue> valueToJSON)
    {
        add(JSONMapHelper.jsonifyMap(map, keyToJSON, valueToJSON));
    }
    //endregion

    //region Insert

    /**
     * Inserts the given {@param value} at the indicated {@param index}
     * @param value The value to be inserted
     * @param index The index at which the value should be inserted
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public void addAt(JSONValue value, int index) throws IndexOutOfBoundsException;

    /**
     * Inserts the given {@param value} at the indicated {@param index}
     * @param value The value to be inserted
     * @param index The index at which the value should be inserted
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public default void addAt(boolean value, int index) throws IndexOutOfBoundsException
    {
        addAt(new StandardJSONBoolean(value), index);
    }

    /**
     * Inserts the given {@param value} at the indicated {@param index}
     * @param value The value to be inserted
     * @param index The index at which the value should be inserted
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public default void addAt(double value, int index) throws IndexOutOfBoundsException
    {
        addAt(new StandardJSONDouble(value), index);
    }

    /**
     * Inserts the given {@param value} at the indicated {@param index}
     * @param value The value to be inserted
     * @param index The index at which the value should be inserted
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public default void addAt(long value, int index) throws IndexOutOfBoundsException
    {
        addAt(new StandardJSONLong(value), index);
    }

    /**
     * Inserts the given {@param value} at the indicated {@param index}
     * @param value The value to be inserted
     * @param index The index at which the value should be inserted
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public default void addAt(String value, int index) throws IndexOutOfBoundsException
    {
        addAt(new StandardJSONString(value), index);
    }

    /**
     * Inserts the given {@param value} at the indicated {@param index}
     * @param index The index at which the null should be inserted
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public default void addNullAt(int index) throws IndexOutOfBoundsException
    {
        addAt(new StandardJSONNull(), index);
    }

    /**
     * Inserts the given mapping at the indicated index
     * @param map         The mapping to insert
     * @param index       The index at which the mapping should be inserted
     * @param keyToJSON   Function which transforms a key in the map to a {@link JSONValue}
     * @param valueToJSON Function which transforms a value in the map to a {@link JSONValue}
     * @param <K>         The type of keys in the map
     * @param <V>         The type of values in the map
     */
    public default <K, V> void addAt(Map<K, V> map, int index, Function<K, JSONValue> keyToJSON, Function<V, JSONValue> valueToJSON)
    {
        addAt(JSONMapHelper.jsonifyMap(map, keyToJSON, valueToJSON), index);
    }

    //endregion

    //region Getters

    /**
     * Casts and returns the value at the given {@param index} to a {@link JSONObject}
     * @param index The index of the value to be returned
     * @return The value cast to a {@link JSONObject}
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONObject}
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public JSONObject getObjectAt(int index) throws ClassCastException, IndexOutOfBoundsException;

    /**
     * Casts and returns the value at the given {@param index} to a {@link JSONArray}
     * @param index The index of the value to be returned
     * @return The value cast to a {@link JSONArray}
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONArray}
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public JSONArray getArrayAt(int index) throws ClassCastException, IndexOutOfBoundsException;

    /**
     * Casts and returns the value at the given {@param index} to a {@link JSONString}
     * @param index The index of the value to be returned
     * @return The value cast to a {@link JSONString}
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONString}
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public JSONString getStringAt(int index) throws ClassCastException, IndexOutOfBoundsException;

    /**
     * Casts and returns the value at the given {@param index} to a {@link JSONLong}
     * @param index The index of the value to be returned
     * @return The value cast to a {@link JSONLong}
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONLong}
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public JSONLong getLongAt(int index) throws ClassCastException, IndexOutOfBoundsException;

    /**
     * Casts and returns the value at the given {@param index} to a {@link JSONDouble}
     * @param index The index of the value to be returned
     * @return The value cast to a {@link JSONDouble}
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONDouble}
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public JSONDouble getDoubleAt(int index) throws ClassCastException, IndexOutOfBoundsException;

    /**
     * Casts and returns the value at the given {@param index} to a {@link JSONBoolean}
     * @param index The index of the value to be returned
     * @return The value cast to a {@link JSONBoolean}
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONBoolean}
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public JSONBoolean getBooleanAt(int index) throws ClassCastException, IndexOutOfBoundsException;

    /**
     * Extracts a mapping of {@link JSONValue}s from the specified index in the array
     *
     * @param index      The index from which to extract the mapping
     * @param getKeyAt   A function which extracts the {@link JSONValue} which is the mapping's key
     * @param getValueAt A function which extracts the {@link JSONValue} which is the mapping's value
     * @param <K>        The type of keys in the mapping
     * @param <V>        The type of values in the mapping
     * @return A mapping of extracted values
     * @throws ClassCastException Thrown if the value could not be cast to {@link JSONArray}
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public default <K, V> Map<K, V> getMapAt(int index, BiFunction<JSONObject, String, K> getKeyAt, BiFunction<JSONObject, String, V> getValueAt) throws ClassCastException, IndexOutOfBoundsException
    {
        return JSONMapHelper.extractMap(getArrayAt(index), getKeyAt, getValueAt);
    }

    /**
     * Indicates if the value at the given {@param index} is a {@link JSONNull}
     * @param index The index of the value
     * @return True if the value is a {@link JSONNull}
     * @throws IndexOutOfBoundsException Thrown if the {@param index} is not 0 < {@param index} < {@link JSONArray#size()}
     */
    public boolean isNullAt(int index) throws IndexOutOfBoundsException;

    //endregion

    /**
     * Supplies the size of the {@link JSONArray}
     * @return The size fo the array
     */
    public int size();
}
