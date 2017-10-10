package com.wildpi.utils.data.json;

import com.wildpi.utils.data.json.standard.StandardJSONArray;
import com.wildpi.utils.data.json.standard.StandardJSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Contains helper methods which transforms implementations of {@link Map} to/from a {@link JSONArray}.
 *
 * @author Alex
 */
public final class JSONMapHelper
{
    /**
     * Constructs a {@link Map} from the provided {@link JSONArray}.
     *
     * It is assumed that the {@link JSONArray} only contains {@link JSONObject}s and these contain
     * the default keys used when {@link JSONMapHelper#jsonifyMap(Map, Function, Function)} was used to
     * transform the map into a {@link JSONArray}.
     *
     * Note: this method serves as the inverse operation of {@link JSONMapHelper#jsonifyMap(Map, Function, Function)}
     *
     * @param array      The array of key-value pairs
     * @param getKeyAt   A function which can extract a key from a {@link JSONObject} given the key's tag
     * @param getValueAt A function which can extract a value from a {@link JSONObject} given the value's tag
     * @param <K>        The type of object which the returned {@link Map} uses for its keys.
     * @param <V>        The type of object which the returned {@link Map} uses for its values.
     * @return A {@link Map} which contains the keys an values which were in the {@link JSONArray}
     */
    public static <K, V> Map<K, V> extractMap(JSONArray array, BiFunction<JSONObject, String, K> getKeyAt, BiFunction<JSONObject, String, V> getValueAt)
    {
        Map<K, V> map = new HashMap<>(array.size());

        for(int i = 0; i < array.size(); i++)
            map.put(getKeyAt.apply(array.getObjectAt(i), DEFAULT_KEY_TAG), getValueAt.apply(array.getObjectAt(i), DEFAULT_VALUE_TAG));

        return map;
    }

    /**
     * Constructs a {@link JSONArray} from the provided {@link Map}.
     *
     * Note: this method serves as the inverse operation of {@link JSONMapHelper#extractMap(JSONArray, BiFunction, BiFunction)}
     *
     * @param map         The {@link Map} to be transcribed to a {@link JSONArray}
     * @param keyToJSON   A function which can transform a {@link K} to a {@link JSONValue}
     * @param valueToJSON A function which can transform a {@link V} to a {@link JSONValue}
     * @param <K>        The type of object which the returned {@link Map} uses for its keys.
     * @param <V>        The type of object which the returned {@link Map} uses for its values.
     * @return A {@link JSONArray} which holds the the contents of the {@param map} as {@link JSONValue}s
     */
    public static <K, V> JSONArray jsonifyMap(Map<K, V> map, Function<K, JSONValue> keyToJSON, Function<V, JSONValue> valueToJSON)
    {
        JSONArray array = new StandardJSONArray();

        for(Map.Entry<K, V> entry : map.entrySet())
        {
            JSONObject jsonEntry = new StandardJSONObject();
            jsonEntry.put(DEFAULT_KEY_TAG, keyToJSON.apply(entry.getKey()));
            jsonEntry.put(DEFAULT_VALUE_TAG, valueToJSON.apply(entry.getValue()));
            array.add(jsonEntry);
        }

        return array;
    }

    private static final String DEFAULT_KEY_TAG = "k", DEFAULT_VALUE_TAG = "v";
}
