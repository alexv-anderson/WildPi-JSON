package integrate;

import integrate.values.*;

/**
 * Created by Alex on 4/27/2017.
 */
public class Parser
{
    public static void main(String[] args)
    {
        String jsonString = "{\"name\":\"value\\\"value\"}";
        System.out.println(jsonString);
        System.out.println(parse(jsonString).getString("name"));
    }

    public static JSONObject parse(String s)
    {
        return parseObject(s).getValue();
    }

    private static ValuePack<JSONObject> parseObject(String s)
    {
        JSONObject object = new SimpleJSONObject();

        StringBuilder key = new StringBuilder();
        //boolean collectingKey = false;
        boolean isInString = false;
        for(int i = 0; i < s.length(); i++)
        {
            char curChar = s.charAt(i);

            switch(curChar)
            {
                case COMMA:
                    key.delete(0, key.length());
                    //collectingKey = true;
                    break;
                case COLON:
                    //collectingKey = false;
                    if(isInString)
                        break;
                    ValuePack pack = parseValue(s.substring(i+1));
                    object.put(key.toString(), pack.getValue());
                    i += pack.getEndIndex();
                    break;
                case DOUBLE_QUOTE:
                    //if(collectingKey)
                        isInString = !isInString;
                    break;
                case OBJECT_END:
                    return new ValuePack<>(i, object);
                default:
                    //if(collectingKey && isInString)
                    if(isInString)
                        key.append(curChar);
            }
        }

        throw new IllegalArgumentException("Improperly formed JSON object");
    }
    private static ValuePack<JSONArray> parseArray(String s)
    {
        JSONArray array = new SimpleJSONArray();

        for(int i = 0; i < s.length(); i++)
        {
            char currChar = s.charAt(i);

            if(currChar == ARRAY_END)
                return new ValuePack<>(i, array);

            ValuePack pack = parseValue(s.substring(1));
            array.addJSONValue(pack.getValue());
            i = pack.getEndIndex();
        }

        throw new IllegalArgumentException("Improperly formed JSON array");
    }
    private static ValuePack<JSONString> parseString(String s)
    {
        StringBuilder sb = new StringBuilder();

        boolean isEscaped = false;
        for(int i = 0; i < s.length(); i++)
        {
            char currChar = s.charAt(i);

            if(isEscaped)
            {
                sb.append(currChar);
                isEscaped = false;
                continue;
            }

            if(currChar == ESCAPE)
            {
                isEscaped = true;
                continue;
            }

            if(currChar == DOUBLE_QUOTE)
                return new ValuePack<>(i, new SimpleJSONString(sb.toString()));

            sb.append(currChar);
        }

        throw new IllegalArgumentException("Improperly formatted JSON string value");
    }
    private static ValuePack parseValue(String s)
    {
        switch(s.charAt(0))
        {
            case DOUBLE_QUOTE:
                return parseString(s.substring(1));
            case OBJECT_START:
                return parseObject(s.substring(1));
            case ARRAY_START:
                return parseArray(s.substring(1));
            default:
                int endIndex = getNextTerminalCharIndex(s);
                String value = s.substring(0, endIndex);

                if(value.matches("^-*[0-9]+$"))
                    return new ValuePack<>(endIndex, new SimpleJSONLong(Long.parseLong(value)));
                if(value.matches("^-*[0-9]+\\.([0-9]+)?"))
                    return new ValuePack<>(endIndex, new SimpleJSONDouble(Double.parseDouble(value)));
                if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false"))
                    return new ValuePack<>(endIndex, new SimpleJSONBoolean(Boolean.parseBoolean(value)));
                //if(value.equalsIgnoreCase("null"))
                return new ValuePack<>(endIndex, new SimpleJSONNull());
        }
    }

    private static int getNextTerminalCharIndex(String s)
    {
        int endObjectIndex = s.indexOf(OBJECT_END);
        int endArrayIndex = s.indexOf(ARRAY_END);
        int endPairIndex = s.indexOf(COMMA);

        int minIndex = endObjectIndex;//-1;
        if(endArrayIndex > 0 && endArrayIndex < minIndex)
            minIndex = endArrayIndex;
        if(endPairIndex > 0 && endPairIndex < minIndex)
            minIndex = endPairIndex;

        return minIndex;
    }

    private static class ValuePack<V extends JSONValue>
    {
        private ValuePack(int endIndex, V value)
        {
            this.endIndex = endIndex;
            this.value = value;
        }

        public int getEndIndex()
        {
            return endIndex;
        }

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
