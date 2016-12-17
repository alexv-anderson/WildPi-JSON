package json.model;

import json.model.values.JSONValue;

/**
 * Created by Alex on 12/17/2016.
 */
public interface JSONPair<T>
{
    public String getName();
    public JSONValue<T> getValue();
}
