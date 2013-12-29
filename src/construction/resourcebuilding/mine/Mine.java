package construction.resourcebuilding.mine;

import java.math.BigInteger;
import construction.Construction;

public abstract class Mine extends Construction
{
    private BigInteger energyNeeded;

    public BigInteger getEnergyNeeded()
    {
        return energyNeeded;
    }

    public void setEnergyNeeded(BigInteger energyNeeded)
    {
        this.energyNeeded = energyNeeded;
    }
}
