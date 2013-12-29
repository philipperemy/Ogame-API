package resource;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import connection.Client;

public class Test
{
    public static void test() throws IOException, InterruptedException
    {
        // http://stackoverflow.com/questions/6432449/problems-with-post-request-in-java

        WebRequest request = new WebRequest(new URL("http://s121-en.ogame.gameforge.com/game/index.php?page=resources&ajax=1"), HttpMethod.POST);
        request.setRequestParameters(new ArrayList<NameValuePair>());
        request.getRequestParameters().add(new NameValuePair("type", "2"));

        HtmlPage htmlPage2 = Client.get().getPage(request);
        if (htmlPage2.asXml().contains("Production duration") && htmlPage2.asXml().contains("2m 30s"))
        {
            System.out.println("hello");
        }
    }
}
