package construction.vessel;

import construction.Construction;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class LargeCargo extends Construction
{
    @Override
    protected String getRef()
    {
        return "203";
    }

    @Override
    protected String getDescription()
    {
        return "This cargo ship has a much larger cargo capacity than the small cargo, and is generally faster thanks to an improved drive.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.LargeCargoShip);
    }

}
