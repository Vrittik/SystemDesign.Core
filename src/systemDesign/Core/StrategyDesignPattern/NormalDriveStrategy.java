package systemDesign.Core.StrategyDesignPattern;

public class NormalDriveStrategy implements IDriveStrategy {
	@Override
	public void drive() {
		System.out.println("Normal drive");
	}
}
