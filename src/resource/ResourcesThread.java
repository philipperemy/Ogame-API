package resource;

import logger.Logger;

public class ResourcesThread
{
    private static final int DEFAULT_POLLING_INTERVAL = 10000;
    private int              pollingInterval          = DEFAULT_POLLING_INTERVAL;
    private boolean          condition                = true;
    private Thread           thread                   = new Thread(new ResourcesTask());

    public ResourcesThread()
    {

    }

    public ResourcesThread(int pollingInterval)
    {
        this.pollingInterval = pollingInterval;
    }

    private class ResourcesTask implements Runnable
    {

        @Override
        public void run()
        {
            while (condition)
            {
                try
                {
                    ResourcesTools.update();
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

}
