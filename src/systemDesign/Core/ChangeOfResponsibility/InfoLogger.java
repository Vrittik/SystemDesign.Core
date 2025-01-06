package systemDesign.Core.ChangeOfResponsibility;

public class InfoLogger extends Logger {
	
	public InfoLogger(Logger nextLogger)
	{
		super(nextLogger); // invoke parameterized constructor of parent class
	}
	
	public void logMessage(int logLevel, String message)
	{
		if(logLevel == INFO)
		{
			System.out.println("Log level Info = " + logLevel + " Message = " + message);
		}
		else
		{
			super.logMessage(logLevel, message);
		}
	}
}
