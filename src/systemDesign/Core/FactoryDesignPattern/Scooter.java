package systemDesign.Core.FactoryDesignPattern;

public class Scooter implements IVehicle{

	@Override
	public int engineCapacity() {
		return 300;
	}

	@Override
	public int fuelCapacity() {
		return 12;
	}
	
}
