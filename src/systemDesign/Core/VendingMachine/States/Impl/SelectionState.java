package systemDesign.Core.VendingMachine.States.Impl;

import systemDesign.Core.VendingMachine.Item;
import systemDesign.Core.VendingMachine.ItemShelf;
import systemDesign.Core.VendingMachine.VendingMachine;
import systemDesign.Core.VendingMachine.States.MachineState;

public class SelectionState implements MachineState{

	@Override
	public void pressAddCoin(VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot press add coin in selection state");
	}

	@Override
	public void insertCoin(int coin, VendingMachine machine) throws Exception {
		throw new Exception("Cannot insert coin in selection state");
	}

	@Override
	public void selectProduct(VendingMachine vendingMachine) throws Exception {
		return;
	}

	@Override
	public void refundMoney(VendingMachine vendingMachine) throws Exception {
		System.out.println("User clicked on refund button");
		if(vendingMachine.amount > 0)
		{
			System.out.println("Returned " + vendingMachine.amount + " on refund click");
		}
		vendingMachine.resetVendingMachine();
	}

	@Override
	public void addProductCode(String code, VendingMachine vendingMachine) throws Exception {
		System.out.println("User entered " + code + " code ");
		int currentlyPaid = vendingMachine.amount;
		ItemShelf selectedShelf = vendingMachine.itemShelves.stream().filter(shelf -> shelf.code == code).findFirst().orElse(null);
		
		if(selectedShelf == null || selectedShelf.quantity == 0)
		{
			System.out.println("Product doesnt exists or it is sold out.");
		}
		
		Item selectedItem = selectedShelf.item;
		
		System.out.println("User wants " + selectedItem.itemName.name());
		
		if(selectedItem.cost > currentlyPaid)
		{
			System.out.println("Insufficient funds");
			refundMoney(vendingMachine);
		}
		
		int change = currentlyPaid - selectedItem.cost;
		for(var shelf: vendingMachine.itemShelves)
		{
			if(shelf.code == code)
			{
				shelf.quantity = shelf.quantity - 1;
				break;
			}
		}
		vendingMachine.setVendingMachineState(new DispenseState(selectedShelf, change));
	}

	@Override
	public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot dispense product in selection state");
	}

	@Override
	public void returnChange(int changeAmount) throws Exception {
		throw new Exception("Cannot return change in selection state");
	}

}
