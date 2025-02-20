package systemDesign.Core.AtmSystemDesign;

import java.time.LocalDate;
import java.util.ArrayList;

import systemDesign.Core.AtmSystemDesign.AtmStates.IdleState;

public class AtmSystemDesign {
	public static void main(String[] args)
	{
		AtmSystemDesign design = new AtmSystemDesign();
		
		AtmMachine machine = design.initializeMachine();
		Card card = design.intializeCardAndAccount();
		
		// initiate the process
		
		// debit
		design.debitAmount(machine, card, 3000);
		
		// credit 
		design.creditAmount(machine, card, 4000);
		
		// debiting more than atm limit, 5000 is limit and 3000 taken
		design.debitAmount(machine, card, 4000);
		
		
		// print statement
		design.printStatement(machine, card);
	}
	
	public AtmMachine initializeMachine() {
		AtmMachine machine = new AtmMachine();
		machine.availableBalance = 5000;
		machine.setAtmMachineState(new IdleState());
		return machine;
	}
	
	public Card intializeCardAndAccount() {
		
		BankAccount account = new BankAccount();
		account.accountHolderName = "VRITTIK SHARMA";
		account.balance = 10000;
		account.transactions = new ArrayList<>();
		account.accountNumber = "0022010235565";
		
		Card c = new Card();
		c.cardNumber = "556677872233";
		c.expiry = LocalDate.of(2034, 5, 1);
		c.pin = "00878";
		c.bankAccount = account;
		
		return c;
	}
	
	public void debitAmount(AtmMachine machine, Card card, int amount) {
		var machineState = machine.getAtmMachineState();
		// 1. Machine is in idle state
		machineState.insertCard(machine, card);
		machineState = machine.getAtmMachineState();
		
		// 2. Machine moved to authentication stage
		machineState.authenticatePin(machine, "00878");
		machineState = machine.getAtmMachineState();
		
		// 3. Machine now moved to select operation stage
		machineState.selectOperation(machine, OperationType.WITHDRAW);
		machineState = machine.getAtmMachineState();
		
		// 4. Machine now moved to withdraw state
		machineState.withdrawMoney(machine, amount);
	}
	
	public void creditAmount(AtmMachine machine, Card card, int amount) {
		var machineState = machine.getAtmMachineState();
		// 1. Machine is in idle state
		machineState.insertCard(machine, card);
		machineState = machine.getAtmMachineState();
		
		// 2. Machine moved to authentication stage
		machineState.authenticatePin(machine, "00878");
		machineState = machine.getAtmMachineState();
		
		// 3. Machine now moved to select operation stage
		machineState.selectOperation(machine, OperationType.DEPOSIT);
		machineState = machine.getAtmMachineState();
		
		// 4. Machine now moved to withdraw state
		machineState.depositMoney(machine, amount);
	}
	
	public void printStatement(AtmMachine machine, Card card) {
		var machineState = machine.getAtmMachineState();
		// 1. Machine is in idle state
		machineState.insertCard(machine, card);
		machineState = machine.getAtmMachineState();
		
		// 2. Machine moved to authentication stage
		machineState.authenticatePin(machine, "00878");
		machineState = machine.getAtmMachineState();
		
		// 3. Machine now moved to select operation stage
		machineState.selectOperation(machine, OperationType.STATEMENT);
		machineState = machine.getAtmMachineState();
		
		// 4. Machine now moved to withdraw state
		machineState.getStatement(machine);
	}
}
