package systemDesign.Core.StrategyDesignPattern;

public class ElectricVehicle extends Vehicle {

	public ElectricVehicle() {
		super(new NormalDriveStrategy());
	}
	@Override
	public void getVehicleName() {
		System.out.print("Electric car");
	}
}
