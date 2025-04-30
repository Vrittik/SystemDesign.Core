package systemDesign.Core.ConcertBookingSystem;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ConcertBookingSystem {
	private ConcertBookingSystem() {
		bookings = new ArrayList<>();
		concerts = new ArrayList<>();
	}
	
	private static ConcertBookingSystem concertBookingSystem;
	private final Object lock = new Object();
	
	private List<Concert> concerts;
	private List<Booking> bookings;
	
	private static int bookingId = 1;
	
	public static synchronized ConcertBookingSystem getInstance() {
		if(concertBookingSystem == null)
		{
			concertBookingSystem = new ConcertBookingSystem();
		}
		return concertBookingSystem;
	}
	
	public void addConcert(Concert concert)
	{
		concerts.add(concert);
	}
	
	public Booking createBooking(Concert concert, 
			Customer customer, Seat seat)
	{
		Seat availableSeat = null;
		synchronized(lock) {
			List<Seat> availableSeats = concert.availableSeats;
			for(var s : availableSeats) {
				if(s.seatNumber.equalsIgnoreCase(seat.seatNumber) && s.seatStatus != SeatStatus.RESERVED)
				{
					availableSeat = s;
					s.seatStatus = SeatStatus.RESERVED;
					break;
				}
			}
			if(availableSeat == null)
			{
				System.out.println("SEAT ALREADY BOOKED");
				return null;
			}
		}
		// make payment
		
		Booking booking = new Booking(bookingId, concert, availableSeat, customer);
		booking.bookingStatus = BookingStatus.CONFIRMED;
		bookings.add(booking);
		bookingId++;
		System.out.println("Booking Success");
		return booking;
	}
	
	public Booking getBooking(int bookingId)
	{
		return bookings.stream().filter(booking -> booking.id == bookingId).findFirst().orElse(null);
	}
	
	public Booking cancelBooking(int bookingId)
	{
		Booking booking = getBooking(bookingId);
		if(booking == null) return null;
		
		Seat bookedSeat = booking.seat;
		Concert concert = booking.concert;
		
		synchronized(lock) {
			for(var seat : concert.availableSeats)
			{
				if(seat.seatNumber == bookedSeat.seatNumber)
				{
					seat.seatStatus = SeatStatus.AVAILABLE;
					break;
				}
			}
		}
		
		int bookingIndex = -1;
		
		for(int i = 0; i<bookings.size(); i++)
		{
			if(bookingId == bookings.get(i).id)
			{
				bookingIndex = i;
				break;
			}
		}
		
		bookings.remove(bookingIndex);
		
		booking.bookingStatus = BookingStatus.CANCELLED;
		
		// refund the payment
		return booking;
	}
	
	public List<Concert> searchConcert(String singer, LocalDate concertDate, String venue)
	{
		return concerts.stream().filter(concert -> concert.singer.equalsIgnoreCase(singer) 
				&& concert.concertDate.equals(concertDate) 
				&& concert.venue.equalsIgnoreCase(venue)).collect(Collectors.toList());
	}
}
