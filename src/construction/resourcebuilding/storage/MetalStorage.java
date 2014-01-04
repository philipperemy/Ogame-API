package construction.resourcebuilding.storage;

import construction.Construction;
import construction.ConstructionRefManager;
import construction.NamingFactory;

public class MetalStorage extends Construction
{

    @Override
    protected String getDescription()
    {
        return "Provides storage for excess metal.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.METAL_STORAGE_REF;
    }

    @Override
    public String getName()
    {
        return NamingFactory.MetalStorage;
    }

}
