package construction.dependencytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeTool
{

    private Set<List<Node>> allPaths       = new HashSet<List<Node>>();
    private Set<List<Node>> efficientPaths = new HashSet<List<Node>>();
    private Set<Node>       requiredNodes  = new HashSet<Node>();

    public Set<Node> getRequirementsBuild(Tree tree, Node node)
    {
        printAllPaths(tree.root, new ArrayList<Node>());
        selectPathsLeaf(node);

        for (List<Node> nodePath : efficientPaths)
        {
            List<Node> nodesNotOk = new ArrayList<Node>();
            boolean isCurrentPathOk = true;
            for (Node currentNode : nodePath)
            {
                if (!currentNode.built)
                {
                    isCurrentPathOk = false;
                    nodesNotOk.add(currentNode);
                }
            }

            if (!isCurrentPathOk)
            {
                requiredNodes.addAll(new ArrayList<Node>(nodesNotOk));
            }
        }

        if (requiredNodes.contains(node))
        {
            requiredNodes.remove(node);
        }

        return requiredNodes;
    }

    public void printAllPaths(Node root, List<Node> list)
    {
        list.add(root);

        if (root.childs.isEmpty())
        {
            allPaths.add(new ArrayList<Node>(list));
            list.remove(root);
            return;
        }

        for (Node child : root.childs)
        {
            printAllPaths(child, list);
        }

        list.remove(root);
    }

    public void selectPathsLeaf(Node leaf)
    {
        for (List<Node> path : allPaths)
        {
            for (int i = 0; i < path.size(); i++)
            {
                Node currentNode = path.get(i);
                if (currentNode.data.equalsIgnoreCase(leaf.data))
                {
                    List<Node> truncNodesList = new ArrayList<Node>();
                    truncNodesList.addAll(path);
                    for (int j = i + 1; j < path.size(); j++)
                    {
                        truncNodesList.remove(truncNodesList.size() - 1);
                    }
                    efficientPaths.add(truncNodesList);
                    break;
                }
            }
        }
    }
}
