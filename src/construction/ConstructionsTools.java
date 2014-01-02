package construction;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import planet.Planet;
import planet.PlanetList;
import logger.Logger;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import connection.ClientFactory;
import connection.RequestResponse;

public class ConstructionsTools
{
    public static void update()
    {
        retrieveLevels(PlanetList.planet1);
    }

    public static RequestResponse sendBuildRequest(Construction construction)
    {
        Logger.traceINFO("Sending build request for : " + construction);
        return ClientFactory.get().sendBuildRequest(construction.getRef());
    }

    public static void retrieveLevels(Planet planet)
    {
        Logger.traceINFO("Retrieving constructionLevels for planet : " + planet);
        retrieveLevelsFromResourcesBuildings(planet, ClientFactory.get().getResourcesPage());
    }

    private static void retrieveLevelsFromResourcesBuildings(Planet planet, HtmlPage resourcesPage)
    {
        String resourcesPageAsXml = resourcesPage.asXml();
        // 12 resource buildings
        for (int i = 0; i < 12; i++)
        {
            List<Object> nextRefAndLevelList = getNextRefAndLevel("<div class=\"buildingimg\">", resourcesPageAsXml, i);
            String currentRef = (String) nextRefAndLevelList.get(0);
            Construction currentConstruction = planet.getConstructionsList().getConstruction(currentRef);
            currentConstruction.setLevel((Integer) nextRefAndLevelList.get(1));
            Logger.traceINFO("Updated : " + currentConstruction.toString());
        }

    }

    // ref : .get(0)
    // level : .get(1)
    private static List<Object> getNextRefAndLevel(String sectionPrefix, String content, int id)
    {
        String tmpContent = content.substring(content.indexOf(sectionPrefix) + sectionPrefix.length());

        for (int i = 0; i < id; i++)
        {
            tmpContent = tmpContent.substring(tmpContent.indexOf(sectionPrefix) + sectionPrefix.length());
        }

        String refStartTag = " ref=\"";
        tmpContent = tmpContent.substring(tmpContent.indexOf(refStartTag) + refStartTag.length());
        String ref = tmpContent.substring(0, tmpContent.indexOf("\""));
        
        String tmpTag = "void(0);";
        String endTag = "div";
        while(tmpContent.indexOf(tmpTag) < tmpContent.indexOf(endTag))
        {
            tmpContent = tmpContent.substring(tmpContent.indexOf(tmpTag) + tmpTag.length()); // ref javascript.void(0)            
        }
        
        tmpContent = tmpContent.substring(ref.length());
        tmpContent = tmpContent.substring(tmpContent.indexOf(">"));
        int level = extractInt(tmpContent.substring(0, tmpContent.indexOf(endTag)));

        List<Object> result = new ArrayList<>();
        result.add(ref);
        result.add(level);
        return result;
    }

    private static int extractInt(String str)
    {
        Matcher matcher = Pattern.compile("\\d+").matcher(str);
        if (!matcher.find())
        {
            throw new NumberFormatException("For input string [" + str + "]");
        }
        return Integer.parseInt(matcher.group());
    }

}
