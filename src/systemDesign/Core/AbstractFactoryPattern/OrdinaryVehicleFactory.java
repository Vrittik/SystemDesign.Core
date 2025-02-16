package systemDesign.Core.AbstractFactoryPattern;

public class OrdinaryVehicleFactory implements IVehicleFactory{

	@Override
	public IVehicle getVehicle(String type) {
		type = type.toLowerCase();
		if(type.equals("maruti"))
		{
			return new Maruti();
		}
		else if(type.equals("hyundai"))
		{
			return new Hyundai();
		}
		return null;
	}
}
