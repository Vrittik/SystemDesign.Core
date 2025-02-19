package systemDesign.Core.VendingMachine;

import java.util.List;

import systemDesign.Core.VendingMachine.States.MachineState;
import systemDesign.Core.VendingMachine.States.Impl.IdleState;

public class VendingMachine {
	public MachineState vendingMachineState;
	public List<ItemShelf> itemShelves;
	public int amount;
	
	public MachineState getVendingMachineState()
	{
		return vendingMachineState;
	}
	
	public void setVendingMachineState(MachineState state)
	{
		vendingMachineState = state;
	}
	
	public void resetVendingMachine(){
		this.vendingMachineState = new IdleState();
		this.amount = 0;
	}
	
	public void printMachine()
	{
		System.out.println("---------Vending machine---------");
		for(var shelf : itemShelves)
		{
			System.out.print(shelf.item.itemName.name() + " --> ");
			System.out.print(shelf.code + ", ");
			System.out.print(shelf.item.cost + "\n");
		}
	}
}
