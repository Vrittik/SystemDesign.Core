package systemDesign.Core.NullObjectPattern;

public class NullVehicle extends Vehicle{
	
	@Override
	public int getFuelCapacity()
	{
		return 0;
	}
	
	@Override
	public int getEngineHorsePower() {
		return 0;
	}
	
}
