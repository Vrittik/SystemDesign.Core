package systemDesign.Core.CarRental;

import java.util.List;

public class Vehicle {
	public int vehicleId;
	public Status vehicleStatus;
	public VehicleType vehicleType;
	public int vehicleName;
	public String vehicleColor;
	public double perDayAmount;
	public byte[] vehicleImage;
	public boolean isVehicleAvailable; // defines whether the vehicle is available or engaged
	public List<Reservation> reservations;
	public Store store;                  
}
