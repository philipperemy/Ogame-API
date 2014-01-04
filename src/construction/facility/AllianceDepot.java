package construction.facility;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;

public class AllianceDepot extends Construction
{

    @Override
    protected String getDescription()
    {
        return "The alliance depot supplies fuel to friendly fleets in orbit helping with defense.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.ALLIANCE_DEPOT_REF;
    }

    @Override
    public String getName()
    {
        return NamingFactory.AllianceDepot;
    }

}
