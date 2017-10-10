package com.wildpi.utils.data.json;

import com.wildpi.utils.data.json.standard.*;

/**
 * Helper class which parses a string of JSON into a {@link JSONObject}.
 *
 * @author Alex
 */
public final class JSONParser
{
    /**
     * Parses the given string to a {@link JSONObject}.
     * @param s The string to be parsed
     * @return The {@link JSONObject} which represents the string {@param s}.
     * @throws JSONFormatException Thrown if the string of JSON is not properly formatted
     */
    public static JSONObject parse(String s) throws JSONFormatException
    {
        return parseObject(s, 0).getValue();
    }

    /**
     * Parses and returns the next {@link JSONObject} in the string starting at {@param fromIndex}.
     * @param s         The string to be parsed
     * @param fromIndex The index of the string at which to start parsing
     * @return A pack which contains the parsed {@link JSONObject} and the index of where parsing stopped
     * @throws JSONFormatException Thrown if the string of JSON is not properly formatted
     */
    private static ValuePack<JSONObject> parseObject(String s, int fromIndex) throws JSONFormatException
    {
        JSONObject object = new StandardJSONObject();

        StringBuilder key = new StringBuilder();
        boolean isInString = false;
        for(int i = fromIndex; i < s.length(); i++)
        {
            char curChar = s.charAt(i);

            switch(curChar)
            {
                case COMMA:
                    key.delete(0, key.length());
                    break;
                case COLON:
                    if(isInString)
                        break;
                    ValuePack pack = parseValue(s, i+1);
                    object.put(key.toString(), pack.getValue());
                    i = pack.getEndIndex();
                    break;
                case DOUBLE_QUOTE:
                    isInString = !isInString;
                    break;
                case OBJECT_END:
                    return new ValuePack<>(i, object);
                default:
                    if(isInString)
                        key.append(curChar);
            }
        }

        throw new JSONFormatException("Improperly formed JSON object");
    }

    /**
     * Parses and returns the next {@link JSONArray} in the string starting at {@param fromIndex}
     * @param s         The string to be parsed
     * @param fromIndex The index of the string at which to start parsing
     * @return A pack which contains the parsed {@link JSONArray} and the index of where parsing stopped
     * @throws JSONFormatException Thrown if the string of JSON is not properly formatted
     */
    private static ValuePack<JSONArray> parseArray(String s, int fromIndex) throws JSONFormatException
    {
        JSONArray array = new StandardJSONArray();

        for(int i = fromIndex; i < s.length(); i++)
        {
            char currChar = s.charAt(i);

            if(currChar == SPACE || currChar == COMMA)
                continue;

            if(currChar == ARRAY_END)
                return new ValuePack<>(i, array);

            ValuePack pack = parseValue(s, i);
            array.add(pack.getValue());
            i = pack.getEndIndex();
        }

        throw new JSONFormatException("Improperly formed JSON array");
    }

    /**
     * Parses and returns the next {@link JSONString} in the string starting at {@param fromIndex}
     * @param s         The string to be parsed
     * @param fromIndex The index of the string at which to start parsing
     * @return A pack which contains the parsed {@link JSONString} and the index of where parsing stopped
     * @throws JSONFormatException Thrown if the string of JSON is not properly formatted
     */
    private static ValuePack<JSONString> parseString(String s, int fromIndex) throws JSONFormatException
    {
        StringBuilder sb = new StringBuilder();

        for(int i = fromIndex; i < s.length(); i++)
        {
            char currChar = s.charAt(i);

            if(currChar == ESCAPE)
            {
                i++;
                if(i >= s.length())
                    break;

                currChar = s.charAt(i);
            }

            else if(currChar == DOUBLE_QUOTE)
                return new ValuePack<>(i, new StandardJSONString(sb.toString()));

            sb.append(currChar);
        }

        throw new JSONFormatException("Improperly formatted JSON string value");
    }

