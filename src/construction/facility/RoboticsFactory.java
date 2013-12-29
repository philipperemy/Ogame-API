package construction.facility;

import construction.Construction;

public class RoboticsFactory extends Construction
{

    @Override
    protected String getDescription()
    {
        return "Robotic factories provide construction robots to aid in the construction of buildings. Each level increases the speed of the upgrade of buildings.";
    }

    @Override
    protected String getRef()
    {
        return "14";
    }
}
