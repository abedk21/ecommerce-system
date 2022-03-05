package code;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
	
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
		delivery = new Delivery();
	}
	
	public void track() {
		System.out.println(delivery);
	}
	
	public void cancel() {
		delivery.status = "Cancelled";
		System.out.println("Your order has been cancelled.");
	}
	
	public String toString() {
		String order = "Order Receipt: [Purchased Items: [";
		for (int i = 0; i < purchasedItems.size(); i++) {
			if (i != 0) {
				order += ", ";
			}
			order += purchasedItems.get(i);
	      }
		order += "]" +", Total Amount Paid: $" + payment.amount + ", Date of Purchase: " + dateOfPurchase +"]";
		return order;
	}
	
}
