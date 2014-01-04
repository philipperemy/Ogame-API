package construction.vessel;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Recycler extends Construction
{
    @Override
    protected String getRef()
    {
        return ConstructionRefManager.RECYCLER_REF;
    }

    @Override
    protected String getDescription()
    {
        return "Recyclers are the only ships able to harvest debris fields floating in a planet`s orbit after combat.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.Recycler);
    }

    @Override
    public String getName()
    {
        return NamingFactory.Recycler;
    }
}
