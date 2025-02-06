package systemDesign.Core.NullObjectPattern;

public class VehicleFactory {
	public static Vehicle GetVehicle(String type)
	{
		if(type.toLowerCase() == "car")
		{
			return new Car();
		}
		return new NullVehicle();
	}
}
