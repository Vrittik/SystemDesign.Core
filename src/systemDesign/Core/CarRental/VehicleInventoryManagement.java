package systemDesign.Core.CarRental;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class VehicleInventoryManagement {
	
	public List<Vehicle> getVehicles(List<Vehicle> vehicles, VehicleType vehicleType,
			LocalTime startTime, LocalTime endTime,
			LocalDate startDate, LocalDate endDate)
	{
		// implement logic that filters available vehicles based on provided
		// startTime and endTime
		// if in reservations list of vehicle, there exists a reservation with
		// the timings clashing between an already existing start date, end date and start time, end time, then don't 
		// include that vehicle in the response
		List<Vehicle> res = vehicles.stream().
				filter(vehicle -> vehicle.vehicleStatus == Status.AVAILABLE
				&& vehicle.vehicleType == vehicleType).toList();
		return res;
	}
}
