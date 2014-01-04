package construction.resourcebuilding.producer;

import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class FusionReactor extends EnergyProducer
{

    @Override
    protected String getDescription()
    {
        return "The fusion reactor uses deuterium to produce energy.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.FUSION_REACTOR_REF;
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.FusionReactor, getLevel());
    }

    @Override
    public String getName()
    {
        return NamingFactory.FusionReactor;
    }

}
