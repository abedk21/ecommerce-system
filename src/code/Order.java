package code;

import java.time.LocalDateTime;
import java.util.*;

public class Order {
	
	public LocalDateTime dateOfPurchase;
	public ArrayList<PurchasedItem> purchasedItems;
	private static int counter;
	public int receiptNumber;
	public Delivery delivery;
	public Payment payment;

	public Order(Payment payment, Address address) {
		super();
		//this.id = id;
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		this.dateOfPurchase = now;
		
//		5. Two  orders can not have the same receipt number.
//		Context order
//		Inv: allInstances()->forAll(o1,o2 :Order|o1<>o2 implies o1.receiptNumber<>o2.receiptNumber)
		
		Order.counter++;
		this.receiptNumber = counter;
		this.payment = payment;
		delivery = new Delivery(address);
	}
	
	public void track() {
		System.out.println(delivery);
	}
	
//	11. The delivery should be cancelled when it doesn’t arrive on time.
//	Context Delivery
//	inv: self.status = “Cancelled” implies ( (Day(today) - Day(dateOfArrival)) > 0 AND self.status <> “Arrived”)
	
	public void cancel() throws Exception {
		if(LocalDateTime.now().compareTo(this.delivery.dateOfArrival) > 0 && this.delivery.status != "Arrived") {
			delivery.status = "Cancelled";
			System.out.println("Your order has been cancelled.");
		}
		else {
			throw new Exception("Order can't be cancelled at this time.");
		}
		
	}
	
	public String toString() {
		String order = "Order Receipt: [Receipt Number: " + receiptNumber + " ,Purchased Items: [";
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
