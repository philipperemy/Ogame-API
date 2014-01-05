package construction.resourcebuilding.mine;

import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class DeuteriumSynthesizer extends Mine
{

    @Override
    protected String getDescription()
    {
        return "Deuterium-Synthesizers draw the trace Deuterium content from the water on a planet.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.DEUTERIUM_SYNTHETISER_REF;
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.DeuteriumSynthesizer, getLevel());
    }

    @Override
    public String getName()
    {
        return NamingFactory.DeuteriumSynthesizer;
    }
}
