package systemDesign.Core.AbstractFactoryPattern;

public class AbstractFactoryPattern {
	public static void main(String[] args)
	{
		VehicleAbstractFactory vehicleAbstractFactory = new VehicleAbstractFactory();
		IVehicle mercedes = vehicleAbstractFactory.getVehicleFactory("luxury").getVehicle("mercedes");
		IVehicle maruti = vehicleAbstractFactory.getVehicleFactory("ordinary").getVehicle("maruti");
		
		System.out.println(mercedes.getVehicleName());
		System.out.println(maruti.getVehicleName());
		
		// trying to get invalid vehicles
		IVehicle hyundai = vehicleAbstractFactory.getVehicleFactory("luxury").getVehicle("hyundai");
		IVehicle bmw = vehicleAbstractFactory.getVehicleFactory("ordinary").getVehicle("bmw");
		if(bmw == null && hyundai == null)
		{
			System.out.println("Getting wrong vehicles from wrong factories");
		}
		
	}
}
