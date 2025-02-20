package systemDesign.Core.AtmSystemDesign.AtmStates;

import java.util.Random;

import systemDesign.Core.AtmSystemDesign.AtmMachine;
import systemDesign.Core.AtmSystemDesign.Card;
import systemDesign.Core.AtmSystemDesign.OperationType;

public abstract class AtmState {
	public void insertCard(AtmMachine atmMachine, Card card)
	{
		System.out.println("oops, please try again and remove the card");
	}
	public void authenticatePin(AtmMachine machine, String pin)
	{
		System.out.println("oops, please insert card again and authenticate");
	}
	public void selectOperation(AtmMachine machine, OperationType operationType) {
		System.out.println("Cannot select operation, pls remove your card and try again");
	}
	public void withdrawMoney(AtmMachine machine, int amount) {
		System.out.println("Cannot withdraw money, pls remove your card and try again");
	}
	public void depositMoney(AtmMachine machine, int amount) {
		System.out.println("Cannot deposit money, pls remove your card and try again");
	}
	public void checkBalance(AtmMachine machine)
	{
		System.out.println("Cannot check balance, pls remove your card and try again");
	}
	public void getStatement(AtmMachine machine) {
		System.out.println("Couldn't get statement, pls remove your card and try again");
	}
	public void cancelTransaction(AtmMachine machine) {
		System.out.println("Cannot cancel a transaction during an operation");
	}
	public String generateTransactionNumber()
	{
		Random r = new Random();
		int txnNumber = r.nextInt(10000000, 99999999);
		return "TXN" + txnNumber;
	}
}
