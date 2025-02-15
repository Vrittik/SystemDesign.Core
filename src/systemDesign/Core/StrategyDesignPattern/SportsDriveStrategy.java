package systemDesign.Core.StrategyDesignPattern;

public class SportsDriveStrategy implements IDriveStrategy {
	@Override
	public void drive() {
		System.out.println("Sports drive");
	}
}
