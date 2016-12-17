package json;

class MockToJSONable implements ToJSONable
{
    public MockToJSONable()
    {
        this(0);
    }
    public MockToJSONable(double value)
    {
        item0 = value;
    }
    @Override
    public final String toJSON() throws JSONFormatException
    {
        return JSONHelper.makeJSON("item0", item0);
    }

    private double item0 = 0;
}
