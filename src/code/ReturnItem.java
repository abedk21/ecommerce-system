package code;

public class ReturnItem {
	
	public PurchasedItem purchasedItem;
	public int count;
	public float amount;
	
	public ReturnItem(PurchasedItem purchasedItem, int count) {
		super();
		this.purchasedItem = purchasedItem;
		this.count = count;
		amount = purchasedItem.amountPaidPerItem * count;
	}
}
