package construction.dependencytree;

public class RealMain
{

    public static void main(String[] args)
    {
        Node deathStar = NodeDictionary.DeathStar;
        RequirementFactory.getOrderedRequiredItems(deathStar).toString();
        String actual = RequirementFactory.getOrderedRequiredItems(deathStar).toString();
        System.out.println(actual);

        String expectedStr = "[RootNode, ResearchLab1, RoboticsFactory1, EnergyTechnology1, ResearchLab2, ResearchLab3, ResearchLab4, RoboticsFactory2, Shipyard1, ResearchLab5, Shipyard2, Shipyard3, ResearchLab6, ResearchLab7, Shipyard4, EnergyTechnology2, ResearchLab8, Shipyard5, Shipyard6, ResearchLab9, EnergyTechnology3, Shipyard7, ShieldingTechnology1, ResearchLab10, EnergyTechnology4, EnergyTechnology5, ShieldingTechnology2, ResearchLab11, Shipyard8, ResearchLab12, ShieldingTechnology3, ShieldingTechnology4, GravitonTechnology, Shipyard9, ShieldingTechnology5, Shipyard10, HyperspaceTechnology1, HyperspaceTechnology2, Shipyard11, HyperspaceTechnology3, Shipyard12, HyperspaceDrive1, HyperspaceTechnology4, HyperspaceTechnology5, HyperspaceDrive2, HyperspaceTechnology6, HyperspaceDrive3, HyperspaceDrive4, HyperspaceDrive5, HyperspaceDrive6, HyperspaceDrive7, DeathStar]";
        if (actual.equalsIgnoreCase(expectedStr))
        {
            System.out.println("OK");
        }
        else
        {
            System.out.println("KO");
        }
    }

}
