package construction.resourcebuilding.producer;

import construction.ConstructionRefManager;
import construction.NamingFactory;

public class SolarPlant extends EnergyProducer
{

    @Override
    protected String getDescription()
    {
        return "Solar power plants absorb energy from solar radiation. All mines need energy to operate.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.SOLAR_PLANT_REF;
    }

    @Override
    public String getName()
    {
        return NamingFactory.SolarPlant;
    }

}
