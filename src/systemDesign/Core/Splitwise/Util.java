package systemDesign.Core.Splitwise;

import java.util.Random;

public class Util {
	public static int generateId()
	{
		Random r = new Random();
		return r.nextInt(100, 200);
	}
}
