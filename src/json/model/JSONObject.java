package json.model;

import java.util.List;

/**
 * Marks an object which is a JSON object
 *
 * @author Alex
 */
public interface JSONObject
{
    /**
     * Returns a list of {@link JSONPair} objects which are in the object
     * @return A list of {@link JSONPair} objects
     */
    public List<JSONPair> getMembers();
}
