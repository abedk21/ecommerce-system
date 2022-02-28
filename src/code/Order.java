package code;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
	
	//public int id;
	public LocalDateTime dateOfPurchase;
	public ArrayList<Product> purchasedItems;
	public static int receiptNumber = 0;
	public Delivery delivery;

	public Order(LocalDateTime now, ArrayList<Product> purchasedItems) {
		super();
		//this.id = id;
		this.dateOfPurchase = now;
		this.purchasedItems = new ArrayList<Product>(purchasedItems);
		Order.receiptNumber++;
		delivery = new Delivery(now.plusDays(15),"Shipped");
	}
}
