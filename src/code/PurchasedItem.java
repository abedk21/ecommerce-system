package code;

import java.time.LocalDateTime;

public class PurchasedItem {
	
	public float amountPaidPerItem;
	public float taxRate = (float) 1.15;
	public LocalDateTime dateOfPurchase;
	public Product p;
	public Order order;
	public int count;

	public PurchasedItem(CartItem c, Order order) {
		super();
		this.order = order;
		this.p = c.p;
		this.amountPaidPerItem = p.price*taxRate;
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		this.dateOfPurchase = now;
		this.count = c.count;
	}
	
//	3. The customer can initiate the refund process for the product only after receiving it or if the delivery hasn’t arrived on time. The customer can request a refund within 30 days of the product purchase after arrival.
//
//	Context purchased item::requestRefund(r :Refund)
//	pre: self.Refund -> excludes(r)
//	(self.order.delivery.status=”arrived” AND (Day(today) – Day(self.dateOfPurchase)) < 30) OR ( (Day(today) - Day(self.Order.Delivery.dateOfArrival)) > 0)
//	post: self.Refund -> includes(r) AND r.status = “Requested”
	
	public void requestRefund(int count, String reason) throws Exception {
		if(canRequestRefund()) {
			throw new Exception("You can't request a refund.");
		}
		p.retailer.refundRequests.add(new Refund(this, count, reason));
	}
	
	private boolean canRequestRefund() {
		if((order.delivery.status == "Arrived" && LocalDateTime.now().compareTo(order.delivery.dateOfArrival) <= Refund.daysLimit) || order.delivery.status == "Cancelled") {
			return true;
		}
		return false;
	}

	public String toString() {
		return String.format("[Name: %s, Price After Tax: $%.2f, Count: %d]", p.name, amountPaidPerItem, count);
	}

}
