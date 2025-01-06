package systemDesign.Core.ChangeOfResponsibility;

public class ChainOfResponsibilityDemo {

	public static void main(String[] args)
	{
		DebugLogger debugLogger = new DebugLogger(null);
		ErrorLogger errorLogger = new ErrorLogger(debugLogger);
		InfoLogger infoLogger = new InfoLogger(errorLogger);
		
		infoLogger.logMessage(Logger.ERROR, "This is an ERROR message");
		infoLogger.logMessage(Logger.DEBUG, "This is a DEBUG message");
		infoLogger.logMessage(Logger.INFO, "This is an INFO message");
	}
}
