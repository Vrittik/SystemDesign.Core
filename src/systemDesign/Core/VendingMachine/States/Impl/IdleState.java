package systemDesign.Core.VendingMachine.States.Impl;

import systemDesign.Core.VendingMachine.VendingMachine;
import systemDesign.Core.VendingMachine.States.MachineState;

public class IdleState implements MachineState{

	@Override
	public void pressAddCoin(VendingMachine vendingMachine) throws Exception {
		System.out.println("User clicked on add coin");
		vendingMachine.setVendingMachineState(new HasMoneyState());
	}

	@Override
	public void insertCoin(int coin, VendingMachine machine) throws Exception {
		throw new Exception("Cannot add coin in idle state");
	}

	@Override
	public void selectProduct(VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot select product in idle state");
		
	}

	@Override
	public void refundMoney(VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot return money in idle state");
	}

	@Override
	public void addProductCode(String code, VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot add product code in idle state");
	}

	@Override
	public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
		throw new Exception("Cannot dispense product code in idle state");
	}

	@Override
	public void returnChange(int changeAmount) throws Exception {
		throw new Exception("Cannot return change in idle state");
	}

}
