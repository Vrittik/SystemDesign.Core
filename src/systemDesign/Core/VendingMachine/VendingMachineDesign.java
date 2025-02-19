package systemDesign.Core.VendingMachine;

import java.util.*;

import systemDesign.Core.VendingMachine.States.Impl.IdleState;

public class VendingMachineDesign {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		VendingMachine vendingMachine = new VendingMachine();
		List<Item> items = new ArrayList<>();
		
		var coffee = new Item(ItemName.COFFEE, 40);
		var coke = new Item(ItemName.COKE, 20);
		var maaza = new Item(ItemName.MAAZA, 30);
		var chips = new Item(ItemName.CHIPS, 25);
		
		List<ItemShelf> shelves = new ArrayList<>();
		shelves.add(new ItemShelf(coffee, 4, "D1"));
		shelves.add(new ItemShelf(maaza, 6, "D2"));
		shelves.add(new ItemShelf(maaza, 4, "D3"));
		
		
		shelves.add(new ItemShelf(coke, 8, "E1"));
		shelves.add(new ItemShelf(maaza, 4, "E2"));
		shelves.add(new ItemShelf(chips, 4, "E3"));
		
		shelves.add(new ItemShelf(chips, 3, "F1"));
		shelves.add(new ItemShelf(maaza, 4, "F2"));
		shelves.add(new ItemShelf(coffee, 2, "F3"));
		
		shelves.add(new ItemShelf(chips, 12, "G1"));
		shelves.add(new ItemShelf(coke, 8, "G2"));
		shelves.add(new ItemShelf(coffee, 4, "G3"));
		
		vendingMachine.itemShelves = shelves;
		vendingMachine.vendingMachineState = new IdleState();
		
		// start the process
		
		// Print vending machine
		vendingMachine.printMachine();
		
		// Happy flow
		try {
			
		System.out.println("\n---------Operation beings---------");
		var machineState = vendingMachine.vendingMachineState;
		
		// press add coin
		machineState.pressAddCoin(vendingMachine);
		
		// Has money machine state
		machineState = vendingMachine.getVendingMachineState();
		
		machineState.insertCoin(10, vendingMachine);
		machineState.insertCoin(30, vendingMachine);
		
		machineState.selectProduct(vendingMachine);
		
		// Select product state
		machineState = vendingMachine.getVendingMachineState();
		machineState.addProductCode("F1", vendingMachine);
		
		// Dispense product state
		machineState = vendingMachine.getVendingMachineState();
		machineState.dispenseProduct(vendingMachine);
		
		
		// print machine after dispense
		vendingMachine.printMachine();
		}
		catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		// Refund flow
		try {
			
		System.out.println("\n---------Operation 2 beings---------");
		var machineState = vendingMachine.vendingMachineState;
		
		// press add coin
		machineState.pressAddCoin(vendingMachine);
		
		// Has money machine state
		machineState = vendingMachine.getVendingMachineState();
		
		machineState.insertCoin(10, vendingMachine);
		machineState.insertCoin(30, vendingMachine);
		
		machineState.selectProduct(vendingMachine);
		
		// refunding before selecting product code
		machineState = vendingMachine.getVendingMachineState();
		machineState.refundMoney(vendingMachine);
		
//		// Refund after selecting product product state
//		machineState = vendingMachine.getVendingMachineState();
//		Cannot refund money in dispense state
//		
		// machineState.refundMoney(vendingMachine);
		
		// print machine after dispense
		vendingMachine.printMachine();
		}
		catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
	}
}
