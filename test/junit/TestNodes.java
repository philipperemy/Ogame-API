package junit;

import org.junit.Test;
import construction.dependencytree.Node;
import construction.dependencytree.NodeDictionary;
import construction.dependencytree.RequirementFactory;

public class TestNodes
{
    @Test
    public void testNodes()
    {
        Node deathStar = NodeDictionary.DeathStar;
        String actual = RequirementFactory.getOrderedRequiredItems(deathStar).toString();
        // Assert.assertTrue(actual.contains(NamingFactory.R)));
    }
}
