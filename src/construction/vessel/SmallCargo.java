package construction.vessel;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class SmallCargo extends Construction
{
    @Override
    protected String getRef()
    {
        return ConstructionRefManager.SMALL_CARGO_REF;
    }

    @Override
    protected String getDescription()
    {
        return "The small cargo is an agile ship which can quickly transport resources to other planets.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.SmallCargoShip);
    }

    @Override
    public String getName()
    {
        return NamingFactory.SmallCargoShip;
    }

}
