package systemDesign.Core.CarRental;

public class Payment {
	public int paymentId;
	public Bill bill;
	public String paymentType; //enum of cash/digital
	
	public boolean makePayment(Bill bill)
	{
		// make payment
		// return whether successful or not
		return true;
	}
}
