package systemDesign.Core.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {
	public static void main(String args[])
	{
		User user = new User();
		user.id = 1;
		user.name = "Vrittik";
		
		Location location1 = new Location();
		location1.id = 1;
		location1.city = "Bangalore";
		location1.state = "Karnataka";
		
		Location location2 = new Location();
		location2.id = 1;
		location2.city = "New delhi";
		location2.state = "Delhi";
		
		Movie bahubali = new Movie();
		bahubali.id = 1;
		bahubali.name = "Bahubali: The beginning";
		bahubali.lengthInHours = 2.3f;
		bahubali.language = "Hindi";
		
		Movie avengers = new Movie();
		avengers.id = 2;
		avengers.name = "Avengers: End game";
		avengers.lengthInHours = 1.7f;
		
		
		
		
		Seat s1 = new Seat();
		s1.id = 1;
		s1.number = "13A";
		s1.seatStatus = SeatStatus.AVAILABLE;
		s1.seatType = SeatType.ECONOMY;
		
		Seat s2 = new Seat();
		s2.id = 2;
		s2.number = "23B";
		s2.seatStatus = SeatStatus.AVAILABLE;
		s2.seatType = SeatType.PREMIUM;
		
		Screen sc1 = new Screen();
		sc1.id = 1;
		sc1.number = 1;
		List<Seat> seats = new ArrayList<>();
		seats.add(s2);
		seats.add(s1);
		sc1.seats = seats;
		
		
		Theatre theatre1 = new Theatre();
		theatre1.id = 1;
		theatre1.name = "IMAX 2D";
		theatre1.location = location1;
		List<Movie> theatre1movies = new ArrayList<>();
		theatre1movies.add(bahubali);
		theatre1.movies = theatre1movies;
		
		Theatre theatre2 = new Theatre();
		theatre2.id = 2;
		theatre2.name = "IMAX 2D/3D";
		theatre2.location = location2;
		List<Movie> theatre2movies = new ArrayList<>();
		theatre2movies.add(avengers);
		theatre2movies.add(bahubali);
		theatre2.movies = theatre2movies;
		
		Theatre theatre3 = new Theatre();
		theatre3.id = 3;
		theatre3.name = "IMAX 2D/3D";
		theatre3.location = location1;
		List<Movie> theatre3movies = new ArrayList<>();
		theatre3movies.add(bahubali);
		theatre3movies.add(avengers);
		theatre3.movies = theatre3movies;
		List<Screen> scth3 = new ArrayList<>();
		scth3.add(sc1);
		theatre3.screens = scth3;
		
		List<Theatre> listOfTheatres = new ArrayList<>();
		listOfTheatres.add(theatre1);
		listOfTheatres.add(theatre2);
		listOfTheatres.add(theatre3);
		
		// user will select a theatre in a location (delhi)
		// Get the list of theatres at a location
		List<Theatre> bangaloreTheatres = listOfTheatres.stream().filter(theatre -> theatre.location == location1).toList();
		System.out.println("Theatres at location " + location1.city + ", " + location1.state);
		for(var theatre: bangaloreTheatres)
		{
			System.out.println("Theatre name = " + theatre.name);
		}
		
		Theatre selectedTheatre = bangaloreTheatres.get(1);
		
		// list of movies in IMAX 2D/3D (theatre selected by user)
		System.out.println("\nMovies available in " + selectedTheatre.name);
		for(var movie: selectedTheatre.movies)
		{
			System.out.println(movie.name);
		}
		
		List<Screen> theatreScreens = selectedTheatre.screens;
		System.out.println("\nAvailable screens in the selected theatre");
		for(var ss: theatreScreens)
		{
			System.out.println(ss.number);
		}
		
		Screen selectedScreen = theatreScreens.get(0);
		
		System.out.println("\nAvailable seats in the screen");
		for(var seat: selectedScreen.getAvailableSeats())
		{
			System.out.println(seat.number + " type = " + seat.seatType);
		}	
		
		// Choosing 23B screen
		Seat selectedSeat = selectedScreen.seats.get(0);
		
		Bill bill = Bill.GenerateBill(selectedSeat);
		Payment p = new Payment();
		p.bill = bill;
		p.id = 1;
		
		p.performPayment();
		
		System.out.println("Bill has been paid and seat has been selected, seat number = " + selectedSeat.number);
		
		// if another user tries to book the seat
		Bill bill2 = Bill.GenerateBill(selectedSeat);
		if(bill2 == null)
		{
			System.out.println("Seat " + selectedSeat.number + " is already booked");
		}
		
		// now again trying to get available seats
		System.out.println("\nAvailable seats in the screen");
		for(var seat: selectedScreen.getAvailableSeats())
		{
			System.out.println(seat.number + " type = " + seat.seatType);
		}	
	}
}
