package construction.vessel;

import construction.Construction;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Destroyer extends Construction
{
    @Override
    protected String getRef()
    {
        return "213";
    }

    @Override
    protected String getDescription()
    {
        return "The destroyer is the king of the warships.";
    }

    @Override
    protected Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.Destroyer);
    }
}
