package systemDesign.Core.CarRental;

import java.util.List;

public class CarRentalDomainLogic {
	public List<Store> stores;
	public List<Location> location;
	
	public List<Store> searchStore(Location location)
	{
		// some filtering can be done based on above parameters 
		// store has the location details so filtering can be done
		return stores;
	}
}
