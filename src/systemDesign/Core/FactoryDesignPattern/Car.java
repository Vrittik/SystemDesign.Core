package systemDesign.Core.FactoryDesignPattern;

public class Car implements IVehicle{

	@Override
	public int engineCapacity() {
		return 1200;
	}

	@Override
	public int fuelCapacity() {
		return 30;
	}

}
