package main;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import resource.Test;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class Main
{
    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException
    {
        /**
         * <a class="fastBuild tooltip js_hideTipOnMobile" title="" href="javascript:void(0);"
         * onclick="sendBuildRequest('http://s121-en.ogame.gameforge.com/game/index.php?page=resources&amp;modus=1&amp;type=2&amp;menge=1&amp;token=e932145db18429fba34c70fa300ccd42', null, 1);">
         * <img src="http://gf2.geo.gfsrv.net/cdndf/3e567d6f16d040326c7a0ea29a4f41.gif" width="22" height="14">
         * </a>
         */
        /**
         * http://s121-en.ogame.gameforge.com/game/index.php?page=resources&modus=1&type=4&menge=1&token=d3c9d81ce171c86493ca1ac616b00377
         */
        System.setErr(new PrintStream("hello"));
        // Test.test();
        // new ResourcesThread(10000).start();

        Test.test();
    }
}
