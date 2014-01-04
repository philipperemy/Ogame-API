package construction.vessel;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class ColonyShip extends Construction
{
    @Override
    protected String getRef()
    {
        return ConstructionRefManager.COLONY_SHIP_REF;
    }

    @Override
    protected String getDescription()
    {
        return "Vacant planets can be colonized with this ship.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.ColonyShip);
    }

    @Override
    public String getName()
    {
        return NamingFactory.ColonyShip;
    }

}
