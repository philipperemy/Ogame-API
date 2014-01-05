package construction;

import logger.Logger;
import planet.Planet;
import planet.PlanetList;
import connection.RequestResponse;

public class ConstructionsThread
{
    public ConstructionQueue pendingConstructions     = new ConstructionQueue();

    private static final int DEFAULT_POLLING_INTERVAL = 10000;
    private Planet           planet                   = PlanetList.homeWorld;
    private int              pollingInterval          = DEFAULT_POLLING_INTERVAL;
    private boolean          condition                = true;
    private Thread           thread                   = new Thread(new ConstructionTask());

    public ConstructionsThread()
    {

    }

    public ConstructionsThread(Planet planet)
    {
        this.planet = planet;
    }

    public ConstructionsThread(int pollingInterval)
    {
        this.pollingInterval = pollingInterval;
    }

    public ConstructionsThread(Planet planet, int pollingInterval)
    {
        this.pollingInterval = pollingInterval;
        this.planet = planet;
    }

    private class ConstructionTask implements Runnable
    {

        @Override
        public void run()
        {
            ConstructionsTools.update(planet);

            while (condition)
            {
                Logger.traceINFO("Running...");
                try
                {
                    Construction construction = pendingConstructions.peek();

                    if (construction != null)
                    {
                        RequestResponse response = ConstructionsTools.sendBuildRequest(planet, construction);

                        if (response == RequestResponse.QUEUE_IS_FULL)
                        {
                            Logger.traceINFO("Ogame queue is full. Waiting...");
                        }
                        else if (response == RequestResponse.ALREADY_SENT)
                        {
                            Logger.traceERROR("Request already sent...");
                        }
                        else if (response == RequestResponse.NOT_ENOUGH_RESOURCES)
                        {
                            Logger.traceERROR("Not enough resources. Waiting...");
                        }
                        else if (response == RequestResponse.REQUIREMENTS_NOT_MET)
                        {
                            Logger.traceERROR("The dependencies tree is out of date for construction : " + construction);
                            Logger.traceERROR("Closing the program.");
                            System.exit(-1);
                        }
                        else if (response == RequestResponse.UNKNOWN_ERROR)
                        {
                            Logger.traceERROR("Unknown error.");
                            Logger.traceERROR("Closing the program.");
                            System.exit(-1);
                        }
                        else if (response == RequestResponse.REQUEST_SENT)
                        {
                            Logger.traceINFO("Request successfully executed.");
                            pendingConstructions.poll();
                        }

                    }

                    Thread.sleep(pollingInterval);
                }
                catch (Exception e)
                {
                    Logger.traceERROR(e);
                    System.exit(0);
                }
            }
        }

    }

    public void start()
    {
        thread.start();
    }

    public void stop()
    {
        condition = false;
    }

    public Planet getPlanet()
    {
        return planet;
    }

    public void setPlanet(Planet planet)
    {
        this.planet = planet;
    }
}
