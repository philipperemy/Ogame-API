package construction;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import connection.Client;

public class ConstructionsTools
{
    public static void update()
    {
        parseResourcesPage(Client.getResourcesPage());
        parseFacilitiesPage(Client.getFacilitiesPage());
    }

    private static void parseFacilitiesPage(HtmlPage facilitiesPage)
    {
    }

    private static void parseResourcesPage(HtmlPage resourcesPage)
    {
    }
}
