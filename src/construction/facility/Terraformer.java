package construction.facility;

import construction.Construction;
import construction.ConstructionRefManager;
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
        return ConstructionRefManager.TERRAFORMER_REF;
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.Terraformer, getLevel());
    }

    @Override
    public String getName()
    {
        return NamingFactory.Terraformer;
    }
}
