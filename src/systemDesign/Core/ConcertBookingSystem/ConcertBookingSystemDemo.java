package systemDesign.Core.ConcertBookingSystem;

import java.time.LocalDate;
import java.util.*;

public class ConcertBookingSystemDemo {
	public static void main(String[] args)
	{
		ConcertBookingSystem concertBookingSystem = ConcertBookingSystem.getInstance();
		
		Concert concert1 = createConcert(100, "TRAVIS SCOTT", LocalDate.of(2024, 8, 23));
		Concert concert2 = createConcert(150, "JON TOLIVER", LocalDate.of(2024, 6, 15));
		
		concertBookingSystem.addConcert(concert1);
		concertBookingSystem.addConcert(concert2);
		
		List<Concert> concerts = concertBookingSystem.searchConcert("TRAVIS SCOTT", LocalDate.of(2024, 8, 23), "NEHRU PLACE");
		
		Concert myConcert = concerts.get(0);
		
		Customer customer1 = new Customer("Vrittik", "9988787823");
		Customer customer2 = new Customer("Vrittik", "9988787823");
		
		Seat seat = new Seat();
		seat.seatNumber = "14E";
		
		Booking booking = concertBookingSystem.createBooking(myConcert, customer1, seat);
		
		Booking booking2 = concertBookingSystem.createBooking(myConcert, customer2, seat);
		
		concertBookingSystem.cancelBooking(booking.id);
		Booking booking3 = concertBookingSystem.createBooking(myConcert, customer2, seat);
	}
	
	public static Concert createConcert(int totalSeats, String singerName, LocalDate concertDate)
	{
		List<Seat> seats = new ArrayList<>();
		for(int i = 1; i<=totalSeats; i++)
		{
			if(i<=10)
			{
				Seat s = new Seat(i + "P", SeatType.PREMIUM, SeatStatus.AVAILABLE, 110);
				seats.add(s);
			}
			else {
				Seat s = new Seat(i + "E", SeatType.ECONOMY, SeatStatus.AVAILABLE, 40);
				seats.add(s);
			}
		}
		Concert concert = new Concert("TRAVIS SCOTT", concertDate, seats, "NEHRU PLACE");
		return concert;
	}
}
