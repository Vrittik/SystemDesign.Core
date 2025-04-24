package systemDesign.Core.Splitwise;

import java.util.Map;

public class BalanceSheet {
	public int id;
	public Map<User, PendingAmount> pendingAmountPerUser;
	public double totalDue;
	public double totalGetsBack;
	public PendingType dueType;
}
