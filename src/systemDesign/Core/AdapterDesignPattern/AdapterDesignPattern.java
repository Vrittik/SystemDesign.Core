package systemDesign.Core.AdapterDesignPattern;

public class AdapterDesignPattern {
	public static void main(String[] args)
	{
		// Adapter exposing all method which clients understands
		// and perform necessary actions on it like tweaking, cleaning
		// etc
		IWeightMachineAdapter adapter = new WeightMachineAdpater(new WeightMachineForBabies());
		System.out.println(adapter.getWeightInKgs() + "kg as client does not understand pounds.");
	}
}
