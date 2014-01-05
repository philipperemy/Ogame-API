package resource;

import java.math.BigInteger;
import logger.Logger;
import resource.ResourcesList.Crystal;
import resource.ResourcesList.Deuterium;
import resource.ResourcesList.Energy;
import resource.ResourcesList.Metal;
import resource.ResourcesList.RawResource;
import resource.ResourcesList.Resource;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import connection.ClientFactory;
import construction.ConstructionsTools;

public class ResourcesTools
{

    final static String AVAILABLE_TAG          = "Available:";
    final static String STORAGE_CAPACITY_TAG   = "Storage capacity:";
    final static String CURRENT_PRODUCTION_TAG = "Current production:";
    final static String DEN_CAPACITY_TAG       = "Den Capacity:";
    final static String CONSUMPTION_TAG        = "Consumption:";

    public static void update()
    {
        parse(ClientFactory.get().getFrontPage());
    }

    private static void parse(HtmlPage htmlPage)
    {
        String xmlContent = htmlPage.asXml();

        push(xmlContent, ResourcesList.getMetal());
        push(xmlContent, ResourcesList.getCrystal());
        push(xmlContent, ResourcesList.getDeuterium());
        push(xmlContent, ResourcesList.getEnergy());
        Logger.traceINFO(ResourcesList.getMetal().toString());
        Logger.traceINFO(ResourcesList.getCrystal().toString());
        Logger.traceINFO(ResourcesList.getDeuterium().toString());
        Logger.traceINFO(ResourcesList.getEnergy().toString());
        Logger.traceINFO("-");
    }

    private static void push(String content, Resource resource)
    {
        content = content.substring(content.indexOf("initAjaxResourcebox") + "initAjaxResourcebox".length());
        if (resource instanceof RawResource)
        {
            if (resource instanceof Metal)
            {
                parse(content, (RawResource) resource, "Metal|<table class=\\\"resourceTooltip\\\">");
            }
            else if (resource instanceof Crystal)
            {
                parse(content, (RawResource) resource, "Crystal|<table class=\\\"resourceTooltip\\\">");
            }
            else if (resource instanceof Deuterium)
            {
                parse(content, (RawResource) resource, "Deuterium|<table class=\\\"resourceTooltip\\\">");
            }
        }
        else if (resource instanceof Energy)
        {
            parse(content, (Energy) resource, "Energy|<table class=\\\"resourceTooltip\\\">");
        }
    }

    private static void parse(String content, Energy resource, String startTag)
    {
        String contentTmp = content.substring(content.indexOf(startTag) + startTag.length());
        int available = ConstructionsTools.extractInt(contentTmp);

        String availableEnd = String.valueOf(CURRENT_PRODUCTION_TAG);
        contentTmp = contentTmp.substring(contentTmp.indexOf(availableEnd) + availableEnd.length());

        int currentProduction = ConstructionsTools.extractInt(contentTmp);
        String currentProductionEnd = String.valueOf(CONSUMPTION_TAG);

        contentTmp = contentTmp.substring(contentTmp.indexOf(currentProductionEnd) + currentProductionEnd.length());

        int consumption = ConstructionsTools.extractInt(contentTmp);
        
        resource.setAvailable(new BigInteger(String.valueOf(available)));
        resource.setCurrentProduction(new BigInteger(String.valueOf(currentProduction)));
        resource.setConsumption(new BigInteger(String.valueOf(consumption)));

    }

    private static void parse(String content, RawResource resource, String startTag)
    {
        String contentTmp = content.substring(content.indexOf(startTag) + startTag.length());
        int available = ConstructionsTools.extractInt(contentTmp);

        String availableEnd = String.valueOf(STORAGE_CAPACITY_TAG);
        contentTmp = contentTmp.substring(contentTmp.indexOf(availableEnd) + availableEnd.length());

        int storageCapacity = ConstructionsTools.extractInt(contentTmp);
        String storageCapacityEnd = String.valueOf(CURRENT_PRODUCTION_TAG);

        contentTmp = contentTmp.substring(contentTmp.indexOf(storageCapacityEnd) + storageCapacityEnd.length());

        int currentProduction = ConstructionsTools.extractInt(contentTmp);
        String currentProductionEnd = String.valueOf(DEN_CAPACITY_TAG);

        contentTmp = contentTmp.substring(contentTmp.indexOf(currentProductionEnd) + currentProductionEnd.length());

        int denCapacity = ConstructionsTools.extractInt(contentTmp);
        
        resource.setAvailable(new BigInteger(String.valueOf(available)));
        resource.setStorageCapacity(new BigInteger(String.valueOf(storageCapacity)));
        resource.setCurrentProduction(new BigInteger(String.valueOf(currentProduction)));
        resource.setDenCapacity(new BigInteger(String.valueOf(denCapacity)));
    }

}
