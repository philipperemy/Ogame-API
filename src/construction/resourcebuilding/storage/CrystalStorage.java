package construction.resourcebuilding.storage;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;

public class CrystalStorage extends Construction
{

    @Override
    protected String getDescription()
    {
        return "Provides storage for excess crystal.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.CRYSTAL_STORAGE_REF;
    }

    @Override
    public String getName()
    {
        return NamingFactory.CrystalStorage;
    }

}
