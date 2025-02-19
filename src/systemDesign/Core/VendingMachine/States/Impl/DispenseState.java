package systemDesign.Core.VendingMachine.States.Impl;

import systemDesign.Core.VendingMachine.ItemShelf;
import systemDesign.Core.VendingMachine.VendingMachine;
import systemDesign.Core.VendingMachine.States.MachineState;

public class DispenseState implements MachineState{
	
	ItemShelf selectedShelf;
	int changeAmount;
	
	public DispenseState(ItemShelf shelf, int amount)
	{
		selectedShelf = shelf;
		changeAmount = amount;
	}
	
	@Override
	public void pressAddCoin(VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot press add coin in dispense state");
	}

	@Override
	public void insertCoin(int coin, VendingMachine machine) throws Exception {
		throw new Exception("Cannot insert coin in dispense state");
	}

	@Override
	public void selectProduct(VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot select product in dispense state");
	}

	@Override
	public void refundMoney(VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot refund money in dispense state");
	}

	@Override
	public void addProductCode(String code, VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot add product in dispense state");
	}

	@Override
	public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
		System.out.println("Successfully dispensed Item - " + selectedShelf.item.itemName.name() + " from shelf " + selectedShelf.code);
		returnChange(changeAmount);
		vendingMachine.resetVendingMachine();
	}

	@Override
	public void returnChange(int changeAmount) throws Exception {
		System.out.println("Successfully returned change amount of " + changeAmount);
	}

}
