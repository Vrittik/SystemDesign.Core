package systemDesign.Core.ChainOfResponsibility;

public class Logger {
	public static int DEBUG = 1;
	public static int ERROR = 2;
	public static int INFO = 3;

	private final Logger nextLogger;

	public Logger(Logger _nextLogger)
	{
		nextLogger = _nextLogger;
	}

	public void logMessage(int level, String message)
	{
		if (nextLogger != null)
		{
			nextLogger.logMessage(level, message);
		}
	}
}
