package construction.dependencytree;


public class RealMain
{

    public static void main(String[] args)
    {
        Node DeathStar = new Node("DeathStar");
        System.out.println(RequirementFactory.getOrderedRequiredItems(DeathStar));
    }

}
