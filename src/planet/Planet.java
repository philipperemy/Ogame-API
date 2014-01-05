package planet;

import java.util.ArrayList;
import java.util.List;
import resource.Crystal;
import resource.Deuterium;
import resource.Energy;
import resource.Metal;
import resource.ResourcesList;
import logger.Logger;
import construction.Construction;
import construction.ConstructionsList;

public class Planet
{
    //init with setPlanetId()
    private ConstructionsList constructionsList;
    private ResourcesList     resourcesList = new ResourcesList();
    private String            planetId;

    public Planet()
    {

    }

    public Planet(String planetId)
    {
        // Init construction list as well
        this.setPlanetId(planetId);
    }

    public void setConstructionLevel(String constructionName, int level)
    {
        constructionsList.update(constructionName, level);
        Logger.traceINFO("Updated " + constructionName + ", level 0 -> " + level + " for planet " + getPlanetId());
    }

    public ConstructionsList getConstructions()
    {
        return constructionsList;
    }

    @Override
    public String toString()
    {
        return getPlanetId();
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

    public String getPlanetId()
    {
        return planetId;
    }

    public void setPlanetId(String planetId)
    {
        this.planetId = planetId;
        this.constructionsList = new ConstructionsList(planetId);
    }

    public Metal getMetal()
    {
        return resourcesList.getMetal();
    }

    public Crystal getCrystal()
    {
        return resourcesList.getCrystal();
    }

    public Deuterium getDeuterium()
    {
        return resourcesList.getDeuterium();
    }

    public Energy getEnergy()
    {
        return resourcesList.getEnergy();
    }

}
