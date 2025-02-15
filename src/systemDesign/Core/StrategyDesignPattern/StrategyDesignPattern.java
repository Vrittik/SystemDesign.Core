package systemDesign.Core.StrategyDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class StrategyDesignPattern {
	public static void main(String[] args)
	{
		Vehicle electricCar = new ElectricVehicle();
		Vehicle sportsCar = new SportsVehicle();
		Vehicle goodsTruck = new GoodsVehicle();
		Vehicle monsterTruck = new OffroadVehicle();
		
		List<Vehicle> v= new ArrayList<>();
		v.add(electricCar);
		v.add(monsterTruck);
		v.add(goodsTruck);
		v.add(sportsCar);
		
		for(Vehicle vehicle : v)
		{
			vehicle.getVehicleName();
			System.out.print(" ");
			vehicle.drive();
		}
	}
}
