package systemDesign.Core.AtmSystemDesign.AtmStates;

import java.time.LocalDate;

import systemDesign.Core.AtmSystemDesign.AtmMachine;
import systemDesign.Core.AtmSystemDesign.Card;
import systemDesign.Core.AtmSystemDesign.OperationType;

public class HasCardState extends AtmState{
	Card card;
	
	public HasCardState(Card c)
	{
		card = c;
	}
	
	public void authenticatePin(AtmMachine machine, String pin)
	{
		System.out.println("Entered pin : " + pin);
		
		if(!card.pin.equals(pin))
		{
			System.out.println("Invalid pin, please try again later");
			machine.setAtmMachineState(new IdleState());
			return;
		}
		if(card.expiry.isBefore(LocalDate.now()))
		{
			System.out.println("Card is expired");
			machine.setAtmMachineState(new IdleState());
			return;
		}
		
		System.out.println("Card authenticated");
		
		System.out.print("Please select operation - ");
		System.out.print(OperationType.CHECKBALANCE.name() + ", ");
		System.out.print(OperationType.DEPOSIT.name() + ", ");
		System.out.print(OperationType.STATEMENT.name() + ", ");
		System.out.print(OperationType.WITHDRAW.name() + " ");
		System.out.println();
		machine.setAtmMachineState(new SelectOperationState(card));
	}
	
	
	@Override
	public void cancelTransaction(AtmMachine machine) {
		machine.setAtmMachineState(new IdleState());
	}
}
