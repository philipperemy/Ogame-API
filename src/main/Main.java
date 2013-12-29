package main;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import resource.ResourcesThread;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class Main
{
    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException
    {
        /**
         * http://s121-en.ogame.gameforge.com/game/index.php?page=resources&modus=1&type=4&menge=1&token=d3c9d81ce171c86493ca1ac616b00377
         */
        System.setErr(new PrintStream("hello"));
        // Test.test();
        new ResourcesThread(10000).start();
    }
}
