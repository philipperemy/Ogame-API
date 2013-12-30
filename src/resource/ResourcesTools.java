package resource;

import java.math.BigInteger;
import logger.Logger;
import resource.ResourcesList.Energy;
import resource.ResourcesList.RawResource;
import resource.ResourcesList.Resource;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import connection.ClientFactory;

public class ResourcesTools
{

    public static void update()
    {
        parse(ClientFactory.get().getFrontPage());
    }

    private static void parse(HtmlPage htmlPage)
    {
        String xmlContent = htmlPage.asXml();

        push(xmlContent, ResourcesList.getMetal(), 0);
        push(xmlContent, ResourcesList.getCrystal(), 1);
        push(xmlContent, ResourcesList.getDeuterium(), 2);
        push(xmlContent, ResourcesList.getEnergy(), 3);
        Logger.traceINFO("-");
    }

    private static void push(String content, Resource resource, int techId)
    {
        try
        {
            BigInteger available = BigInteger.ZERO;

            if (resource instanceof RawResource)
            {
                available = parseResource(content, "Available", "<span class=\\\"\\\">", "<\\/span>", techId);
            }
            else if (resource instanceof Energy)
            {
                available = parseResource(content, "Available", "<span class=\\\"overmark\\\">", "<\\/span>", techId);
            }
            else
            {
                throw new RuntimeException("Unknown resource");
            }

            resource.setAvailable(available);

            BigInteger currentProduction = parseResource(content, "Current production", "<span class=\\\"undermark\\\">", "<\\/span>", techId);
            resource.setCurrentProduction(currentProduction);

            if (resource instanceof RawResource)
            {
                BigInteger storageCapacity = parseResource(content, "Storage capacity", "<span class=\\\"\\\">", "<\\/span>", techId);
                ((RawResource) resource).setStorageCapacity(storageCapacity);

                BigInteger denCapacity = parseResource(content, "Den Capacity", "<span class=\\\"overermark\\\">", "<\\/span>", techId);
                ((RawResource) resource).setDenCapacity(denCapacity);
            }
            else if (resource instanceof Energy)
            {
                BigInteger consumption = parseResource(content, "Consumption", "<span class=\\\"overmark\\\">", "<\\/span>", 0);
                ((Energy) resource).setConsumption(consumption);
            }
            else
            {
                throw new RuntimeException("Unknown resource");
            }

            Logger.traceINFO(resource.toString());
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private static BigInteger parseResource(String content, String matchingStrStart, String matchingStrEnd)
    {
        int availableStartIndex = content.indexOf(matchingStrStart);

        if (availableStartIndex == -1 && matchingStrStart.contains("undermark"))
        {
            matchingStrStart = matchingStrStart.replaceAll("undermark", "overmark");
            availableStartIndex = content.indexOf(matchingStrStart);
        }
        else if (availableStartIndex == -1 && matchingStrStart.contains("overmark"))
        {
            matchingStrStart = matchingStrStart.replaceAll("undermark", "undermark");
            availableStartIndex = content.indexOf(matchingStrStart);
        }

        availableStartIndex += matchingStrStart.length();
        int availableEndIndex = content.substring(availableStartIndex).indexOf(matchingStrEnd);
        availableEndIndex += availableStartIndex;
        String metalAvailableStr = content.substring(availableStartIndex, availableEndIndex);
        metalAvailableStr = metalAvailableStr.replace(".", "");
        return new BigInteger(metalAvailableStr.trim());
    }

    private static BigInteger parseResource(String content, String matchingStrStart, String matchingStrStart2, String matchingStrEnd)
    {
        int cutStart = content.indexOf(matchingStrStart);
        String contentTmp = content.substring(cutStart);
        return parseResource(contentTmp, matchingStrStart2, matchingStrEnd);
    }

    private static BigInteger parseResource(String content, String matchingStrStart, String matchingStrStart2, String matchingStrEnd, int startCount)
    {
        String contentTmp = content;
        for (int i = 0; i < startCount; i++)
        {
            int cutStart = contentTmp.indexOf(matchingStrStart);
            cutStart += matchingStrStart.length();
            contentTmp = contentTmp.substring(cutStart);
        }
        return parseResource(contentTmp, matchingStrStart, matchingStrStart2, matchingStrEnd);
    }
}
