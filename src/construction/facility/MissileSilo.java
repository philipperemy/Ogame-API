package construction.facility;

import construction.Construction;

public class MissileSilo extends Construction
{

    @Override
    protected String getDescription()
    {
        return "Missile silos are used to store missiles.";
    }

    @Override
    protected String getRef()
    {
        return "44";
    }
}
