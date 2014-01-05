package connection;

public class LinkFactory
{
    private static String URL_PREFIX;
    private static String LOGIN_URL;

    public LinkFactory(String language, int serverId)
    {
        if (language.length() != 2)
        {
            throw new RuntimeException("Language length must be 2 characters. Example is : en, fr...");
        }

        URL_PREFIX = "http://s" + serverId + "-" + language + ".ogame.gameforge.com/game/index.php";
        LOGIN_URL = "http://" + language + ".ogame.gameforge.com/";
    }

    public String getFrontPageLink()
    {
        return URL_PREFIX;
    }
    
    public String getFrontPageLink(String planetId)
    {
        return URL_PREFIX + "?cp=" + planetId;
    }
    
    public String changeCurrentPlanet(String nextPlanetId)
    {
        return getFrontPageLink(nextPlanetId);
    }

    public String getLoginPageLink()
    {
        return LOGIN_URL;
    }

    public String getPageLink(String pageName)
    {
        return getFrontPageLink() + "?page=" + pageName;
    }

    public String getResourcesPageLink()
    {
        return getPageLink("resources");
    }

    public String getFacilitiesPageLink()
    {
        return getPageLink("station");
    }

    public String getResearchPageLink()
    {
        return getPageLink("research");
    }

    public String getShipyardPageLink()
    {
        return getPageLink("shipyard");
    }

    public String getDefensePageLink()
    {
        return getPageLink("defense");
    }

    public String getFleetPageLink(String planetId)
    {
        return getPageLink("fleet") + planetId;
    }

    public String getGalaxyPageLink()
    {
        return getPageLink("galaxy");
    }

    public String getAlliancePageLink()
    {
        return getPageLink("alliance");
    }
}
