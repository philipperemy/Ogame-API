package main;

import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import planet.Planet;
import planet.PlanetTools;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import connection.ClientFactory;
import construction.ConstructionsThread;
import construction.resourcebuilding.mine.CrystalMine;
import construction.resourcebuilding.mine.DeuteriumSynthesizer;
import construction.resourcebuilding.mine.MetalMine;
import construction.resourcebuilding.producer.SolarPlant;

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
        ClientFactory.init(121, "<USER>", "<PASS>");

        PlanetTools.update();
        
        Planet planet1 = new Planet();
        planet1.setPlanetId("33701800");
        
        ConstructionsThread constructionsThread = new ConstructionsThread(planet1, 10000);
        for (int i = 0; i < 5; i++)
        {
            constructionsThread.pendingConstructions.add(new DeuteriumSynthesizer());
            constructionsThread.pendingConstructions.add(new MetalMine());
            constructionsThread.pendingConstructions.add(new SolarPlant());
            constructionsThread.pendingConstructions.add(new CrystalMine());
        }

        constructionsThread.start();
        
        /*
         * ConstructionsTools.update();
         * Construction shipyard10 = new Shipyard();
         * shipyard10.setLevel(10);
         * for (Construction construction : ConstructionsTools.getRequiredConstructions(PlanetList.planet1, shipyard10))
         * {
         * System.out.println(construction);
         * }
         */
        /*
         * PlanetList.planet1.setConstructionLevel(NamingFactory.Shipyard, 5);
         * Construction shipyard10 = new Shipyard();
         * shipyard10.setLevel(10);
         * for (Construction construction : ConstructionsTools.getRequiredConstructions(PlanetList.planet1, shipyard10))
         * {
         * System.out.println(construction);
         * }
         */

        // new ConstructionsThread(10000).start();
        // new ResourcesThread(10000).start();

        // Test.test();
    }
}
