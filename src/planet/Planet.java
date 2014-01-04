package planet;

import java.util.ArrayList;
import java.util.List;
import logger.Logger;
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

    public void setConstructionLevel(String constructionName, int level)
    {
        constructionsList.update(constructionName, level);
        Logger.traceINFO("Updated " + constructionName + ", level 0 -> " + level + " for planet " + planetId);
    }

    public ConstructionsList getConstructions()
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
        for (Construction current : constructionsList.listAllConstructions())
        {
            Integer level = current.getLevel();
            if (level != null && level > 0)
            {
                builtConstructions.add(current);
            }
        }
        return builtConstructions;
    }

}
