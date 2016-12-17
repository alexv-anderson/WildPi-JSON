package json;

import java.util.List;

/**
 * Helper methods for common JSON operations
 *
 * @author Alex
 */
public class JSONHelper
{
    /**
     * Transforms a boolean into a JSON value.
     * @param name     The name of the variable.
     * @param value    The value of the variable
     * @return The JSON representation of the variable.
     */
    public static String makeJSON(String name, boolean value)
    {
        return "\"" + name + "\":" + value;
    }
    /**
     * Transforms a long into a JSON value.
     * @param name     The name of the variable.
     * @param value    The value of the variable
     * @return The JSON representation of the variable.
     */
    public static String makeJSON(String name, long value)
    {
        return "\"" + name + "\":" + value;
    }
    /**
     * Transforms a double into a JSON value.
     * @param name     The name of the variable.
     * @param value    The value of the variable
     * @return The JSON representation of the variable.
     */
    public static String makeJSON(String name, double value)
    {
        if(Double.isNaN(value))
            throw new JSONFormatException(String.format("Invalid JSON for \"%s\" JSON does not support NaN", name));
        if(Double.compare(Double.NEGATIVE_INFINITY, value) == 0)
            throw new JSONFormatException(String.format("Invalid JSON for \"%s\" JSON does not support -Infinity", name));
        if(Double.compare(Double.POSITIVE_INFINITY, value) == 0)
            throw new JSONFormatException(String.format("Invalid JSON for \"%s\" JSON does not support +Infinity", name));
        return "\"" + name + "\":" + value;
    }
    /**
     * Transforms a String into a JSON value.
     * @param name     The name of the variable.
     * @param value    The value of the variable
     * @return The JSON representation of the variable.
     */
    public static String makeJSON(String name, String value)
    {
        return "\"" + name + "\":\"" + value + "\"";
    }

    /**
     * Transforms a list of JSONable objects into a JSON array.
     * @param name     The name of the list.
     * @param list     The list JSONable objects.
     * @return The JSON representation of the list.
     */
    public static String makeJSON(String name, List<? extends ToJSONable> list)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("\"");
        sb.append(name);
        sb.append("\":[");

        for(int i = 0; i < list.size(); i++)
        {
            if(i > 0)
                sb.append(",");
            try
            {
                sb.append(list.get(i).toJSON());
            }
            catch(JSONFormatException e)
            {
                throw new JSONFormatException(String.format("Could not construct JSON for list \"%s\"", name), e);
            }
        }

        sb.append("]");

        return sb.toString();
    }

}
