package planet;

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

}
