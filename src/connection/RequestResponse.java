package connection;

public class RequestResponse
{
    public static final RequestResponse UNKNOWN_ERROR        = new RequestResponse("UNKNOWN_ERROR", 0);
    public static final RequestResponse REQUIREMENTS_NOT_MET = new RequestResponse("REQUIREMENTS_NOT_MET", 1);
    public static final RequestResponse QUEUE_IS_FULL        = new RequestResponse("QUEUE_IS_FULL", 2);
    public static final RequestResponse REQUEST_SENT         = new RequestResponse("REQUEST_SENT", 3);
    public static final RequestResponse ALREADY_SENT         = new RequestResponse("ALREADY_SENT", 4);
    public static final RequestResponse NOT_ENOUGH_RESOURCES = new RequestResponse("NOT_ENOUGH_RESOURCES", 5);

    private String                      message;
    private int                         code;
    private String                      remaining;

    @Override
    public String toString()
    {
        return "RequestResponse [" + (message != null ? "Message=" + message + ", " : "") + "Code=" + code + (remaining != null ? ", remaining=" + remaining : "") + "]";
    }

    public RequestResponse(String errorMessage, int errorCode)
    {
        this.message = errorMessage;
        this.code = errorCode;
    }

    public void linkDuration(String remaining)
    {
        this.remaining = remaining;
    }

}
