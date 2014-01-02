package construction;

import java.math.BigInteger;
import tool.Duration;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public abstract class Construction
{
    // TODO: create equals() and hashCode() methods because the class is used in sets.
    private Duration   duration;
    private int        level;

    private BigInteger metalRequired     = BigInteger.ZERO;
    private BigInteger crystalRequired   = BigInteger.ZERO;
    private BigInteger deuteriumRequired = BigInteger.ZERO;

    protected abstract String getRef();

    @Override
    public String toString()
    {
        return "Construction [" + (duration != null ? "duration=" + duration + ", " : "") + "level=" + level + ", " + (metalRequired != null ? "metalReq=" + metalRequired + ", " : "")
            + (crystalRequired != null ? "crystalReq=" + crystalRequired + ", " : "") + (deuteriumRequired != null ? "deuteriumReq=" + deuteriumRequired + ", " : "") + (getRef() != null ? "getRef()=" + getRef() + ", " : "")
            + (getDescription() != null ? "desc=" + getDescription() : "") + "]";
    }

    // Default behavior. Must be override if necessary
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode();
    }

    protected abstract String getDescription();

    public Duration getDuration()
    {
        return duration;
    }

    public void setDuration(Duration duration)
    {
        this.duration = duration;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public BigInteger getMetalRequired()
    {
        return metalRequired;
    }

    public void setMetalRequired(BigInteger metalRequired)
    {
        this.metalRequired = metalRequired;
    }

    public BigInteger getCrystalRequired()
    {
        return crystalRequired;
    }

    public void setCrystalRequired(BigInteger crystalRequired)
    {
        this.crystalRequired = crystalRequired;
    }

    public BigInteger getDeuteriumRequired()
    {
        return deuteriumRequired;
    }

    public void setDeuteriumRequired(BigInteger deuteriumRequired)
    {
        this.deuteriumRequired = deuteriumRequired;
    }

}
