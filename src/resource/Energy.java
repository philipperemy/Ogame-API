package resource;

import java.math.BigInteger;

public class Energy extends Resource
{
    private BigInteger consumption;

    @Override
    public String toString()
    {
        return "Energy [available=" + getAvailable() + ", currentProduction=" + getCurrentProduction() + ", consumption=" + consumption + " ]";
    }

    public void setConsumption(BigInteger _consumption)
    {
        consumption = _consumption;
    }
}