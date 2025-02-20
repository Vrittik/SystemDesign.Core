package systemDesign.Core.AtmSystemDesign.AtmStates;

import systemDesign.Core.AtmSystemDesign.AtmMachine;
import systemDesign.Core.AtmSystemDesign.Card;
import systemDesign.Core.AtmSystemDesign.Transaction;
import systemDesign.Core.AtmSystemDesign.TransactionType;

public class WithdrawMoneyState extends AtmState{
	Card card;
	
	public WithdrawMoneyState(Card c)
	{
		card = c;
	}
	
	@Override
	public void withdrawMoney(AtmMachine machine, int amount) {
		System.out.println("Amount entered " + amount);
		
		if(card.bankAccount.balance < amount)
		{
			System.out.println("Insufficient funds in accounts, please try again");
		}
		else if(machine.availableBalance < amount)
		{
			System.out.println("Machine does not have enough notes, please try again with less amount");
		}
		else {
			card.bankAccount.balance -= amount;
			machine.availableBalance -= amount;
			
			String txNumber = generateTransactionNumber();
			Transaction tx = new Transaction(TransactionType.DEBIT, txNumber, amount);
			card.bankAccount.transactions.add(tx);
			
			System.out.println("Successfully debited rupees " + amount + " from account - " + card.bankAccount.accountNumber);
			System.out.println("Balance now - " + card.bankAccount.balance);
		}
		machine.setAtmMachineState(new IdleState());
		System.out.println("---------------------------------\n");
	}
}
