package construction.vessel;

import construction.Construction;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class EspionageProbe extends Construction
{
    @Override
    protected String getRef()
    {
        return "210";
    }

    @Override
    protected String getDescription()
    {
        return "Espionage probes are small, agile drones that provide data on fleets and planets over great distances.";
    }

    @Override
    protected Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.EspionageProbe);
    }
}
