package systemDesign.Core.VendingMachine.States.Impl;

import systemDesign.Core.VendingMachine.VendingMachine;
import systemDesign.Core.VendingMachine.States.MachineState;

public class HasMoneyState implements MachineState{

	@Override
	public void pressAddCoin(VendingMachine vendingMachine) throws Exception {
		return;
	}

	@Override
	public void insertCoin(int coin, VendingMachine vendingMachine) throws Exception {
		System.out.println("User added " + coin + "$");
		vendingMachine.amount += coin;
	}

	@Override
	public void selectProduct(VendingMachine vendingMachine) throws Exception {
		System.out.println("User now clicked on select product button");
		vendingMachine.setVendingMachineState(new SelectionState());
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
		throw new Exception("Cannot add product code in has money state");
	}

	@Override
	public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot dispense product in has money state");
	}

	@Override
	public void returnChange(int changeAmount) throws Exception {
		throw new Exception("Cannot return change in has money state");
	}

}
