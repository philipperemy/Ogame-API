package construction.facility;

import construction.Construction;
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
        return "21";
    }

    @Override
    protected Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.merge(NamingFactory.Shipyard, getLevel()));
    }
}
