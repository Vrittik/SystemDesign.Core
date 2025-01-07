package systemDesign.Core.CarRental;

public class Bill {
	public int billId;
	public float amount;
	public Reservation reservation;
	public boolean isPaid;
	
	public Bill generateBill(Reservation reservation)
	{
		Bill bill = new Bill();
		bill.billId = 1;
		bill.amount = 400; // Calculate based on the reservation and vehicle details
		                   // from reservation object
		bill.reservation = reservation;
		bill.isPaid = false;
		// save bill in db
		return bill;
	}
	
	public void markBillPaid(Bill bill)
	{
		bill.isPaid = true;
		// save/update in DB
	}
}
