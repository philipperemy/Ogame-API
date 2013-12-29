package construction.facility;

import construction.Construction;

public class NaniteFactory extends Construction
{

    @Override
    protected String getDescription()
    {
        return "This is the ultimate in robotics technology. Each level cuts the construction time for buildings, ships, and defenses.";
    }

    @Override
    protected String getRef()
    {
        return "15";
    }
}
