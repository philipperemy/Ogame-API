package construction.vessel;

import construction.Construction;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class SmallCargo extends Construction
{
    @Override
    protected String getRef()
    {
        return "202";
    }

    @Override
    protected String getDescription()
    {
        return "The small cargo is an agile ship which can quickly transport resources to other planets.";
    }

    @Override
    protected Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.SmallCargoShip);
    }

}
