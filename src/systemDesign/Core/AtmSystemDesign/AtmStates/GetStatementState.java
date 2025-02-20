package systemDesign.Core.AtmSystemDesign.AtmStates;

import java.util.List;

import systemDesign.Core.AtmSystemDesign.AtmMachine;
import systemDesign.Core.AtmSystemDesign.Card;
import systemDesign.Core.AtmSystemDesign.Transaction;
import systemDesign.Core.AtmSystemDesign.TransactionType;

public class GetStatementState extends AtmState {
	Card card;
	
	public GetStatementState(Card c)
	{
		card = c;
	}
	
	public void getStatement(AtmMachine machine) {
		List<Transaction> transactions = card.bankAccount.transactions;
		
		System.out.println("----Printing statement----");
		for(var transaction : transactions)
		{
			String abr = transaction.transactionType.equals(TransactionType.CREDIT) ? "CC" : "DB";
			System.out.println(transaction.transactionNumber + " - " + transaction.amount + " " + abr);
		}
		
		machine.setAtmMachineState(new IdleState());
		System.out.println("---------------------------------\n");
	}
}
