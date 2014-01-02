package construction.dependencytree;

import java.util.ArrayList;
import java.util.List;

public class Node
{
    @Override
    public String toString()
    {
        return getData();
    }

    public String getData()
    {
        String data = name;
        if(level != null)
        {
            data += level;
        }
        return data;
    }

    public String     name;
    public Integer    level  = null;

    public List<Node> childs = new ArrayList<Node>();

    public boolean    built  = false;
    public boolean    mark   = false;

    public Node(String name)
    {
        this.name = name;
        NodeDictionary.addNode(this);
    }

    public Node(String name, Integer level)
    {
        this(name);
        this.level = level;
    }

    // get rid of built
    public Node(String data, int level, boolean built)
    {
        this(data, level);
        this.built = built;
    }

    public void addChild(Node child)
    {
        childs.add(child);
    }

    public String getName()
    {
        return name;
    }
    
    public Integer getLevel()
    {
        return level;
    }
}
