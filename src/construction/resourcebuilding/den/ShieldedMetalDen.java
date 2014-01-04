package construction.resourcebuilding.den;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;

public class ShieldedMetalDen extends Construction
{
    @Override
    protected String getDescription()
    {
        return "A portion of the metal stocks will be stored here safe from plundering. The Den does not expand the overall storage capacity.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.SHIELDED_METAL_DEN_REF;
    }

    @Override
    public String getName()
    {
        return NamingFactory.ShieldedMetalDen;
    }

}
