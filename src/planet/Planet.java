package planet;

import java.util.ArrayList;
import java.util.List;
import construction.Construction;
import construction.ConstructionsList;

public class Planet
{
    private ConstructionsList constructionsList;
    private String            planetId;

    public Planet(String planetId)
    {
        this.planetId = planetId;
        constructionsList = new ConstructionsList(planetId);
    }
    
    public ConstructionsList getConstructionsList()
    {
        return constructionsList;
    }

    @Override
    public String toString()
    {
        return planetId;
    }
    
    public List<Construction> getConstructionsBuilt()
    {
        List<Construction> builtConstructions = new ArrayList<>();
        for(Construction current : constructionsList.getConstructions())
        {
            Integer level = current.getLevel();
            if(level != null && level > 0)
            {
                builtConstructions.add(current);
            }
        }
        return builtConstructions;
    }

}
