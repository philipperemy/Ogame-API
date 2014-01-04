package junit;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import construction.Construction;
import construction.ConstructionsList;
import construction.NamingFactory;

public class TestConnectionList
{
    @Test
    public void testConnectionList1()
    {
        ConstructionsList constructionsList = new ConstructionsList("1");
        Assert.assertNull(constructionsList.shipyardStruct.getLevel());

        List<Construction> constructions = constructionsList.listAllConstructions();
        // 19 fields in constructions
        Assert.assertEquals(19, constructions.size());

        constructionsList.update(NamingFactory.Shipyard, 3);
        Assert.assertEquals(3, constructionsList.shipyardStruct.getLevel().intValue());
        Assert.assertEquals(2, constructionsList.shipyardStruct.getPrevious().getLevel().intValue());
        Assert.assertEquals(1, constructionsList.shipyardStruct.getPrevious().getPrevious().getLevel().intValue());
        Assert.assertNull(constructionsList.shipyardStruct.getPrevious().getPrevious().getPrevious());

        constructions = constructionsList.listAllConstructions();
        Assert.assertEquals(21, constructions.size());
    }
}
