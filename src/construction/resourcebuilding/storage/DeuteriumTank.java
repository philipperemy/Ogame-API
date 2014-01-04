package construction.resourcebuilding.storage;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;

public class DeuteriumTank extends Construction
{

    @Override
    protected String getDescription()
    {
        return "Giant tanks for storing newly-extracted deuterium.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.DEUTERIUM_TANK_REF;
    }

    @Override
    public String getName()
    {
        return NamingFactory.DeuteriumTank;
    }

}
