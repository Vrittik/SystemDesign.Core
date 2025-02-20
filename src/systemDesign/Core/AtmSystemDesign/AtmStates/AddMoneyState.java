package systemDesign.Core.AtmSystemDesign.AtmStates;

import java.util.Random;

import systemDesign.Core.AtmSystemDesign.AtmMachine;
import systemDesign.Core.AtmSystemDesign.Card;
import systemDesign.Core.AtmSystemDesign.Transaction;
import systemDesign.Core.AtmSystemDesign.TransactionType;

public class AddMoneyState extends AtmState{
	Card card;
	
	public AddMoneyState(Card c)
	{
		card = c;
	}
	
	@Override
	public void depositMoney(AtmMachine machine, int amount) {
		System.out.println("Amount entered " + amount);
		
		card.bankAccount.balance += amount;
		String txNumber = generateTransactionNumber();
		Transaction tx = new Transaction(TransactionType.CREDIT, txNumber, amount);
		card.bankAccount.transactions.add(tx);
		machine.setAtmMachineState(new IdleState());
		System.out.println("Successfully added " + amount + " to account " + card.bankAccount.accountNumber);
		System.out.println("Balance now - " + card.bankAccount.balance);
		System.out.println("---------------------------------\n");
	}
}
