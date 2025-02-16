package systemDesign.Core.AbstractFactoryPattern;

public class VehicleAbstractFactory {
	public IVehicleFactory getVehicleFactory(String type)
	{
		type = type.toLowerCase();
		switch(type) {
			case "luxury":
				return new LuxuryVehicleFactory();
			case "ordinary":
				return new OrdinaryVehicleFactory();
			default:
				return null;
		}
	}
}
