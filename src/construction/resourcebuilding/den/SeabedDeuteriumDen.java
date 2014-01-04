package construction.resourcebuilding.den;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;

public class SeabedDeuteriumDen extends Construction
{

    @Override
    protected String getDescription()
    {
        return "A portion of the Deuterium stocks will be stored here safe from plundering. The Den does not expand the overall storage capacity.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.SEABED_DEUTERIUM_DEN_REF;
    }

    @Override
    public String getName()
    {
        return NamingFactory.SeabedDeuteriumDen;
    }

}
