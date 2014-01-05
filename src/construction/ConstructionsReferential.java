package construction;

import logger.Logger;
import construction.dependencytree.Node;

public class ConstructionsReferential
{
    private static ConstructionsList allConstructionsList = new ConstructionsList("null");

    static
    {
        try
        {
            for (Construction construction : allConstructionsList.listAllConstructions())
            {
                allConstructionsList.initStruct(construction, 99);
            }
        }
        catch (Exception e)
        {
            Logger.traceERROR(e);
        }
    }

    public static Construction getConstruction(String ref, int level)
    {
        for (Construction construction : allConstructionsList.listAllConstructions())
        {
            if (construction.getRef().equals(ref) && construction.getLevel().intValue() == level)
            {
                return construction;
            }
        }

        throw new RuntimeException("Invalid parameters");
    }

    public static Construction getConstruction(Node node)
    {
        for (Construction construction : allConstructionsList.listAllConstructions())
        {
            if (construction.getDependencyNode().equals(node))
            {
                return construction;
            }
        }

        throw new RuntimeException("Invalid parameters");
    }

}
