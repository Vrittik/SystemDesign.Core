package systemDesign.Core.ChangeOfResponsibility;

public class Logger {

	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	private Logger nextLogger;
	
	public Logger(Logger nextLogger)
	{
		this.nextLogger = nextLogger;
	}
	
	public void logMessage(int logLevel, String message)
	{
		if(this.nextLogger != null)
		{
			nextLogger.logMessage(logLevel, message);
		}
	}
}
