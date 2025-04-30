package systemDesign.Core.ConcertBookingSystem;

public class Booking {
	public int id;
	public Concert concert;
	public Seat seat;
	public Customer customer;
	public BookingStatus bookingStatus;
	
	public Booking() {
	}
	public Booking(int id, Concert concert, Seat seat, Customer customer) {
		this.id = id;
		this.concert = concert;
		this.seat = seat;
		this.customer = customer;
		this.bookingStatus = BookingStatus.PENDING;
	}
}
