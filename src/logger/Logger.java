package logger;

import java.util.Date;

public class Logger
{
    private static final String infoKey  = "INFO";
    private static final String errorKey = "ERROR";

    public static void traceINFO(String msg)
    {
        System.out.println(new Date() + " [" + infoKey + "] " + msg);
    }

    public static void traceERROR(Exception e)
    {
        System.out.println(new Date() + " [" + errorKey + "] " + e);
        e.printStackTrace(System.out);
    }
}
