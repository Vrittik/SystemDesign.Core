package systemDesign.Core.AbstractFactoryPattern;

public interface IVehicleFactory {
	IVehicle getVehicle(String type);
}
