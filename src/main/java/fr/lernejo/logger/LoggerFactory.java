package fr.lernejo.logger;

public class LoggerFactory
{
    public static Logger getLogger(String name)
    {
        ConsoleLogger tmp = new ConsoleLogger();
        return tmp;
    }
}
