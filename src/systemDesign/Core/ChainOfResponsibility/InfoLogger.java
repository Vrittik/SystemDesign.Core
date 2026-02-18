package systemDesign.Core.ChainOfResponsibility;

public class InfoLogger extends Logger {

	public InfoLogger(Logger nextLogger)
	{
		super(nextLogger);
	}

	public void logMessage(int level, String message) {
		if(level == INFO)
		{
			System.out.println("This is an INFO catcher, message = " + message);
		}
		else{
			System.out.println("Couldn't catch in INFO logger");
			super.logMessage(level, message);
		}
	}
}
