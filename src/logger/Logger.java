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
    
    public static void traceINFO(int level, long[] array)
    {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(level + " : ");
        for (int i = 0; i < array.length; i++)
        {
            if (i == array.length - 1)
            {

                sBuilder.append(array[i]);
            }
            else
            {
                sBuilder.append(array[i] + ", ");
            }
        }
        traceINFO(sBuilder.toString());
    }

    public static void traceINFO(String... msgs)
    {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < msgs.length; i++)
        {
            if (i == msgs.length - 1)
            {

                sBuilder.append(msgs[i]);
            }
            else
            {
                sBuilder.append(msgs[i] + ", ");
            }
        }
        traceINFO(sBuilder.toString());
    }

    public static void traceERROR(Exception e)
    {
        System.out.println(new Date() + " [" + errorKey + "] " + e);
        e.printStackTrace(System.out);
    }
}
