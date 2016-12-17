package json;

import json.model.JSONArray;
import json.model.JSONFactory;
import json.model.JSONObject;
import json.model.JSONPair;
import json.model.values.ArrayJSONValue;
import json.model.values.JSONValue;
import json.model.values.ObjectJSONValue;
import json.model.values.StringJSONValue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 12/17/2016.
 */
public class JSONModelParser
{
    public static void main(String[] args)
    {
        List<JSONModelParser.Pair> pairs = new LinkedList<>();
        JSONObject jsonObject = JSONModelParser.parseJSON("{ name: value, array: [ 1, 2 ], object: { name2: value2, name3: value3 } }");
        System.out.println("Hello");
    }

    /**
     * Handles -> initial nameless object
     * @param json
     */
    public static JSONObject parseJSON(String json)
    {
        JSONObject jsonObject = JSONFactory.getEmptyJSONObject();

        StringBuilder sb = new StringBuilder(json.trim());
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);

        while(sb.length() > 0)
            jsonObject.getMembers().add(parsePair(sb));


        return jsonObject;
    }

    /**
     * Handles a key value pair. Leaves the rest on the StringBuilder Example -> key: value ...
     * @param sb
     * @return
     */
    private static JSONPair parsePair(StringBuilder sb)
    {
        String name = sb.substring(0, sb.indexOf(COLON)).trim();
        JSONValue value = getNextParsedResult(sb.delete(0, sb.indexOf(COLON)+1));

        return JSONFactory.getJSONPair(name, value);
    }

    /**
     * Parses a single value and leaves the res to the String Builder. Example ->  value ...
     * @param sb
     * @return
     */
    private static JSONValue getNextParsedResult(StringBuilder sb)
    {
        String s = sb.toString().trim();
        sb.delete(0, sb.length()).append(s);
        if(sb.charAt(0) == OBJECT_START.toCharArray()[0])
            return parseObject(sb);
        else if(sb.charAt(0) == ARRAY_START.toCharArray()[0])
            return parseArray(sb);
        else
            return parseValue(sb);
    }

    /**
     * Parses a single array and leaves the rest on the StringBuilder. Example -> [ ... ]
     * @param sb
     * @return
     */
    private static JSONValue parseArray(StringBuilder sb)
    {
        sb.deleteCharAt(0);

        //List<JSONValue> results = new LinkedList<>();
        JSONArray jsonArray = JSONFactory.getEmptyJSONArray(Object.class);

        JSONValue result = null;
        do
        {
            result = getNextParsedResult(sb);
            jsonArray.getElements().add(result);
        }
        while(!result.getValue().toString().endsWith(ARRAY_END) && sb.length() > 0);

        return new ArrayJSONValue(jsonArray);
    }

    /**
     * Parses a single non-array, non-object value and leaves the rest on the String Builder.
     * @param sb
     * @return
     */
    private static JSONValue parseValue(StringBuilder sb)
    {
        if(sb.indexOf(COMMA) < 0)
        {
            String value = sb.toString().trim();
            sb.delete(0, sb.length());
            return new StringJSONValue(value);
        }
        else
        {
            String value = sb.substring(0, sb.indexOf(COMMA));
            sb.delete(0, sb.indexOf(COMMA) + 1);
            return new StringJSONValue(value);
        }
    }

    /**
     * Parses a single object and leaves the rest on the StringBuilder.
     * @param sb
     * @return
     */
    private static JSONValue parseObject(StringBuilder sb)
    {
        sb.deleteCharAt(0);

        JSONObject jsonObject = JSONFactory.getEmptyJSONObject();

        JSONPair pair = null;
        do
        {
            pair = parsePair(sb);
            jsonObject.getMembers().add(pair);
        }
        while(!pair.getValue().toString().endsWith(OBJECT_END) && sb.length() > 0);


        return new ObjectJSONValue(jsonObject);
    }

    private static final String OBJECT_START = "{";
    private static final String OBJECT_END = "}";
    private static final String ARRAY_START = "[";
    private static final String ARRAY_END = "]";

    private static final String COMMA = ",";
    private static final String COLON = ":";

    private static interface Result
    {
        public Object getResult();
    }

//    public static interface Pair<V>
//    {
//        public String getName();
//        public V getValue();
//    }

    public static class Pair//StringValuedPair implements Pair<String>
    {
        /*public Pair(String name)
        {
            this(name, null);
        }*/

        public Pair(String name, Object value)//StringValuedPair(String name, String value)
        {
            this.name = name;
            this.value = value;
        }

        public String getName()
        {
            return name;
        }

        public Object getValue()
        {
            return value;
        }

        @Override
        public boolean equals(Object o)
        {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;

            Pair that = (Pair) o;

            if(name != null ? !name.equals(that.name) : that.name != null) return false;
            return value != null ? value.equals(that.value) : that.value == null;

        }

        @Override
        public int hashCode()
        {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }

        @Override
        public String toString()
        {
            return "Pair{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    '}';
        }

        private String name;
        private Object value;
    }
}