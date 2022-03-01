package code;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
	
	//public int id;
	public LocalDateTime dateOfPurchase;
	public ArrayList<Product> purchasedItems;
	public static int receiptNumber = 0;
	public Delivery delivery;
	public Payment payment;

	public Order(LocalDateTime now, ArrayList<Product> purchasedItems, Payment payment) {
		super();
		//this.id = id;
		this.dateOfPurchase = now;
		this.purchasedItems = new ArrayList<Product>(purchasedItems);
		Order.receiptNumber++;
		this.payment = payment;
		delivery = new Delivery(now.plusDays(15),"Shipped");
	}
}
