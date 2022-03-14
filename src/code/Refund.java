package code;

import java.time.LocalDateTime;

public class Refund extends Transaction {

	public String reason;
	public PurchasedItem purchasedItem;
	public static int daysLimit = 30;
	public LocalDateTime dateRequested;
	public int count;
	public static boolean override;

	public Refund(PurchasedItem purchasedItem, int count, String reason) {
		super(purchasedItem.amountPaidPerItem * count);
		this.reason = reason;
		this.status = "Requested";
		this.purchasedItem = purchasedItem;
		this.dateRequested = LocalDateTime.now();
		this.count = count;
	}
	
	public void pay(String paymentMethod, String paymentInfo, float amount) throws Exception{
		if(amount != this.amount) {
			throw new Exception("Amount is different than the one required.");
		}
		this.status = "Paid";
		this.paymentMethod = paymentMethod;
		this.setPaymentInfo(paymentInfo);
	}
	
	public void cancel() {
		this.status = "Cancelled";
	}
	
	public String toString() {
		return String.format("[Status: %s, Item: %s, Count: %s, Amount: %s, Reason: %s, Date Requested: %s]", status, purchasedItem.p.name, count, amount, reason, dateRequested);
	}
	
}
