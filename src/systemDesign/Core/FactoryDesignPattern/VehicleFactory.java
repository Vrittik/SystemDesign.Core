package systemDesign.Core.FactoryDesignPattern;

public class VehicleFactory {
	public IVehicle get(String type)
	{
		type = type.toLowerCase();
		if(type.equals("scooter"))
		{
			return new Scooter();
		}
		else if(type.equals("car"))
		{
			return new Car();
		}
		else if(type.equals("truck"))
		{
			return new Truck();
		}
		return null;
	}
}
