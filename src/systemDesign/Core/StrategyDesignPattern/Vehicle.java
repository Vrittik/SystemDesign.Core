package systemDesign.Core.StrategyDesignPattern;

public class Vehicle {
	private IDriveStrategy driveStrategy;
	
	public Vehicle(IDriveStrategy _driveStrategy)
	{
		driveStrategy = _driveStrategy;
	}
	public void drive() {
		driveStrategy.drive();
	}
	public void getVehicleName() {
		System.out.println("Vehicle name not defined");
	}
}
