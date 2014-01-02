package construction.vessel;

import construction.Construction;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class HeavyFighter extends Construction
{
    @Override
    protected String getRef()
    {
        return "205";
    }

    @Override
    protected String getDescription()
    {
        return "This fighter is better armoured and has a higher attack strength than the light fighter.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.HeavyFighter);
    }
}
