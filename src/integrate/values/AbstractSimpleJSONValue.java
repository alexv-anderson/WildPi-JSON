package integrate.values;

/**
 * Created by Alex on 5/1/2017.
 */
abstract class AbstractSimpleJSONValue<V>
{
    protected abstract V getValue();

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        AbstractSimpleJSONValue<?> that = (AbstractSimpleJSONValue<?>) o;

        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode()
    {
        return getValue().hashCode();
    }
}
