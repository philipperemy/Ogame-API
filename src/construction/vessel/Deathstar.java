package construction.vessel;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Deathstar extends Construction
{
    @Override
    protected String getRef()
    {
        return ConstructionRefManager.DEATH_STAR_REF;
    }

    @Override
    protected String getDescription()
    {
        return "The destructive power of the deathstar is unsurpassed.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.DeathStar);
    }

    @Override
    public String getName()
    {
        return NamingFactory.DeathStar;
    }
}
