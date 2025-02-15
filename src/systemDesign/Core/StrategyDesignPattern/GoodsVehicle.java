package systemDesign.Core.StrategyDesignPattern;

public class GoodsVehicle extends Vehicle{
	public GoodsVehicle() {
		super(new NormalDriveStrategy());
	}
	@Override
	public void getVehicleName() {
		System.out.print("Goods truck");
	}
}
