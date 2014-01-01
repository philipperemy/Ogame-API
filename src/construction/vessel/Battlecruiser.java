package construction.vessel;

import construction.Construction;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Battlecruiser extends Construction
{
    @Override
    protected String getRef()
    {
        return "215";
    }

    @Override
    protected String getDescription()
    {
        return "The Battlecruiser is highly specialized in the interception of hostile fleets.";
    }

    @Override
    protected Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.BattleCruiser);
    }
}
