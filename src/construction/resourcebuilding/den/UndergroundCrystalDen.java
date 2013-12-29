package construction.resourcebuilding.den;

import construction.Construction;

public class UndergroundCrystalDen extends Construction
{

    @Override
    protected String getDescription()
    {
        return "A portion of the crystal stocks will be stored here safe from plundering. The Den does not expand the overall storage capacity.";
    }

    @Override
    protected String getRef()
    {
        return "26";
    }
}
