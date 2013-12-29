package construction.facility;

import construction.Construction;

public class Terraformer extends Construction
{

    @Override
    protected String getDescription()
    {
        return "The terraformer increases the usable surface of planets.";
    }

    @Override
    protected String getRef()
    {
        return "33";
    }
}
