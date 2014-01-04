package construction.facility;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class NaniteFactory extends Construction
{

    @Override
    protected String getDescription()
    {
        return "This is the ultimate in robotics technology. Each level cuts the construction time for buildings, ships, and defenses.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.NANITE_FACTORY_REF;
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.NaniteFactory, getLevel());
    }

    @Override
    public String getName()
    {
        return NamingFactory.NaniteFactory;
    }
}
