package systemDesign.Core.CarRental;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CarRentalFlow {
	public static void main(String[] args)
	{
		User user1 = new User();
		user1.drivingLicence = "DL56NN76293";
		user1.Id = 1;
		user1.mobileNumber = "9887787787";
		user1.name = "Vrittik";
		
		User user2 = new User();
		user2.drivingLicence = "DL99UH76798";
		user2.Id = 2;
		user2.mobileNumber = "9887787787";
		user2.name = "Vaibhav";
		
		Location location1 = new Location();
		location1.locationId = 1;
		location1.State = "Haryana";
		location1.City = "Gurgaon";
		location1.District = "Cyber city";
		location1.pinCode = "122334";
		
		Location location2 = new Location();
		location2.locationId = 2;
		location2.State = "Delhi";
		location2.City = "New Delhi";
		location2.District = "Trilokpuri";
		location2.pinCode = "120023";
		
		Vehicle hondaCity = new Vehicle();
		hondaCity.perDayAmount = 4000;
		hondaCity.isVehicleAvailable = true;
		hondaCity.vehicleColor = "white";
		hondaCity.vehicleId = 1;
		hondaCity.vehicleType = VehicleType.CAR;
		
		Vehicle mercedesBenz = new Vehicle();
		mercedesBenz.perDayAmount = 10000;
		mercedesBenz.isVehicleAvailable = true;
		mercedesBenz.vehicleColor = "Silver";
		mercedesBenz.vehicleId = 2;
		mercedesBenz.vehicleType = VehicleType.CAR;
		
		Vehicle alto = new Vehicle();
		alto.perDayAmount = 1500;
		alto.isVehicleAvailable = true;
		alto.vehicleColor = "Grey";
		alto.vehicleId = 3;
		alto.vehicleType = VehicleType.CAR;
		
		
		Store store1 = new Store();
		store1.storeId = 1;
		store1.location = location1;
		store1.storeName = "Vivian store";
		store1.vehicles.add(mercedesBenz);
		store1.vehicles.add(hondaCity);
		
		Store store2 = new Store();
		store2.storeId = 2;
		store2.location = location2;
		store2.storeName = "Vivian store";
		store2.vehicles.add(alto);
		
		hondaCity.store = store1;
		mercedesBenz.store = store1;
		
		alto.store = store2;
		
		List<Store> stores = new ArrayList<>();
		stores.add(store2);
		stores.add(store1);
		CarRentalDomainLogic logic = new CarRentalDomainLogic();
		logic.stores = stores;
		
		// Let's begin the flow now
		// user searches for a location, let's say its closely matched to 
		// location 1
		
		// 1. Get the number of stores of that location
		List<Store> filteredStores = logic.searchStore(location1);
		// 2. User chooses 1 store, the first in the list
		Store store = filteredStores.get(0);
		// 3. User searches for car or bike and select the date and time for reservation
		LocalDate startDate = LocalDate.of(2025, 1, 8);
		LocalDate endDate = LocalDate.of(2025, 1, 9);
		LocalTime startTime = LocalTime.of(12, 00);
		LocalTime endTime = LocalTime.of(21, 00);
		
		List<Vehicle> vehicles = store.findVehicles(VehicleType.CAR, 
				startTime,
				endTime,
				startDate, 
				endDate);
		// 4. Let's say the user selects 1 vehicle, vehicle at 0th index
		Vehicle vehicle = vehicles.get(0);
		// 5. User makes a reservation with vehicle 1 and selected dates
		Reservation reservation = new Reservation();
		reservation.makeReservation(vehicle, 
				startTime, endTime, 
				startDate, endDate,
				user2);
		// 6. Generate bill for the created reservation
		Bill bill = new Bill();
		bill.generateBill(reservation);
		// 7. Pay bill for the generated reservation
		Payment payment = new Payment();
		boolean isPaymentSuccess = payment.makePayment(bill);
		if(isPaymentSuccess){
			bill.markBillPaid(bill);
			// print the receipt
			// Mark the reservation for the vehicle in its array
			// to change its availability
			vehicle.reservations.add(reservation);
		}
		// 8. Mark the reservation as ongoing, cancelled and completed accordingly
		reservation.completeReservation(reservation);
		
	}
}
