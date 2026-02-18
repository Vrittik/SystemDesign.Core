package systemDesign.Core.ChainOfResponsibility;

public class ChainOfResponsibilityDemo {

	public static void main(String[] args)
	{
		ErrorLogger errorLogger = new ErrorLogger(null);
		DebugLogger debugLogger = new DebugLogger(errorLogger);
		InfoLogger infoLogger = new InfoLogger(debugLogger);

		infoLogger.logMessage(Logger.ERROR, "This is an error message");
		System.out.println();
		infoLogger.logMessage(Logger.DEBUG, "This is a debug message");
		System.out.println();
		infoLogger.logMessage(Logger.INFO, "This is an INFO message");
	}
}
