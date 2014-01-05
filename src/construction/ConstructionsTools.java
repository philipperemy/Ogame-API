package construction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import logger.Logger;
import planet.Planet;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import connection.ClientFactory;
import connection.RequestResponse;
import construction.dependencytree.Node;
import construction.dependencytree.NodeConstructionConvert;
import construction.dependencytree.RequirementFactory;

public class ConstructionsTools
{
    public static void update(Planet planet)
    {
        retrieveLevels(planet);
    }

    public static RequestResponse sendBuildRequest(Planet planet, Construction construction)
    {
        //XXX: put it back when functional with other planets
        /*if (getRequiredConstructions(planet, construction).size() != 1)
        {
            throw new RuntimeException("Error : Requirements are not met for construction : " + construction);
        }*/

        return sendBuildRequestForRef(planet, construction.getRef());
    }

    public static RequestResponse sendBuildRequestForRef(Planet planet, String ref)
    {
        Logger.traceINFO("Sending build request for : " + ref + " for planet : " + planet.getPlanetId());
        return ClientFactory.get().sendBuildRequest(planet, ref);
    }


    public static Set<Construction> getRequiredConstructions(Planet planet, Construction target)
    {
        // Preserve the insertion order!
        Set<Construction> requiredConstructions = new LinkedHashSet<>();
        Set<Node> builtNodes = new HashSet<>();
        List<Construction> constructionsBuilt = planet.getConstructionsBuilt();
        for (Construction constructionBuilt : constructionsBuilt)
        {
            builtNodes.addAll(NodeConstructionConvert.convert(constructionBuilt));
        }

        List<Node> requiredNodes = RequirementFactory.getOrderedRequiredItems(builtNodes, target.getDependencyNode());

        for (Node reqNode : requiredNodes)
        {
            requiredConstructions.add(ConstructionsReferential.getConstruction(reqNode));
        }

        return requiredConstructions;
    }

    public static void retrieveLevels(Planet planet)
    {
        Logger.traceINFO("Retrieving constructionLevels for planet : " + planet);
        retrieveLevelsFromResourcesBuildings(planet, ClientFactory.get().getResourcesPage(planet.getPlanetId()));
    }

    private static void retrieveLevelsFromResourcesBuildings(Planet planet, HtmlPage resourcesPage)
    {
        String resourcesPageAsXml = resourcesPage.asXml();
        // 12 resource buildings
        for (int i = 0; i < 12; i++)
        {
            List<Object> nextRefAndLevelList = getNextRefAndLevel("<div class=\"buildingimg\">", resourcesPageAsXml, i);
            String currentRef = (String) nextRefAndLevelList.get(0);
            String constructionName = ConstructionRefManager.getNameByRef(currentRef);
            int level = (Integer) nextRefAndLevelList.get(1);
            if (!currentRef.equals(ConstructionRefManager.SOLAR_SATELLITE_REF))
            {
                planet.setConstructionLevel(constructionName, level);
            }
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

        String tmpTag = "textlabel";
        String endTag = "div";
        tmpContent = tmpContent.substring(tmpContent.indexOf(tmpTag) + tmpTag.length());
        int level = extractInt(tmpContent.substring(0, tmpContent.indexOf(endTag)));

        List<Object> result = new ArrayList<>();
        result.add(ref);
        result.add(level);
        return result;
    }

    public static int extractInt(String str)
    {
        Matcher matcher = Pattern.compile("-{0,1}\\d+\\.{0,1}\\d{0,}").matcher(str);
        if (!matcher.find())
        {
            throw new NumberFormatException("For input string [" + str + "]");
        }

        String matchStr = matcher.group();
        matchStr = matchStr.replaceAll("\\.", "");
        return Integer.parseInt(matchStr);
    }

}
