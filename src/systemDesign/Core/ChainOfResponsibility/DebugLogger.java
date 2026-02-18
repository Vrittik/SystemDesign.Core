package systemDesign.Core.ChainOfResponsibility;

public class DebugLogger extends Logger {
	
	public DebugLogger(Logger nextLogger)
	{
		super(nextLogger); // invoke parameterized constructor of parent class
	}
	
	public void logMessage(int logLevel, String message)
	{
		if(logLevel == DEBUG)
		{
			System.out.println("Log level Debug = " + logLevel + " Message = " + message);
		}
		else
		{
			super.logMessage(logLevel, message);
		}
	}
}
