package construction.resourcebuilding.producer;

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
        return "12";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.merge(NamingFactory.FusionReactor, getLevel()));
    }

}
