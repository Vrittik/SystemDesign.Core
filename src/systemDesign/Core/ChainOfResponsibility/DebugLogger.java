package systemDesign.Core.ChainOfResponsibility;

public class DebugLogger extends Logger {

	public DebugLogger(Logger nextLogger)
	{
		super(nextLogger);
	}

	public void logMessage(int level, String message) {
		if(level == DEBUG)
		{
			System.out.println("This is a DEBUG catcher, message = " + message);
		}
		else{
			System.out.println("Couldn't catch in DEBUG logger");
			super.logMessage(level, message);
		}
	}
}
