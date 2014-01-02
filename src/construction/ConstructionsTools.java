package construction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import planet.Planet;
import planet.PlanetList;
import logger.Logger;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import connection.ClientFactory;
import connection.RequestResponse;
import construction.dependencytree.Node;
import construction.dependencytree.NodeConstructionConvert;
import construction.dependencytree.RequirementFactory;

public class ConstructionsTools
{
    public static void update()
    {
        //TODO: change it
        retrieveLevels(PlanetList.planet1);
    }

    public static RequestResponse sendBuildRequest(Planet planet, Construction construction)
    {
        if(getRequiredConstructions(planet, construction).size() != 1)
        {
            throw new RuntimeException("Error : Requirements are not met for construction : " + construction);
        }
        
        return sendBuildRequestForRef(construction.getRef());
    }
    
    public static RequestResponse sendBuildRequestForRef(String ref)
    {
        Logger.traceINFO("Sending build request for : " + ref);
        return ClientFactory.get().sendBuildRequest(ref);
    }
    
    public static Set<Construction> getRequiredConstructions(Planet planet, Construction target)
    {
        Set<Construction> requiredConstructions = new HashSet<>();
        Set<Node> builtNodes = new HashSet<>();
        for(Construction constructionBuilt : planet.getConstructionsBuilt())
        {
            builtNodes.addAll(NodeConstructionConvert.convert(constructionBuilt));   
        }
        
        List<Node> requiredNodes = RequirementFactory.getOrderedRequiredItems(builtNodes, target.getDependencyNode());
        
        Map<Node, Construction> nodeByRefMap = new HashMap<Node, Construction>();
        for(Construction constructionBuilt : planet.getConstructionsBuilt())
        {
            nodeByRefMap.put(constructionBuilt.getDependencyNode(), constructionBuilt);
        }
        
        for(Node requiredNode : requiredNodes)
        {
            Construction requiredConstruction = nodeByRefMap.get(requiredNode);
            if(requiredConstruction != null)
            {
                requiredConstructions.add(requiredConstruction);
            }
        }
        
        return requiredConstructions;
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
