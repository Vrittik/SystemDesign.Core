package systemDesign.Core.BookMyShow;

import java.util.List;

public class Screen {
	public int id;
	public int number;
	public List<Seat> seats;
	
	public List<Seat> getAvailableSeats()
	{
		return seats.stream().filter(seat -> seat.seatStatus != SeatStatus.RESERVED).toList();
	}
}
