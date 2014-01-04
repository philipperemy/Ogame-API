package construction.facility;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class RoboticsFactory extends Construction
{

    @Override
    protected String getDescription()
    {
        return "Robotic factories provide construction robots to aid in the construction of buildings. Each level increases the speed of the upgrade of buildings.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.ROBOTICS_FACTORY_REF;
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.RoboticsFactory, getLevel());
    }

    @Override
    public String getName()
    {
        return NamingFactory.RoboticsFactory;
    }
}
