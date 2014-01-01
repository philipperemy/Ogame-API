package construction.vessel;

import construction.Construction;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Deathstar extends Construction
{
    @Override
    protected String getRef()
    {
        return "214";
    }

    @Override
    protected String getDescription()
    {
        return "The destructive power of the deathstar is unsurpassed.";
    }

    @Override
    protected Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.DeathStar);
    }
}
