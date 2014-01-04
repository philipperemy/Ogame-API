package construction.vessel;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class Destroyer extends Construction
{
    @Override
    protected String getRef()
    {
        return ConstructionRefManager.DESTROYER_REF;
    }

    @Override
    protected String getDescription()
    {
        return "The destroyer is the king of the warships.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.Destroyer);
    }

    @Override
    public String getName()
    {
        return NamingFactory.Destroyer;
    }
}
