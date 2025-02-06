package systemDesign.Core.BookMyShow;

public class Payment {
	public int id;
	public Bill bill;
	
	public void performPayment()
	{
		// perform some payment actions
		// if success, mark seat as booked, update bill as paid
		bill.isPaid = true;
		bill.seat.seatStatus = SeatStatus.RESERVED;
	}
}
