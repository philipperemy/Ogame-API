package construction.facility;

import construction.Construction;

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
        return "34";
    }
}
