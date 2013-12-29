package construction.facility;

import construction.Construction;

public class Shipyard extends Construction
{

    @Override
    protected String getDescription()
    {
        return "All types of ships and defensive facilities are built in the planetary shipyard.";
    }

    @Override
    protected String getRef()
    {
        return "21";
    }
}
