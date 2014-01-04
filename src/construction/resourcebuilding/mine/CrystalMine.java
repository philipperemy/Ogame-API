package construction.resourcebuilding.mine;

import construction.ConstructionRefManager;
import construction.NamingFactory;

public class CrystalMine extends Mine
{

    @Override
    protected String getDescription()
    {
        return "Crystals are the main resource used to build electronic circuits and form certain alloy compounds.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.CRYSTAL_MINE_REF;
    }

    @Override
    public String getName()
    {
        return NamingFactory.CrystalMine;
    }

}
