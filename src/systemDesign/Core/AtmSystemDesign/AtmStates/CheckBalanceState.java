package systemDesign.Core.AtmSystemDesign.AtmStates;

import systemDesign.Core.AtmSystemDesign.AtmMachine;
import systemDesign.Core.AtmSystemDesign.Card;
import systemDesign.Core.AtmSystemDesign.Transaction;
import systemDesign.Core.AtmSystemDesign.TransactionType;

public class CheckBalanceState extends AtmState{
	Card card;
	
	public CheckBalanceState(Card c)
	{
		card = c;
	}
	
	@Override
	public void checkBalance(AtmMachine machine) {
		System.out.println("Account : " + card.bankAccount.accountNumber + " has balance  " + card.bankAccount.balance);
		machine.setAtmMachineState(new IdleState());
		System.out.println("---------------------------------\n");
	}
}
