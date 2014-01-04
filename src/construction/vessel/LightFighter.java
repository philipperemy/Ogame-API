package construction.vessel;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class LightFighter extends Construction
{
    @Override
    protected String getRef()
    {
        return ConstructionRefManager.LIGHT_FIGHTER_REF;
    }

    @Override
    protected String getDescription()
    {
        return "This is the first fighting ship all emperors will build. The light fighter is an agile ship, but vulnerable on its own. In mass numbers, they can become a great threat to any empire. They are the first to accompany small and large cargoes to hostile planets with minor defences.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.LightFighter);
    }

    @Override
    public String getName()
    {
        return NamingFactory.LightFighter;
    }

}
