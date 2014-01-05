package planet;

import logger.Logger;
import connection.ClientFactory;
import construction.ConstructionsTools;

public class PlanetTools
{

    public static void update()
    {
        updatePlanetsId();
    }

    private static void updatePlanetsId()
    {
        String content = ClientFactory.get().getResourcesPage().asXml();
        String PLANET_ID_PATTERN = "<div class=\"smallplanet\" id=\"planet-";
        int planetCount = 0;
        while (content.contains(PLANET_ID_PATTERN))
        {
            content = content.substring(content.indexOf(PLANET_ID_PATTERN) + PLANET_ID_PATTERN.length());
            int planetId = ConstructionsTools.extractInt(content);
            PlanetList.getPlanetById(planetCount++).setPlanetId(String.valueOf(planetId));
            Logger.traceINFO("Init planet with id : " + planetId);
        }
    }
}
