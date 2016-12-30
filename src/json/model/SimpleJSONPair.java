package json.model;

import json.model.values.JSONValue;

/**
 * A simple bare-bones implementation of {@link JSONPair}
 *
 * @param <T>    The type of value stored in this pair.
 *
 * @author Alex
 */
class SimpleJSONPair<T> implements JSONPair<T>
{
    public SimpleJSONPair(String name, JSONValue<T> jsonValue)
    {
        this.name = name;
        this.jsonValue = jsonValue;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public JSONValue<T> getValue()
    {
        return jsonValue;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        SimpleJSONPair<?> that = (SimpleJSONPair<?>) o;

        if(!name.equals(that.name)) return false;
        return jsonValue.equals(that.jsonValue);

    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + jsonValue.hashCode();
        return result;
    }

    private String name;
    private JSONValue<T> jsonValue;
}
