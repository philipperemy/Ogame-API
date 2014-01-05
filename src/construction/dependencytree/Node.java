package construction.dependencytree;

import java.util.ArrayList;
import java.util.List;

public class Node
{
    // Only level and name
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    // Only level and name
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (level == null)
        {
            if (other.level != null)
                return false;
        }
        else if (!level.equals(other.level))
            return false;
        if (name == null)
        {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return getData();
    }

    public String getData()
    {
        String data = name;
        if (level != null)
        {
            data += level;
        }
        return data;
    }

    public String     name;
    public Integer    level  = null;

    public List<Node> childs = new ArrayList<Node>();

    public boolean    built  = false;

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
