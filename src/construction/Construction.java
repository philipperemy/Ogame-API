package construction;

import java.math.BigInteger;
import java.util.Random;
import tool.Duration;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public abstract class Construction
{
    @Override
    public String toString()
    {
        return "Construction [" + (name != null ? "name=" + name + ", " : "") + (level != null ? "level=" + level : "") + "]";
    }

    private static Random intGen = new Random();

    @Override
    public int hashCode()
    {
        if (getLevel() == null)
        {
            return intGen.nextInt(Integer.MAX_VALUE);
        }
        else
        {
            return getDescription().hashCode() * 1337 + level.hashCode();
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Construction other = (Construction) obj;

        if (other.getLevel() == null || getLevel() == null)
        {
            return false;
        }

        if (other.getDescription().equals(getDescription()))
        {
            if (other.getLevel().intValue() == getLevel().intValue())
            {
                return true;
            }
        }

        return false;
    }

    private Duration     duration;
    private String       name              = getName();
    private Integer      level             = null;
    private Construction previous          = null;

    private BigInteger   metalRequired     = BigInteger.ZERO;
    private BigInteger   crystalRequired   = BigInteger.ZERO;
    private BigInteger   deuteriumRequired = BigInteger.ZERO;

    protected abstract String getRef();

    public abstract String getName();

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

    public Integer getLevel()
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

    public Construction getPrevious()
    {
        return previous;
    }

    public void setPrevious(Construction previous)
    {
        this.previous = previous;
    }

}
