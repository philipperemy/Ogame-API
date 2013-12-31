package construction.dependencytree;

import java.util.ArrayList;
import java.util.List;

public class Node
{
    @Override
    public String toString()
    {
        return data;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (built ? 1231 : 1237);
        result = prime * result + ((childs == null) ? 0 : childs.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        return result;
    }

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
        if (built != other.built)
            return false;
        if (childs == null)
        {
            if (other.childs != null)
                return false;
        }
        else if (!childs.equals(other.childs))
            return false;
        if (data == null)
        {
            if (other.data != null)
                return false;
        }
        else if (!data.equals(other.data))
            return false;
        return true;
    }

    public String     data;
    public List<Node> childs  = new ArrayList<Node>();
    public boolean    built   = false;

    public Node(String data)
    {
        this.data = data;
    }

    public Node(String data, boolean built)
    {
        this(data);
        this.built = built;
    }

    public void addChild(Node child)
    {
        childs.add(child);
    }
}
