package construction.dependencytree;

import java.util.ArrayList;
import java.util.List;
import construction.Construction;

public class NodeConstructionConvert
{
    public static List<Node> convert(Construction construction)
    {
        List<Node> nodes = new ArrayList<>();
        Node rootConstructionNode = construction.getDependencyNode();
        nodes.add(rootConstructionNode);

        String nodeRootName = rootConstructionNode.getName();
        Integer nodeRootLevel = construction.getLevel();

        if (nodeRootLevel != null)
        {
            for (int i = nodeRootLevel.intValue() - 1; i > 0; i--)
            {
                nodes.add(new Node(nodeRootName, i));
            }
        }

        return nodes;
    }
}
