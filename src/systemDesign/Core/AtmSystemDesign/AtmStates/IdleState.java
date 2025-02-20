package systemDesign.Core.AtmSystemDesign.AtmStates;

import systemDesign.Core.AtmSystemDesign.AtmMachine;
import systemDesign.Core.AtmSystemDesign.Card;

public class IdleState extends AtmState{
	@Override
	public void insertCard(AtmMachine atmMachine, Card card)
	{
		System.out.println("Card inserted - " + card.cardNumber);
		atmMachine.setAtmMachineState(new HasCardState(card));
		System.out.println("Please enter pin");
	}
}
