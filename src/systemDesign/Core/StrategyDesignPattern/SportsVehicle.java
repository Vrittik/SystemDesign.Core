package systemDesign.Core.StrategyDesignPattern;

public class SportsVehicle extends Vehicle {
	public SportsVehicle() {
		super(new SportsDriveStrategy());
	}
	@Override
	public void getVehicleName() {
		System.out.print("Sports car");
	}
}
