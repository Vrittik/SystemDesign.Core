package systemDesign.Core.FactoryDesignPattern;

public class Truck implements IVehicle{

	@Override
	public int engineCapacity() {
		return 6000;
	}

	@Override
	public int fuelCapacity() {
		return 100;
	}

}
