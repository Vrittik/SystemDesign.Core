package systemDesign.Core.AtmSystemDesign;

public class Transaction {
	public TransactionType transactionType;
	public String transactionNumber;
	public int amount;
	
	public Transaction(TransactionType type, String transNumber, int amount)
	{
		transactionType = type;
		transactionNumber = transNumber;
		this.amount = amount;
	}
}
