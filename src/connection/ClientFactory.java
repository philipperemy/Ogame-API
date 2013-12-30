package connection;

public class ClientFactory
{
    private static Client client;

    public static Client get()
    {
        if (client == null)
        {
            throw new RuntimeException("Call to init() must be done prior to call get()");
        }

        return client;
    }

    public static void init(int serverId, String username, String password)
    {
        client = new Client("en", serverId, username, password);
    }
}
