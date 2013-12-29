package construction.resourcebuilding.producer;

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
        return "4";
    }

}
