package systemDesign.Core.AtmSystemDesign.AtmStates;

import systemDesign.Core.AtmSystemDesign.AtmMachine;
import systemDesign.Core.AtmSystemDesign.Card;
import systemDesign.Core.AtmSystemDesign.OperationType;

public class SelectOperationState extends AtmState{
	
	Card card;
	public SelectOperationState(Card c)
	{
		card = c;
	}
	
	@Override
	public void selectOperation(AtmMachine machine, OperationType operationType) {
		if(operationType.equals(operationType.CHECKBALANCE))
		{
			System.out.println(operationType.CHECKBALANCE.name() + " SELECTED");
			machine.setAtmMachineState(new CheckBalanceState(card));
		}
		else if(operationType.equals(operationType.DEPOSIT))
		{
			System.out.println(operationType.DEPOSIT.name() + " SELECTED");
			System.out.println("Please enter amount to deposit");
			machine.setAtmMachineState(new AddMoneyState(card));
		}
		else if(operationType.equals(operationType.STATEMENT))
		{
			System.out.println(operationType.STATEMENT.name() + " SELECTED");
			machine.setAtmMachineState(new GetStatementState(card));
		}
		else if(operationType.equals(operationType.WITHDRAW))
		{
			System.out.println(operationType.WITHDRAW.name() + " SELECTED");
			System.out.println("Please enter amount to withdraw");
			machine.setAtmMachineState(new WithdrawMoneyState(card));
		}
		else {
			System.out.println("Wrong selection");
			machine.setAtmMachineState(new IdleState());
		}
	}
	
	@Override
	public void cancelTransaction(AtmMachine machine) {
		machine.setAtmMachineState(new IdleState());
	}
}
