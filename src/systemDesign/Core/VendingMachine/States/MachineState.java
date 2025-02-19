package systemDesign.Core.VendingMachine.States;

import systemDesign.Core.VendingMachine.VendingMachine;

public interface MachineState {
	void pressAddCoin(VendingMachine vendingMachine) throws Exception;
	void insertCoin(int coin, VendingMachine machine) throws Exception;
	void selectProduct(VendingMachine vendingMachine) throws Exception;
	void refundMoney(VendingMachine vendingMachine) throws Exception;
	void addProductCode(String code, VendingMachine vendingMachine) throws Exception;
	void dispenseProduct(VendingMachine vendingMachine) throws Exception;
	void returnChange(int changeAmount) throws Exception;
}
