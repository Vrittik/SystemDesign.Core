package systemDesign.Core.Splitwise;

import java.util.Map;

public class ExpenseController {
	public Expense createExpense(
			String name, 
			Map<User, Double> paidByUsers,
			double amount, SplitType splitType,  
			Map<User, Double> splitPerUser)
	{
		Expense expense = new Expense();
		expense.id = Util.generateId();
		expense.amount = amount;
		expense.name = name;
		expense.splitType = splitType;
		expense.paidByUsers = paidByUsers;
		updateSplitPerUser(amount, splitPerUser, splitType);
		expense.splitPerUser = splitPerUser;
		
		// update each user balance sheet as well
		return expense;
	}
	
	private void updateSplitPerUser(double amount, Map<User, Double> splitPerUser,  SplitType splitType)
	{
		int totalUsers = splitPerUser.size();
		if(splitType == SplitType.EQUAL)
		{
			double amountPerUser = amount/totalUsers;
			for(var split: splitPerUser.entrySet())
			{
				split.setValue(amountPerUser);
			}
		}
		else if(splitType == SplitType.PERCENTAGE)
		{
			for(var split: splitPerUser.entrySet())
			{
				double percentSplit = split.getValue();
				double userAmount = (amount * percentSplit)/100;
				split.setValue(userAmount);
			}
		}
	}
}
