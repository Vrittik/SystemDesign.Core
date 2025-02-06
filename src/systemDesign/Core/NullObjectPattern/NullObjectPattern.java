package systemDesign.Core.NullObjectPattern;

public class NullObjectPattern {
	public static void main(String[] args)
	{
//		Vehicle car = null;
//		// null pointer  exception
//		System.out.println(car.getEngineHorsePower());
//		// need to write if(car != null), has be to be done everywhere
//		// which is not feasible, that's why return NULL object from
//		// factory rather than creating object directly
		
		// null object instead of null
		System.out.println("Default(null) behaviour");
		Vehicle bike = VehicleFactory.GetVehicle("Bike");
		System.out.println(bike.getEngineHorsePower());
		System.out.println(bike.getFuelCapacity());
		
		// actual object
		System.out.println("actual behaviour");
		Vehicle car = VehicleFactory.GetVehicle("car");
		System.out.println(car.getEngineHorsePower());
		System.out.println(car.getFuelCapacity());
		
	}
}
