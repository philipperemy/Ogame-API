package construction;

import logger.Logger;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import connection.ClientFactory;
import connection.RequestResponse;

public class ConstructionsTools
{
    public static void update()
    {
        parseResourcesPage(ClientFactory.get().getResourcesPage());
        parseFacilitiesPage(ClientFactory.get().getFacilitiesPage());
    }

    private static void parseFacilitiesPage(HtmlPage facilitiesPage)
    {
    }

    private static void parseResourcesPage(HtmlPage resourcesPage)
    {
    }

    public static RequestResponse sendBuildRequest(Construction construction)
    {
        Logger.traceINFO("Sending build request for : " + construction);
        return ClientFactory.get().sendBuildRequest(construction.getRef());
    }

    public void retrieveLevel(Construction construction)
    {
        //TODO: todo
    }

}
