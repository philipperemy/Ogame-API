package construction.vessel;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class EspionageProbe extends Construction
{
    @Override
    protected String getRef()
    {
        return ConstructionRefManager.ESPIONAGE_PROBE_REF;
    }

    @Override
    protected String getDescription()
    {
        return "Espionage probes are small, agile drones that provide data on fleets and planets over great distances.";
    }

    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.EspionageProbe);
    }

    @Override
    public String getName()
    {
        return NamingFactory.EspionageProbe;
    }
}
