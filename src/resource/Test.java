package resource;

import java.io.IOException;
import connection.ClientFactory;
import connection.RequestResponse;

public class Test
{
    public static void test() throws IOException, InterruptedException
    {
        // http://stackoverflow.com/questions/6432449/problems-with-post-request-in-java

        ClientFactory.init(121, "xfear238", "2296NABLT");

        while (true)
        {
            RequestResponse ResponseCode = ClientFactory.get().sendBuildRequest("1");
            System.out.println(ResponseCode);
            Thread.sleep(10000);
        }

        // ClientFactory.get().sendBuildRequest("2");
        /*
         * HtmlPage htmlPage2 = ClientFactory.get().getHiddenInfo("resources", "2");
         * if (htmlPage2.asXml().contains("Production duration") && htmlPage2.asXml().contains("7m 43s"))
         * {
         * System.out.println("hello");
         * }
         */
    }
}
