package json;

import json.model.JSONArray;
import json.model.JSONFactory;
import json.model.JSONObject;
import json.model.JSONPair;
import json.model.values.*;

/**
 * Helper class which parses a string of json
 *
 * @author Alex
 */
public class JSONParser
{
    /**
     * Parses a complete nameless JSON object.
     *
     * Note: All whitespace is removed before the JSON string is parsed regardless of where the whitespace is located.
     *          This includes inside quotation marks.
     * @param json    The json string to be parsed
     */
    public static JSONObject parseJSON(String json)
    {
        StringBuilder sb = new StringBuilder(json.replaceAll("\\s*", "").trim());
        return parseObject(sb).getValue();
    }

    /**
     * Parses a single key value pair. The value may be an object, array, string, or primitive.
     * The remaining JSON is left in the StringBuilder.
     * @param sb    The StringBuilder which holds the JSON string which remains to be parsed.
     * @return  A {@link JSONPair} which encapsulates the json which was parsed.
     */
    private static JSONPair parsePair(StringBuilder sb)
    {
        String name = sb.substring(1, sb.indexOf(COLON)-1);//.trim();
        JSONValue value = getNextParsedResult(sb.delete(0, sb.indexOf(COLON)+1));

        return JSONFactory.getJSONPair(name, value);
    }

    /**
     * Parses a single value into a {@link JSONValue}. The value may be an object, array, string, or primitive.
     * The remaining JSON is left on the StringBuilder.
     * @param sb    The StringBuilder which holds the JSON string which remains to be parsed.
     * @return  A {@link JSONValue} which encapsulates the value which was parsed.
     */
    private static JSONValue getNextParsedResult(StringBuilder sb)
    {
        if(sb.charAt(0) == cOBJECT_START)
            return parseObject(sb);
        else if(sb.charAt(0) == cARRAY_START)
            return parseArray(sb);
        else
            return parseValue(sb);
    }

    /**
     * Parses a single JSON array. The array may contain objects, arrays, strings, primitives, or a mixture.
     * The remaining JSON is left on the StringBuilder.
     * @param sb    The StringBuilder which holds the JSON string which remains to be parsed.
     * @return  A {@link ArrayJSONValue} which encapsulates the array which was parsed.
     */
    private static ArrayJSONValue parseArray(StringBuilder sb)
    {
        sb.deleteCharAt(0);

        JSONArray jsonArray = JSONFactory.getEmptyJSONArray();

        JSONValue result;
        while(sb.charAt(0) != cARRAY_END)
        {
            result = getNextParsedResult(sb);
            jsonArray.getElements().add(result);
        }

        sb.deleteCharAt(0);

        if(sb.charAt(0) == cCOMMA)
            sb.deleteCharAt(0);

        return new ArrayJSONValue(jsonArray);
    }

    /**
     * Parses a single string, primitive, or null JSON value and leaves the rest on the StringBuilder.
     * @param sb    The StringBuilder which holds the JSON string which remains to be parsed.
     * @return  A {@link JSONValue} which encapsulates the value which was parsed.
     */
    private static JSONValue parseValue(StringBuilder sb)
    {
        int endIndex = getNextTerminalCharIndex(sb);
        String value = sb.substring(0, endIndex);
        if(sb.charAt(endIndex) == cCOMMA)
            sb.delete(0, endIndex+1);
        else
            sb.delete(0, endIndex);

        if(value.matches("^-*[0-9]+$"))
            return new NumberJSONValue(Integer.parseInt(value));
        if(value.matches("^-*[0-9]+\\.([0-9]+)?"))
            return new NumberJSONValue(Double.parseDouble(value));
        if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false"))
            return new BooleanJSONValue(Boolean.parseBoolean(value));
        if(value.equalsIgnoreCase("null"))
            return new NullJSONValue();

        return new StringJSONValue(value.substring(1, value.length()-1));
    }

    /**
     * Parses a single JSON object and leaves the rest on the StringBuilder.
     * @param sb    The StringBuilder which holds the JSON string which remains to be parsed.
     * @return  A {@link ObjectJSONValue} which encapsulates the object which was parsed.
     */
    private static ObjectJSONValue parseObject(StringBuilder sb)
    {
        sb.deleteCharAt(0);

        JSONObject jsonObject = JSONFactory.getEmptyJSONObject();

        JSONPair pair;
        while(sb.charAt(0) != cOBJECT_END)
        {
            pair = parsePair(sb);
            jsonObject.put(pair);
        }

        sb.deleteCharAt(0);

        if(sb.length() > 0 && sb.charAt(0) == cCOMMA)
            sb.deleteCharAt(0);

        return new ObjectJSONValue(jsonObject);
    }

    private static int getNextTerminalCharIndex(StringBuilder sb)
    {
        int endObjectIndex = sb.indexOf(OBJECT_END);
        int endArrayIndex = sb.indexOf(ARRAY_END);
        int endPairIndex = sb.indexOf(COMMA);

        int minIndex = endObjectIndex;//-1;
        if(endArrayIndex > 0 && endArrayIndex < minIndex)
            minIndex = endArrayIndex;
        if(endPairIndex > 0 && endPairIndex < minIndex)
            minIndex = endPairIndex;

        return minIndex;
    }

    private static final String OBJECT_START = "{";
    private static final char cOBJECT_START = OBJECT_START.toCharArray()[0];
    private static final String OBJECT_END = "}";
    private static final char cOBJECT_END = OBJECT_END.toCharArray()[0];
    private static final String ARRAY_START = "[";
    private static final char cARRAY_START = ARRAY_START.toCharArray()[0];
    private static final String ARRAY_END = "]";
    private static final char cARRAY_END = ARRAY_END.toCharArray()[0];

    private static final String COMMA = ",";
    private static final char cCOMMA = COMMA.toCharArray()[0];
    private static final String COLON = ":";
    private static final char cCOLON = COLON.toCharArray()[0];
}