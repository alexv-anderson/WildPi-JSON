package json;

/**
 * Helper class which handles equality and hash codes
 *
 * @param <V> The type of object which determines the object's overall equality.
 *
 * @author Alex
 */
abstract class AbstractSimpleJSONValue<V>
{
    /**
     * Supplies the value which determines the object's equality
     * @return The value which determines the object's equality
     */
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
