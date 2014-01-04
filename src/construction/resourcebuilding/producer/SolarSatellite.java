package construction.resourcebuilding.producer;

import construction.ConstructionRefManager;
import construction.NamingFactory;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;

public class SolarSatellite extends EnergyProducer
{

    @Override
    protected String getDescription()
    {
        return "Solar satellites are simple platforms of solar cells, located in a high, stationary orbit. They gather sunlight and transmit it to the ground station via laser. A solar satellite produces 34 energy on this planet.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.SOLAR_SATELLITE_REF;
    }

    @Override
    public String getName()
    {
        return NamingFactory.SolarSatellite;
    }
    
    @Override
    public Node getDependencyNode()
    {
        return NodeDictionary.getNode(NamingFactory.SolarSatellite);
    }

}
