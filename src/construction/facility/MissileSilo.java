package construction.facility;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class MissileSilo extends Construction
{

    @Override
    protected String getDescription()
    {
        return "Missile silos are used to store missiles.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.MISSILE_SILO_REF;
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.MissileSilo, getLevel());
    }

    @Override
    public String getName()
    {
        return NamingFactory.MissileSilo;
    }
}
