package systemDesign.Core.Splitwise;

import java.util.*;

public class Expense {
	public int id;
	public Map<User, Double> paidByUsers;
	public String name;
	public double amount;
	public SplitType splitType;
	public Map<User, Double> splitPerUser;
}
