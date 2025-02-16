package systemDesign.Core.AbstractFactoryPattern;

public class LuxuryVehicleFactory implements IVehicleFactory{

	@Override
	public IVehicle getVehicle(String type) {
		type = type.toLowerCase();
		if(type.equals("bmw"))
		{
			return new Bmw();
		}
		else if(type.equals("mercedes"))
		{
			return new Mercedes();
		}
		return null;
	}
}
