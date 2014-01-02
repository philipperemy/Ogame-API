package construction.facility;

import construction.Construction;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Terraformer extends Construction
{

    @Override
    protected String getDescription()
    {
        return "The terraformer increases the usable surface of planets.";
    }

    @Override
    protected String getRef()
    {
        return "33";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.merge(NamingFactory.Terraformer, getLevel()));
    }
}
