package systemDesign.Core.SingletonDesignPattern;

public class SingletonClass {
	
	private SingletonClass() {}
	
	private static SingletonClass singletonClass;
	
	public static SingletonClass getInstance()
	{
		if(singletonClass == null)
		{
			singletonClass = new SingletonClass();
		}
		return singletonClass;
	}

	// Method to understand thread runners
	public static void flushObject(){
		singletonClass = null;
	}
}
