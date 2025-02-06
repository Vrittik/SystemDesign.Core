package systemDesign.Core.BookMyShow;

public class Bill {
	public int id;
	public float amount;
	public Seat seat;
	public boolean isPaid;
	
	public static Bill GenerateBill(Seat seat) {
		if(seat.seatStatus == SeatStatus.AVAILABLE)
		{
			Bill b = new Bill();
			b.amount = 235.6f;
			b.id = 1;
			b.isPaid = false;
			b.seat = seat;
			return b;
		}
		return null;
	}
}
