package connection;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import logger.Logger;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

public class Client
{
    private WebClient   webClient;
    private LinkFactory linkFactory;

    public Client(String language, int serverId, String username, String password)
    {
        linkFactory = new LinkFactory(language, serverId);
        webClient = getOgameClient(username, password);
    }

    private synchronized HtmlPage getGenericPage(String pageName)
    {
        try
        {
            return webClient.getPage(pageName);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private synchronized HtmlPage getGenericPage(WebRequest request)
    {
        try
        {
            return webClient.getPage(request);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public synchronized HtmlPage getResourcesPage()
    {
        return getGenericPage(linkFactory.getResourcesPageLink());
    }

    /*
     * private String getToken()
     * {
     * HtmlPage resourcesPage = getResourcesPage();
     * String resourcesPageAsXml = resourcesPage.asXml();
     * final String TOKEN_STR = "name=\"token\" value=\"";
     * if (resourcesPageAsXml.contains(TOKEN_STR))
     * {
     * int tokenBegIdx = resourcesPageAsXml.indexOf(TOKEN_STR);
     * tokenBegIdx += TOKEN_STR.length();
     * String afterToken = resourcesPageAsXml.substring(tokenBegIdx);
     * int tokenEndIdx = afterToken.indexOf('\"');
     * String token = afterToken.substring(0, tokenEndIdx);
     * if (token.length() != 32)
     * {
     * throw new RuntimeException("Invalid token");
     * }
     * Logger.traceINFO("Found token : " + token);
     * return token;
     * }
     * throw new RuntimeException("Cannot find token");
     * }
     */

    public synchronized HtmlPage getFrontPage()
    {
        String frontPage = linkFactory.getFrontPageLink();
        return getGenericPage(frontPage);
    }

    public synchronized HtmlPage getFacilitiesPage()
    {
        return getGenericPage(linkFactory.getFacilitiesPageLink());
    }

    public synchronized HtmlPage getHiddenInfo(String pageName, String ref) throws MalformedURLException
    {
        WebRequest request = new WebRequest(new URL("http://s121-en.ogame.gameforge.com/game/index.php?page=" + pageName + "&ajax=1"), HttpMethod.POST);
        request.setRequestParameters(new ArrayList<NameValuePair>());
        request.getRequestParameters().add(new NameValuePair("type", ref));
        return getGenericPage(request);
    }

    public synchronized void sendBuildRequestSupply4()
    {
        HtmlPage resourcesPage = getResourcesPage();
        String resourcesPageAsXml = resourcesPage.asXml();
        final String SUPPLY_4 = "supply4";
        if (resourcesPageAsXml.contains(SUPPLY_4))
        {
            String newStr = resourcesPageAsXml.substring(resourcesPageAsXml.indexOf(SUPPLY_4));
            int beg = newStr.indexOf("sendBuildRequest('") + "sendBuildRequest('".length();

            String newStr2 = newStr.substring(beg);
            int end = newStr2.indexOf("',");

            String httpRequestGet = newStr2.substring(0, end);
            httpRequestGet = httpRequestGet.replaceAll("&amp;", "&");
            Logger.traceINFO(httpRequestGet);
            HtmlPage lol = getGenericPage(httpRequestGet);
            if (lol.asXml().contains("7m"))
            {
                Logger.traceINFO("done");
            }
        }
    }

    public synchronized RequestResponse sendBuildRequest(String ref)
    {
        HtmlPage resourcesPage = getResourcesPage();
        String webPage = resourcesPage.asXml();

        final String supplyPattern = "supply" + ref;
        final String sendBuildRequestPattern = "sendBuildRequest('";
        final String queueIsFullPattern = "Queue is full";
        final String requirementsNotMetPattern = "Requirements are not met";
        final String timePattern = "zeit";
        final String notEnoughResourcesPattern = "Not enough resources";

        if (webPage.contains(supplyPattern))
        {
            String truncPage = webPage.substring(webPage.indexOf(supplyPattern) + supplyPattern.length());

            int nextSupplyTagIdx = truncPage.indexOf("\"supply");

            if (nextSupplyTagIdx != -1)
            {
                truncPage = truncPage.substring(0, nextSupplyTagIdx);
            }

            if (!truncPage.contains(sendBuildRequestPattern))
            {
                if (truncPage.contains(queueIsFullPattern))
                {
                    return RequestResponse.QUEUE_IS_FULL;
                }
                else if (truncPage.contains(requirementsNotMetPattern))
                {
                    return RequestResponse.REQUIREMENTS_NOT_MET;
                }
                else if (truncPage.contains(timePattern))
                {
                    Pattern waitTimeHour = Pattern.compile("[0-9]+h [0-9]+m [0-9]+s");
                    Matcher matcherWaitTime = waitTimeHour.matcher(truncPage);
                    RequestResponse requestResponse = RequestResponse.ALREADY_SENT;

                    if (matcherWaitTime.find())
                    {
                        requestResponse.linkDuration(matcherWaitTime.group());
                    }
                    else
                    {
                        Pattern waitTimeMin = Pattern.compile("[0-9]+m [0-9]+s");
                        Matcher matcherWaitTimeMin = waitTimeMin.matcher(truncPage);
                        if (matcherWaitTimeMin.find())
                        {
                            requestResponse.linkDuration(matcherWaitTimeMin.group());
                        }
                        else
                        {
                            Pattern waitTimeSec = Pattern.compile("[0-9]+s");
                            Matcher matcherWaitTimeSec = waitTimeSec.matcher(truncPage);
                            if (matcherWaitTimeSec.find())
                            {
                                requestResponse.linkDuration(matcherWaitTimeSec.group());
                            }
                        }
                    }

                    return requestResponse;
                }
                else if (truncPage.contains(notEnoughResourcesPattern))
                {
                    return RequestResponse.NOT_ENOUGH_RESOURCES;
                }
            }
            else
            {
                int begIdx = truncPage.indexOf(sendBuildRequestPattern) + sendBuildRequestPattern.length();
                String truncPage2 = truncPage.substring(begIdx);
                int endIdx = truncPage2.indexOf("',");

                String httpRequestGet = truncPage2.substring(0, endIdx);
                httpRequestGet = httpRequestGet.replaceAll("&amp;", "&");
                Logger.traceINFO(httpRequestGet);

                HtmlPage responsePage = getGenericPage(httpRequestGet);

                Pattern waitTime = Pattern.compile("[0-9]+m [0-9]+s");
                Matcher matcherWaitTime = waitTime.matcher(responsePage.asXml());

                if (matcherWaitTime.find())
                {
                    return RequestResponse.REQUEST_SENT;
                }
            }
        }

        return RequestResponse.UNKNOWN_ERROR;
    }

    /*
     * public synchronized void sendBuildRequestSupply2()
     * {
     * HtmlPage resourcesPage = getResourcesPage();
     * String resourcesPageAsXml = resourcesPage.asXml();
     * final String SUPPLY_2 = "supply2";
     * if (resourcesPageAsXml.contains(SUPPLY_2))
     * {
     * String newStr = resourcesPageAsXml.substring(resourcesPageAsXml.indexOf(SUPPLY_2));
     * int beg = newStr.indexOf("sendBuildRequest('") + "sendBuildRequest('".length();
     * String newStr2 = newStr.substring(beg);
     * int end = newStr2.indexOf("',");
     * String httpRequestGet = newStr2.substring(0, end);
     * httpRequestGet = httpRequestGet.replaceAll("&amp;", "&");
     * Logger.traceINFO(httpRequestGet);
     * HtmlPage lol = getGenericPage(httpRequestGet);
     * Pattern waitTime = Pattern.compile("[0-9]+m [0-9]+s");
     * Matcher matcherWaitTime = waitTime.matcher(lol.asXml());
     * if (matcherWaitTime.find())
     * {
     * Logger.traceINFO("done OKKKKKKKKKK");
     * }
     * }
     * }
     */

    private WebClient getOgameClient(String _username, String _password)
    {
        final WebClient client = new WebClient(BrowserVersion.FIREFOX_17);
        try
        {
            client.getOptions().setJavaScriptEnabled(true);
            client.getOptions().setAppletEnabled(false);
            client.getOptions().setCssEnabled(false);
            client.getOptions().setPrintContentOnFailingStatusCode(true);
            client.getOptions().setPopupBlockerEnabled(true);
            client.getOptions().setThrowExceptionOnScriptError(false);

            final HtmlPage homePage = client.getPage(linkFactory.getLoginPageLink());

            String htmlStr = homePage.asText();

            if (!htmlStr.contains("Logout"))
            {
                Logger.traceINFO("Submitting... ");
                final HtmlForm form = homePage.getFormByName("loginForm");

                final HtmlSelect universSelect = form.getSelectByName("uni");
                final HtmlOption universName = universSelect.getOptionByText("Ursa");
                universSelect.setSelectedAttribute(universName, true);

                final HtmlTextInput identifier = form.getInputByName("login");
                final HtmlPasswordInput password = form.getInputByName("pass");
                final HtmlSubmitInput submit = (HtmlSubmitInput) homePage.getElementById("loginSubmit");

                identifier.setValueAttribute(_username);
                password.setValueAttribute(_password);

                final HtmlPage page2 = submit.click();
                htmlStr = page2.asText();
                Logger.traceINFO("Logging successful.");
            }
            else
            {
                Logger.traceINFO("Already logged... Resuming");
            }

            if (!htmlStr.contains("Log out"))
            {
                Logger.traceINFO("Cannot connect to server");
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            Logger.traceERROR(e);
            throw new RuntimeException(e);
        }

        return client;
    }

}
