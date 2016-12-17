package json;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alex on 12/17/2016.
 */
public class JSONParser
{
    public static void main(String[] args)
    {
        List<JSONParser.Pair> pairs = new LinkedList<>();
        JSONParser.parseJSON("{ name: value, array: [ 1, 2 ], object: { name2: value2, name3: value3 } }")
                  .forEach(System.out::println);
    }

    /**
     * Handles -> initial nameless object
     * @param json
     */
    public static List<Pair> parseJSON(String json)
    {
        List<Pair> pairs = new LinkedList<>();

        StringBuilder sb = new StringBuilder(json.trim());
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        Result parseResult = null;

        do
        {
            String name = sb.substring(0, sb.indexOf(COLON)).trim();
            parseResult = getNextParsedResult(sb.delete(0, sb.indexOf(COLON)+1));
            pairs.add(new Pair(name, parseResult.getResult()));
        }
        while(sb.length() > 0);

        return pairs;
    }

    /**
     * Handles a key value pair. Leaves the rest on the StringBuilder Example -> key: value ...
     * @param sb
     * @return
     */
    private static Pair parsePair(StringBuilder sb)
    {
        String name = sb.substring(0, sb.indexOf(COLON)).trim();
        Result parseResult = getNextParsedResult(sb.delete(0, sb.indexOf(COLON)+1));

        return new Pair(name, parseResult.getResult());
    }

    /**
     * Parses a single value and leaves the res to the String Builder. Example ->  value ...
     * @param sb
     * @return
     */
    private static Result getNextParsedResult(StringBuilder sb)
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
    private static Result parseArray(StringBuilder sb)
    {
        sb.deleteCharAt(0);

        List<Result> results = new LinkedList<>();

        Result result = null;
        do
        {
            result = getNextParsedResult(sb);
            results.add(result);
        }
        while(!result.getResult().toString().endsWith(ARRAY_END) && sb.length() > 0);

        return new Result()
        {
            @Override
            public Object getResult()
            {
                return results;
            }

            @Override
            public String toString()
            {
                return results.stream().map(Object::toString).collect(Collectors.joining("\n"));
            }
        };
    }

    /**
     * Parses a single non-array, non-object value and leaves the rest on the String Builder.
     * @param sb
     * @return
     */
    private static Result parseValue(StringBuilder sb)
    {
        if(sb.indexOf(COMMA) < 0)
        {
            String value = sb.toString().trim();
            sb.delete(0, sb.length());
            return () -> value;
        }
        else
        {
            String value = sb.substring(0, sb.indexOf(COMMA));
            sb.delete(0, sb.indexOf(COMMA) + 1);
            return () -> value;
        }
    }

    /**
     * Parses a single object and leaves the rest on the StringBuilder.
     * @param sb
     * @return
     */
    private static Result parseObject(StringBuilder sb)
    {
        sb.deleteCharAt(0);

        List<Pair> pairs = new LinkedList<>();

        Pair pair = null;
        do
        {
            pair = parsePair(sb);
            pairs.add(pair);
        }
        while(!pair.getValue().toString().endsWith(OBJECT_END) && sb.length() > 0);


        return () -> pairs;
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