    /**
     * Parses and returns the next raw {@link JSONValue} in the string starting at {@param fromIndex}
     * Note: a raw value is any value which is neither an object or an array.
     * @param s         The string to be parsed
     * @param fromIndex The index of the string at which to start parsing
     * @return A pack which contains the parsed {@link JSONValue} and the index of where parsing stopped
     * @throws JSONFormatException Thrown if the string of JSON is not properly formatted
     */
    private static ValuePack parseValue(String s, int fromIndex) throws JSONFormatException
    {
        for(int i = fromIndex; i < s.length(); i++)
        {
            switch(s.charAt(i))
            {
                case SPACE:
                    break;
                case DOUBLE_QUOTE:
                    return parseString(s, i+1);
                case OBJECT_START:
                    return parseObject(s, i+1);
                case ARRAY_START:
                    return parseArray(s, i+1);
                default:
                    int endIndex = getNextTerminalCharIndex(s, i);
                    String value = s.substring(i, endIndex+1).trim();

                    if(value.matches("^-*[0-9]+$"))
                        return new ValuePack<>(endIndex, new StandardJSONLong(Long.parseLong(value)));
                    if(value.matches("^-*[0-9]+\\.([0-9]+)?[Ee]*-*[0-9]*"))
                        return new ValuePack<>(endIndex, new StandardJSONDouble(Double.parseDouble(value)));
                    if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false"))
                        return new ValuePack<>(endIndex, new StandardJSONBoolean(Boolean.parseBoolean(value)));
                    if(value.equalsIgnoreCase("null"))
                        return new ValuePack<>(endIndex, new StandardJSONNull());
            }
        }

        throw new JSONFormatException("Improperly formed JSON value");
    }

    /**
     * Calculates the index of the next terminal character in the string {@param s}.
     *
     * Note: Only closing curly-brackets, closing square-brackets, and commas are considered terminal characters
     * @param s         The string to be searched
     * @param fromIndex The index at which the search should begin
     * @return The index at which the next terminal character was found. -1 if no terminal characters were found.
     */
    private static int getNextTerminalCharIndex(String s, int fromIndex)
    {
        int endObjectIndex = s.indexOf(OBJECT_END, fromIndex)-1;
        int endArrayIndex = s.indexOf(ARRAY_END, fromIndex)-1;
        int endPairIndex = s.indexOf(COMMA, fromIndex)-1;

        int minIndex = endObjectIndex;//-1;
        if(endArrayIndex > 0 && endArrayIndex < minIndex)
            minIndex = endArrayIndex;
        if(endPairIndex > 0 && endPairIndex < minIndex)
            minIndex = endPairIndex;

        return minIndex;
    }

    /**
     * A pack which contains a {@link JSONValue} and the index of the string where the value ended
     * @param <V> The type of {@link JSONValue} which the pack holds
     *
     * @author Alex
     */
    private static class ValuePack<V extends JSONValue>
    {
        /**
         * Initializes the pack
         * @param endIndex The index in the string where the value ends
         * @param value    The value which was parsed from the string
         */
        private ValuePack(int endIndex, V value)
        {
            this.endIndex = endIndex;
            this.value = value;
        }

        /**
         * Supplies the ending index of the value
         * @return The ending index of the value
         */
        public int getEndIndex()
        {
            return endIndex;
        }

        /**
         * Supplies the value which was parsed
         * @return The value which was parsed
         */
        public V getValue()
        {
            return value;
        }

        private int endIndex;
        private V value;
    }

    private static final char OBJECT_START = '{';
    private static final char OBJECT_END = '}';

    private static final char ARRAY_START = '[';
    private static final char ARRAY_END = ']';

    private static final char COLON = ':';
    private static final char COMMA = ',';

    private static final char ESCAPE = '\\';
    private static final char DOUBLE_QUOTE = '"';

    private static final char SPACE = ' ';
}
