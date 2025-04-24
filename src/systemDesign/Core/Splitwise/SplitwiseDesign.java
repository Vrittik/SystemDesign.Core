package systemDesign.Core.Splitwise;

import java.util.HashMap;
import java.util.Map;

public class SplitwiseDesign {
	private GroupController groupController;
	private UserController userController;
	private ExpenseController expenseController;
	public SplitwiseDesign()
	{
		groupController = new GroupController();
		userController = new UserController();
		expenseController = new ExpenseController();
	}
	
	public void demo()
	{
		User u1 = userController.createUser("Arun");
		User u2 = userController.createUser("Vrittik");
		User u3 = userController.createUser("Surendra");
		
		Group g1 = groupController.createGroup("Moorthal");
		groupController.addUserToGroup(g1, u1);
		groupController.addUserToGroup(g1, u2);
		groupController.addUserToGroup(g1, u3);
		
		// petrol split
		double petrolAmount = 2000;
		System.out.println("Expense - Petrol of Rs " + petrolAmount);
		System.out.print("Paid by " + u3.name + " ");
		System.out.println("and Split " + SplitType.EQUAL.name());
		
		Map<User, Double> s1 = new HashMap<User, Double>();
		s1.put(u1, 0.0);
		s1.put(u3, 0.0);
		s1.put(u2, 0.0);
		Map<User, Double> p1 = new HashMap<User, Double>();
		p1.put(u3, 2000.0);
		
		groupController.createExpense(g1, "Petrol", petrolAmount, SplitType.EQUAL, s1, p1);
		
		// Non veg food split
		double lunchAmount = 2450;
		System.out.println("Expense - Non veg lunch of Rs " + lunchAmount);
		System.out.print("Paid by " + u2.name + " ");
		System.out.println("and Split between " + u2.name + " and " + u3.name);
		
		Map<User, Double> s2 = new HashMap<User, Double>();
		s2.put(u3, 40.0);
		s2.put(u2, 60.0);
		Map<User, Double> p2 = new HashMap<User, Double>();
		p2.put(u2, lunchAmount);
		
		groupController.createExpense(g1, "Non-veg food", lunchAmount, SplitType.PERCENTAGE, s2, p2);
		
		// Rides split
		double rideAmount = 6000;
		System.out.println("Expense - Amusement Park " + rideAmount);
		System.out.print("Paid by " + u2.name + " ");
		System.out.println("and Split between " + u2.name + " and " + u3.name);
				
		Map<User, Double> s3 = new HashMap<User, Double>();
		s3.put(u1, 2000.0);
		s3.put(u2, 2900.0);
		s3.put(u3, 1100.0);
		Map<User, Double> p3 = new HashMap<User, Double>();
		p3.put(u2, 5000.0);
		p3.put(u1, 1000.0);
		
		groupController.createExpense(g1, "Amusement park", rideAmount, SplitType.AMOUNT, s3, p3);
		
		
		System.out.println("Group - " + g1.name);
		groupController.listAllExpenses(g1);
	}
}
