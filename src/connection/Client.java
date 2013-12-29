package connection;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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

    private volatile static WebClient webClient = getOgameClient();

    public static synchronized WebClient get()
    {
        return webClient;
    }
    
    private static synchronized HtmlPage getGenericPage(String pageName)
    {
        try
        {
            return webClient.getPage(pageName);
        }
        catch (Exception e)
        {
            Logger.traceERROR(e);
            throw new RuntimeException(e);
        }
    }
    
    private static synchronized HtmlPage getGenericPage(WebRequest request)
    {
        try
        {
            return webClient.getPage(request);
        }
        catch (Exception e)
        {
            Logger.traceERROR(e);
            throw new RuntimeException(e);
        }
    }

    public static synchronized HtmlPage getResourcesPage()
    {
        return getGenericPage("http://s121-en.ogame.gameforge.com/game/index.php?page=resources");
    }

    public static synchronized HtmlPage getFrontPage()
    {
        return getGenericPage("http://s121-en.ogame.gameforge.com/game/index.php");
    }

    public static synchronized HtmlPage getFacilitiesPage()
    {
        return getGenericPage("http://s121-en.ogame.gameforge.com/game/index.php?page=station");
    }
    
    public static synchronized HtmlPage getHiddenInfo(String pageName, String ref) throws MalformedURLException
    {
        WebRequest request = new WebRequest(new URL("http://s121-en.ogame.gameforge.com/game/index.php?page=" +pageName + "&ajax=1"), HttpMethod.POST);
        request.setRequestParameters(new ArrayList<NameValuePair>());
        request.getRequestParameters().add(new NameValuePair("type", ref));
        return getGenericPage(request);
    }
    
    private static WebClient getOgameClient()
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

            final HtmlPage homePage = client.getPage("http://en.ogame.gameforge.com/");

            String htmlStr = homePage.asText();

            if (!htmlStr.contains("Logout"))
            {
                System.out.print("Submitting... ");
                final HtmlForm form = homePage.getFormByName("loginForm");

                final HtmlSelect universSelect = form.getSelectByName("uni");
                final HtmlOption universName = universSelect.getOptionByText("Ursa");
                universSelect.setSelectedAttribute(universName, true);

                final HtmlTextInput identifier = form.getInputByName("login");
                final HtmlPasswordInput password = form.getInputByName("pass");
                final HtmlSubmitInput submit = (HtmlSubmitInput) homePage.getElementById("loginSubmit");

                identifier.setValueAttribute("xfear238");
                password.setValueAttribute("2296NABLT");

                final HtmlPage page2 = submit.click();
                htmlStr = page2.asText();
                System.out.println("Logging successful");
            }
            else
            {
                System.out.println("Already logged... Resuming");
            }

            if (htmlStr.contains("Log out"))
            {
            }
            else
            {
                System.out.println("Still not OK");
                System.exit(0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(0);
        }

        return client;
    }

}
