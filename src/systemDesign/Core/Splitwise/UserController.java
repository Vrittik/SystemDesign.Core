package systemDesign.Core.Splitwise;

import java.util.Random;

public class UserController {
	
	public User createUser(String name)
	{
		User user = new User();
		user.id = Util.generateId();
		user.name = name;
		
		BalanceSheet sheet = new BalanceSheet();
		user.balanceSheet = sheet;
		
		return user;
	}
}
