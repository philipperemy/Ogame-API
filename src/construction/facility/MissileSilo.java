package construction.facility;

import construction.Construction;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class MissileSilo extends Construction
{

    @Override
    protected String getDescription()
    {
        return "Missile silos are used to store missiles.";
    }

    @Override
    protected String getRef()
    {
        return "44";
    }

    /*@Override
    protected Node getDependencyNode()
    {
        return NodeDictionary.getNode(data)
    }*/
}
