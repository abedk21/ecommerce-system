package code;

import java.time.LocalDateTime;

public class PurchasedItem {
	
	public float amountPaidPerItem;
	public float taxRate = (float) 1.15;
	public LocalDateTime dateOfPurchase;
	public Product p;
	public int count;

	public PurchasedItem(CartItem c) {
		super();
		this.p = c.p;
		this.amountPaidPerItem = p.price*taxRate;
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		this.dateOfPurchase = now;
		this.count = c.count;
	}
	
	public String toString() {
		return String.format("[Name: %s, Price After Tax: $%.2f, Count: %d]", p.name, amountPaidPerItem, count);
	}

}
