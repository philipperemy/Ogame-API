package construction.vessel;

import construction.Construction;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class ColonyShip extends Construction
{
    @Override
    protected String getRef()
    {
        return "208";
    }

    @Override
    protected String getDescription()
    {
        return "Vacant planets can be colonized with this ship.";
    }

    @Override
    protected Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.ColonyShip);
    }

}
