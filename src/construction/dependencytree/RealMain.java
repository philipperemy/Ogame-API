package construction.dependencytree;


public class RealMain
{

    public static void main(String[] args)
    {
        Node deathStar = NodeDictionary.DeathStar;
        System.out.println(RequirementFactory.getOrderedRequiredItems(deathStar));
    }

}
