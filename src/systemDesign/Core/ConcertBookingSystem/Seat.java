package systemDesign.Core.ConcertBookingSystem;

public class Seat {
	public String seatNumber;
	public SeatType seatType;
	public SeatStatus seatStatus;
	public int price;
	
	public Seat() {
		
	}
	
	public Seat(String seatNumber, SeatType seatType, SeatStatus seatStatus, int price) {
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.seatStatus = seatStatus;
		this.price = price;
	}
}
