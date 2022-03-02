package code;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
	
	//public int id;
	public LocalDateTime dateOfPurchase;
	public ArrayList<PurchasedItem> purchasedItems;
	public static int receiptNumber = 0;
	public Delivery delivery;
	public Payment payment;

	public Order(ArrayList<PurchasedItem> purchasedItems, Payment payment) {
		super();
		//this.id = id;
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		this.dateOfPurchase = now;
		this.purchasedItems = purchasedItems;
		Order.receiptNumber++;
		this.payment = payment;
		delivery = new Delivery(now.plusDays(15),"Shipped");
	}
}
