package systemDesign.Core.SingletonDesignPattern;

public class SingletonThreadSafe {
	private SingletonThreadSafe() {}
	
	private static SingletonThreadSafe singletonThreadSafe;
	
	public static synchronized SingletonThreadSafe getInstance() {
		if(singletonThreadSafe == null)
		{
			singletonThreadSafe = new SingletonThreadSafe();
		}
		return singletonThreadSafe;
	}
	
	
	// or we can implement like below
	public static SingletonThreadSafe getInstanceOtherWay() {
		synchronized(SingletonThreadSafe.class) {
			if(singletonThreadSafe == null)
			{
				singletonThreadSafe = new SingletonThreadSafe();
			}
		}
		return singletonThreadSafe;
	}
}
