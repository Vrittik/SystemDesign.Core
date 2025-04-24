package systemDesign.Core.Splitwise;

import java.util.*;

public class GroupController {
	
	private ExpenseController expenseController;
	
	public GroupController() {
		expenseController = new ExpenseController();
	}
	public Group createGroup(String name)
	{
		Group group = new Group();
		group.id = Util.generateId();
		group.name = name;
		group.expenses = new ArrayList<Expense>();
		group.users = new ArrayList<User>();
		System.out.println("Create group - " + name);
		return group;
	}
	
	public void addUserToGroup(Group group, User user)
	{
		group.users.add(user);
		System.out.println("Added " + user.name + " to " + group.name);
	}
	
	public void createExpense(Group g, String name, double amount, SplitType splitType, Map<User, Double> splitPerUser, Map<User, Double> paidByUser)
	{
		Expense expense = expenseController.createExpense(name, paidByUser, amount, splitType, splitPerUser);
		g.expenses.add(expense);
	}
	
	public void listAllExpenses(Group g1)
	{
		System.out.println("Expenses of the group");
		double totalExpenses = 0.0;
		for(var expense: g1.expenses)
		{
			System.out.println("Expense = " + expense.name);
			for(var paidUser : expense.paidByUsers.entrySet())
			{
				System.out.println("Paid by " + paidUser.getKey().name + " Amount of " + paidUser.getValue());
			}
			for(var userSplit : expense.splitPerUser.entrySet())
			{
				System.out.println(userSplit.getKey().name + " owes " + userSplit.getValue());
			}
			totalExpenses = totalExpenses + expense.amount;
		}
		System.out.println("\nTotal group expenses - " + totalExpenses);
	}
}
