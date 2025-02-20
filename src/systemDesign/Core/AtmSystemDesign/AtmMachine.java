package systemDesign.Core.AtmSystemDesign;

import systemDesign.Core.AtmSystemDesign.AtmStates.AtmState;

public class AtmMachine {
	public AtmState atmState;
	public int availableBalance;
	
	public void setAtmMachineState(AtmState newState)
	{
		atmState = newState;
	}
	
	public AtmState getAtmMachineState()
	{
		return atmState;
	}
}
