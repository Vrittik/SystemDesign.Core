package systemDesign.Core.ChainOfResponsibility;

public class ErrorLogger extends Logger {

	public ErrorLogger(Logger nextLogger)
	{
		super(nextLogger);
	}

	public void logMessage(int level, String message) {
		if(level == ERROR)
		{
			System.out.println("This is an ERROR catcher, message = " + message);
		}
		else{
			System.out.println("Couldn't catch in ERROR logger");
			super.logMessage(level, message);
		}
	}
}
