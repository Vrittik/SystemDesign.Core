package systemDesign.Core.StrategyDesignPattern;

public class OffroadVehicle extends Vehicle {
	public OffroadVehicle()
	{
		super(new SportsDriveStrategy());
	}
	@Override
	public void getVehicleName() {
		System.out.print("Offroad car");
	}
}
