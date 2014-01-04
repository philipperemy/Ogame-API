package construction.vessel;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Battlecruiser extends Construction
{
    @Override
    protected String getRef()
    {
        return ConstructionRefManager.BATTLE_CRUISER_REF;
    }

    @Override
    protected String getDescription()
    {
        return "The Battlecruiser is highly specialized in the interception of hostile fleets.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.BattleCruiser);
    }

    @Override
    public String getName()
    {
        return NamingFactory.BattleCruiser;
    }
}
