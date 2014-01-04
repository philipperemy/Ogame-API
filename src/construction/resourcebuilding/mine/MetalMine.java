package construction.resourcebuilding.mine;

import construction.ConstructionRefManager;
import construction.NamingFactory;

public class MetalMine extends Mine
{
    @Override
    protected String getDescription()
    {
        return "Used in the extraction of metal ore, metal mines are of primary importance to all emerging and established empires.";
    }

    @Override
    protected String getRef()
    {
        return ConstructionRefManager.METAL_MINE_REF_REF;
    }

    @Override
    public String getName()
    {
        return NamingFactory.MetalMine;
    }

}
