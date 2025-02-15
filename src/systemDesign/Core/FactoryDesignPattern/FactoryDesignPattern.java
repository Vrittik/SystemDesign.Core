package systemDesign.Core.FactoryDesignPattern;

import java.util.*;

public class FactoryDesignPattern {
	public static void main(String[] args) {
		VehicleFactory vehicleFactory = new VehicleFactory();
		IVehicle truck = vehicleFactory.get("truck");
		IVehicle car = vehicleFactory.get("Car");
		IVehicle scooter = vehicleFactory.get("scooter");
		
		List<IVehicle> vehicles = new ArrayList<>();
		vehicles.add(scooter);
		vehicles.add(car);
		vehicles.add(truck);
		
		for(IVehicle vehicle : vehicles)
		{
			System.out.println(vehicle.engineCapacity() + " " + vehicle.fuelCapacity());
		}
	}
}
