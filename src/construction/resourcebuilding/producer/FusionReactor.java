package construction.resourcebuilding.producer;

public class FusionReactor extends EnergyProducer
{

    @Override
    protected String getDescription()
    {
        return "The fusion reactor uses deuterium to produce energy.";
    }

    @Override
    protected String getRef()
    {
        return "12";
    }

}
