package resource;


public class ResourcesList
{
    private Metal     metal     = new Metal();
    private Crystal   crystal   = new Crystal();
    private Deuterium deuterium = new Deuterium();
    private Energy    energy    = new Energy();

    public Metal getMetal()
    {
        return metal;
    }

    public Crystal getCrystal()
    {
        return crystal;
    }

    public Deuterium getDeuterium()
    {
        return deuterium;
    }

    public Energy getEnergy()
    {
        return energy;
    }

}
