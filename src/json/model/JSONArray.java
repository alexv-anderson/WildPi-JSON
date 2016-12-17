package json.model;

import json.model.values.JSONValue;

import java.util.List;

/**
 * Created by Alex on 12/17/2016.
 */
public interface JSONArray<T>
{
    public List<JSONValue<T>> getElements();
}
