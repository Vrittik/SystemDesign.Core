package systemDesign.Core.CarRental;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Store {
	public int storeId;
	public String storeName;
	public Location location;
	public List<Vehicle> vehicles;
	
	public List<Vehicle> findVehicles(VehicleType vehicleType, 
			LocalTime startTime, LocalTime endTime,
			LocalDate startDate, LocalDate endDate)
	{
	     VehicleInventoryManagement inventoryManagement = new VehicleInventoryManagement();
	     return inventoryManagement.getVehicles(vehicles, 
	    		 vehicleType, startTime, endTime, startDate, endDate);
	}
}
