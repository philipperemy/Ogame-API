package resource;

import java.math.BigInteger;

public class Resource
{
    private BigInteger available;
    private BigInteger currentProduction;

    public BigInteger getAvailable()
    {
        return available;
    }

    void setAvailable(BigInteger _available)
    {
        available = _available;
    }

    public void setCurrentProduction(BigInteger _currentProduction)
    {
        currentProduction = _currentProduction;
    }

    public BigInteger getCurrentProduction()
    {
        return currentProduction;
    }
}