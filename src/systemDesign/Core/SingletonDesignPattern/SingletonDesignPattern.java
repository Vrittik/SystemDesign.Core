package systemDesign.Core.SingletonDesignPattern;

public class SingletonDesignPattern {
	public static void main(String[] args)
	{
		// ----------Thread unsafe----------
		// Default thread
		SingletonClass object1 = SingletonClass.getInstance();
		SingletonClass object2 = SingletonClass.getInstance();
		System.out.println("Object 1 hashcode = " + object1.hashCode());
		System.out.println("Object 2 hashcode = " + object2.hashCode());
		// Same instance will be used
		//Object 1 hashcode = 455659002
		//Object 2 hashcode = 455659002

		// To flush the existing object (For understanding purpose of thread unsafe)
		SingletonClass.flushObject();

		// Execute two threads together to create the object
		Runnable createObjectTask = () -> {
			SingletonClass object = SingletonClass.getInstance();
			System.out.println("Thread created object hashcode = " + object.hashCode());
		};

		Thread t1 = new Thread(createObjectTask, "Thread1");
		Thread t2 = new Thread(createObjectTask, "Thread2");

		// Two different objects will be created, although not a guarantee (Might
		// not fall exactly concurrent)
		t1.start();
		t2.start();
		//Thread created object hashcode = 277558799
		//Thread created object hashcode = 488651499

		// -------Thread safe singleton----------
		Runnable createThreadSafeObject = () -> {
			SingletonThreadSafe object = SingletonThreadSafe.getInstance();
			System.out.println("Thread created object (safe) hashcode = " + object.hashCode());
		};

		Thread t3 = new Thread(createThreadSafeObject, "Thread3");
		Thread t4 = new Thread(createThreadSafeObject, "Thread4");

		// One object will be created by one thread and second one would use the object
		t3.start();
		t4.start();
		//Thread created object (safe) hashcode = 712881004
		//Thread created object (safe) hashcode = 712881004
	}
}
