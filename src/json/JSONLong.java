package json;

/**
 * Marks an object that represents an integer JSON value.
 *
 * Some examples would be:
 * {
 *     "value1" : 3
 *     "value2" : -1
 * }
 *
 * @author Alex
 */
public interface JSONLong extends JSONValue
{
    /**
     * Supplies the value as a long
     * @return The value as a long
     */
    public long toLong();

    /**
     * Casts the value to a int and returns the value
     * @return The value as an int
     */
    public int toInt();
}
