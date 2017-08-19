package json;

import json.standard.StandardJSONArray;
import json.standard.StandardJSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Alex on 8/18/2017.
 */
final class JSONMapHelper
{
    public static <K, V> Map<K, V> extractMap(JSONArray array, BiFunction<JSONObject, String, K> getKeyAt, BiFunction<JSONObject, String, V> getValueAt)
    {
        Map<K, V> map = new HashMap<>(array.size());

        for(int i = 0; i < array.size(); i++)
            map.put(getKeyAt.apply(array.getObjectAt(i), MAP_KEY_TAG), getValueAt.apply(array.getObjectAt(i), MAP_VALUE_TAG));

        return map;
    }

    public static <K, V> JSONArray jsonifyMap(Map<K, V> map, Function<K, JSONValue> keyToJSON, Function<V, JSONValue> valueToJSON)
    {
        JSONArray array = new StandardJSONArray();

        for(Map.Entry<K, V> entry : map.entrySet())
        {
            JSONObject jsonEntry = new StandardJSONObject();
            jsonEntry.put(MAP_KEY_TAG, keyToJSON.apply(entry.getKey()));
            jsonEntry.put(MAP_VALUE_TAG, valueToJSON.apply(entry.getValue()));
            array.add(jsonEntry);
        }

        return array;
    }

    static final String MAP_KEY_TAG = "k", MAP_VALUE_TAG = "v";
}
