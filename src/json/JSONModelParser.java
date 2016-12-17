package json;

import json.model.JSONArray;
import json.model.JSONFactory;
import json.model.JSONObject;
import json.model.JSONPair;
import json.model.values.ArrayJSONValue;
import json.model.values.JSONValue;
import json.model.values.ObjectJSONValue;
import json.model.values.StringJSONValue;

/**
 * Helper class which parses a string of json
 *
 * @author Alex
 */
public class JSONModelParser
{
    public static void main(String[] args)
    {
        JSONObject jsonObject = JSONModelParser.parseJSON("{ name: value, array: [ [1], 2 ], object: { name2: value2, name3: value3 } }");
        jsonObject.getMembers().forEach(System.out::println);
        System.out.println("Hello");
    }

    /**
     * Handles -> initial nameless object
     * @param json    The json string to be parsed
     */
    public static JSONObject parseJSON(String json)
    {
        JSONObject jsonObject = JSONFactory.getEmptyJSONObject();

        StringBuilder sb = new StringBuilder(json.replaceAll("\\s*", "").trim());
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);

        while(sb.length() > 0)
            jsonObject.getMembers().add(parsePair(sb));


        return jsonObject;
    }

    /**
     * Parses a single key value pair. The value may be an object, array, string, or primitive.
     * The remaining JSON is left in the StringBuilder.
     * @param sb    The StringBuilder which holds the JSON string which remains to be parsed.
     * @return  A {@link JSONPair} which encapsulates the json which was parsed.
     */
    private static JSONPair parsePair(StringBuilder sb)
    {
        String name = sb.substring(0, sb.indexOf(COLON)).trim();
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
        String s = sb.toString().trim();
        sb.delete(0, sb.length()).append(s);
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
        do
        {
            result = getNextParsedResult(sb);
            jsonArray.getElements().add(result);
        }
        while(sb.length() > 0 && sb.charAt(0) != cARRAY_END);

        sb.deleteCharAt(0);

        if(sb.length() > 0 && sb.charAt(0) == cCOMMA)
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
        if(sb.indexOf(COMMA) < 0)
        {
            int endIndex = getNetTerminalCharIndex(sb);
            String value = sb.substring(0, endIndex);
            if(sb.charAt(endIndex) == cCOMMA)
                sb.delete(0, endIndex+1);
            else
                sb.delete(0, endIndex);
            //String value = sb.toString();
            //sb.delete(0, sb.length());
            return new StringJSONValue(value);
        }
        else
        {
            //String value = sb.substring(0, sb.indexOf(COMMA));
            //sb.delete(0, sb.indexOf(COMMA) + 1);
            int endIndex = getNetTerminalCharIndex(sb);
            String value = sb.substring(0, endIndex);
            if(sb.charAt(endIndex) == cCOMMA)
                sb.delete(0, endIndex+1);
            else
                sb.delete(0, endIndex);
            return new StringJSONValue(value);
        }
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
        do
        {
            pair = parsePair(sb);
            jsonObject.getMembers().add(pair);
        }
        while(sb.length() > 0 && sb.charAt(0) != cOBJECT_END);

        sb.deleteCharAt(0);

        if(sb.length() > 0 && sb.charAt(0) == cCOMMA)
            sb.deleteCharAt(0);

        return new ObjectJSONValue(jsonObject);
    }

    private static int getNetTerminalCharIndex(StringBuilder sb)
    {
        int endObjectIndex = sb.indexOf(OBJECT_END);
        int endArrayIndex = sb.indexOf(ARRAY_END);
        int endPairIndex = sb.indexOf(COMMA);

        int minIndex = -1;
        if(endObjectIndex > 0)
            minIndex = endObjectIndex;
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