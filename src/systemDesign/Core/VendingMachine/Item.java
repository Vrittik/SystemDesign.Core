package systemDesign.Core.VendingMachine;

public class Item {
	public ItemName itemName;
	public int cost;
	
	public Item(ItemName name, int cost)
	{
		itemName = name;
		this.cost = cost;
	}
}
