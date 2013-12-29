package construction.facility;

import construction.Construction;

public class ResearchLab extends Construction
{

    @Override
    protected String getDescription()
    {
        return "A research lab is required in order to conduct research into new technologies.";
    }
    
    @Override
    protected String getRef()
    {
        return "31";
    }
}
