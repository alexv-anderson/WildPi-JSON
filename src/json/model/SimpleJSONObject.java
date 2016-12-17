package json.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 12/17/2016.
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

    private List<JSONPair> pairs;
}
