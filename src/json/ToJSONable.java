package json;

/**
 * Provides a method which turns the implementing class into a JSON string
 *
 * @author Alex
 */
public interface ToJSONable
{
    /**
     * Generates a string representation of this object
     *  in a JSON format.
     *
     * @return A JSON representation of this object.
     */
    public String toJSON();
}
