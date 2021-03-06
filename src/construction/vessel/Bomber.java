package construction.vessel;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Bomber extends Construction
{
    @Override
    protected String getRef()
    {
        return ConstructionRefManager.BOMBER_REF;
    }

    @Override
    protected String getDescription()
    {
        return "The bomber was developed especially to destroy the planetary defenses of a world.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.Bomber);
    }

    @Override
    public String getName()
    {
        return NamingFactory.Bomber;
    }
}
