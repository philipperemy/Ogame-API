package construction.facility;

import construction.Construction;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class ResearchLab extends Construction
{

    @Override
    protected String getDescription()
    {
        return "A research lab is required in order to conduct research into new technologies.";
    }

    @Override
    protected String getRef()
    {
        return "31";
    }

    @Override
    protected Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.merge(NamingFactory.ResearchLab, getLevel()));
    }
}
