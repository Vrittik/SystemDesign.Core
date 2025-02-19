package systemDesign.Core.VendingMachine;

public class ItemShelf {
	public Item item;
	public int quantity;
	public String code;
	
	public ItemShelf(Item item, int quantity, String code) {
		this.item = item;
		this.quantity = quantity;
		this.code = code;
	}
}
