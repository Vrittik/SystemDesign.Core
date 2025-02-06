package systemDesign.Core.NullObjectPattern;

public class Car extends Vehicle{
	
	@Override
	public int getFuelCapacity()
	{
		return 40;
	}
	
	@Override
	public int getEngineHorsePower() {
		return 123;
	}
	
}
