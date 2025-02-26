package systemDesign.Core.AdapterDesignPattern;

public class WeightMachineAdpater implements IWeightMachineAdapter {
	WeightMachine weightMachine;
	
	public WeightMachineAdpater(WeightMachine weightMachine)
	{
		this.weightMachine = weightMachine;
	}

	@Override
	public float getWeightInKgs() {
		float weight = weightMachine.getWeightInPounds();
		float weightInKg = weight * 0.453592f;
		return weightInKg;
	}

}
