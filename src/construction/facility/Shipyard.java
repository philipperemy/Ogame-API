package construction.facility;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Shipyard extends Construction
{

    @Override
    protected String getDescription()
    {
        return "All types of ships and defensive facilities are built in the planetary shipyard.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.SHIPYARD_REF;
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.Shipyard, getLevel());
    }

    @Override
    public String getName()
    {
        return NamingFactory.Shipyard;
    }
}
