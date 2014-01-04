package construction.facility;

import construction.Construction;
import construction.ConstructionRefManager;
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
        return ConstructionRefManager.RESEARCH_LAB_REF;
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.ResearchLab, getLevel());
    }

    @Override
    public String getName()
    {
        return NamingFactory.ResearchLab;
    }
}
