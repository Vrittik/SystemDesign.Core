package systemDesign.Core.CarRental;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
	public int reservationId;
	public User user;
	public Vehicle vehicle;
	public LocalDate reservationStartDate;
	public LocalDate reservationEndDate;
	public LocalTime reservationStartTime;
	public LocalTime reservationEndTime;
	public ReservationType reservationType;
	
	public Reservation makeReservation(Vehicle vehicle, 
			LocalTime startTime, 
			LocalTime endTime,
			LocalDate startDate,
			LocalDate endDate,
			User user)
	{
		// reservation logic, mark vehicle as engaged and creating reservation
		// object
		// also add reservation to the list of reservation, the vehicle holds
	    Reservation reservation = new Reservation();
	    reservation.reservationId = 1;
	    reservation.reservationStartTime = startTime;
	    reservation.reservationEndTime = endTime;
	    reservation.reservationStartDate = startDate;
	    reservation.reservationEndDate = endDate;
	    reservation.user = user;
	    reservation.vehicle = vehicle;
		vehicle.reservations.add(reservation);
	    // save the reservation object and return
		return reservation;
	}
	
	public void completeReservation(Reservation reservation)
	{
		// remove the reservation from the vehicle in order to
		// clear unnecessary space and mark the reservation type to completed
	}
}
