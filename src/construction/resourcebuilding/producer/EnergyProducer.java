package construction.resourcebuilding.producer;

import java.math.BigInteger;
import construction.Construction;

public abstract class EnergyProducer extends Construction
{
    private BigInteger production;

    public BigInteger getProduction()
    {
        return production;
    }

    public void setProduction(BigInteger production)
    {
        this.production = production;
    }

}
