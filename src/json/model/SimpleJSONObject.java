package json.model;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple bare-bones implementation of {@link JSONObject}
 *
 * @author Alex
 */
class SimpleJSONObject implements JSONObject
{
    public SimpleJSONObject()
    {
        this.pairs = new LinkedList<>();
    }
    public SimpleJSONObject(List<JSONPair> pairs)
    {
        this.pairs = new LinkedList<>(pairs);
    }

    @Override
    public List<JSONPair> getMembers()
    {
        return pairs;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        SimpleJSONObject that = (SimpleJSONObject) o;

        return pairs.equals(that.pairs);

    }

    @Override
    public int hashCode()
    {
        return pairs.hashCode();
    }

    private List<JSONPair> pairs;
}
