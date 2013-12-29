package resource;

import java.math.BigInteger;

public class ResourcesList
{
    private static Metal     metal     = new Metal();
    private static Crystal   crystal   = new Crystal();
    private static Deuterium deuterium = new Deuterium();
    private static Energy    energy    = new Energy();

    static class Resource
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

    static class RawResource extends Resource
    {
        @Override
        public String toString()
        {
            return " [available=" + getAvailable() + ", storageCapacity=" + storageCapacity + ", currentProduction=" + getAvailable() + ", denCapacity=" + denCapacity + " ]";
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

    public static class Metal extends RawResource
    {
        @Override
        public String toString()
        {
            return "Metal" + super.toString();
        }

    }

    public static class Crystal extends RawResource
    {
        @Override
        public String toString()
        {
            return "Crystal" + super.toString();
        }
    }

    public static class Deuterium extends RawResource
    {
        @Override
        public String toString()
        {
            return "Deuterium" + super.toString();
        }
    }

    public static class Energy extends Resource
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

    public static Metal getMetal()
    {
        return metal;
    }

    public static Crystal getCrystal()
    {
        return crystal;
    }

    public static Deuterium getDeuterium()
    {
        return deuterium;
    }

    public static Energy getEnergy()
    {
        return energy;
    }

}
