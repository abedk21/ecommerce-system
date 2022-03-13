package code;

import java.time.LocalDateTime;

public class Refund extends Transaction {

	public String reason;
	public PurchasedItem purchasedItem;
	public static int daysLimit = 30;
	public LocalDateTime dateRequested;

	public Refund(PurchasedItem purchasedItem, int count, String reason) {
		super(purchasedItem.amountPaidPerItem * count);
		this.reason = reason;
		this.status = "Requested";
		this.purchasedItem = purchasedItem;
		this.dateRequested = LocalDateTime.now();
	}
	
	public void pay(String paymentMethod, String paymentInfo) {
		this.status = "Paid";
		this.paymentMethod = paymentMethod;
		this.setPaymentInfo(paymentInfo);
	}
	
	public void c() {
		this.status = "Cancelled";
	}
	
}
