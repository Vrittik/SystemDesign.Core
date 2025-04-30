package systemDesign.Core.SingletonDesignPattern;

public class SingletonDesignPattern {
	public static void main(String[] args)
	{
		SingletonClass threadUnsafe = SingletonClass.getInstance();
		SingletonClass threadUnsafe2 = SingletonClass.getInstance();
		
		SingletonThreadSafe threadSafe = SingletonThreadSafe.getInstance();
		SingletonThreadSafe threadSafe2 = SingletonThreadSafe.getInstance();
		
		
		SingletonThreadSafe threadSafe3 = SingletonThreadSafe.getInstanceOtherWay();
		
		System.out.println(threadUnsafe.hashCode());
		
		System.out.println(threadUnsafe2.hashCode());
		
		System.out.println("----------------------------");
		System.out.println(threadSafe.hashCode());
		
		System.out.println(threadSafe2.hashCode());
		
		System.out.println(threadSafe3.hashCode());
	}
}
