package resource;

import java.math.BigInteger;

public class RawResource extends Resource
{
    @Override
    public String toString()
    {
        return " [available=" + getAvailable() + ", storageCapacity=" + getStorageCapacity() + ", currentProduction=" + getCurrentProduction() + ", denCapacity=" + getDenCapacity() + " ]";
    }

    private BigInteger storageCapacity;

    private BigInteger denCapacity;

    public BigInteger getStorageCapacity()
    {
        return storageCapacity;
    }

    public BigInteger getDenCapacity()
    {
        return denCapacity;
    }

    public void setStorageCapacity(BigInteger _storageCapacity)
    {
        storageCapacity = _storageCapacity;
    }

    public void setDenCapacity(BigInteger _denCapacity)
    {
        denCapacity = _denCapacity;
    }

}
