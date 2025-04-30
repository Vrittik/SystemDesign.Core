package systemDesign.Core.ConcertBookingSystem;

import java.time.LocalDate;
import java.util.List;

public class Concert {
	public String singer;
	public LocalDate concertDate;
	public List<Seat> availableSeats;
	public String venue;
	
	public Concert() {
	}
	
	public Concert(String singer, LocalDate concertDate, List<Seat> availableSeats, String venue) {
		this.singer = singer;
		this.concertDate = concertDate;
		this.availableSeats = availableSeats;
		this.venue = venue;
	}
}
