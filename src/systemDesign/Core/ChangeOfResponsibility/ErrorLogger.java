package systemDesign.Core.ChangeOfResponsibility;

public class ErrorLogger extends Logger {
	
	public ErrorLogger(Logger nextLogger)
	{
		super(nextLogger); // invoke parameterized constructor of parent class
	}
	
	public void logMessage(int logLevel, String message)
	{
		if(logLevel == ERROR)
		{
			System.out.println("Log level Error = " + logLevel + " Message = " + message);
		}
		else
		{
			super.logMessage(logLevel, message);
		}
	}
}
