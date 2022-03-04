package code;

import java.time.LocalDateTime;

public class Refund extends Transaction {

	public String reason;
	public PurchasedItem purchasedItem;
	public int daysLimit = 30;
	public int processingDays = 7;
	public LocalDateTime dateRequested;

	public Refund(PurchasedItem purchasedItem, int count, String paymentMethod, String paymentInfo, String reason) {
		super(paymentMethod, paymentInfo, purchasedItem.amountPaidPerItem * count);
		this.reason = reason;
		this.status = "Requested";
		this.purchasedItem = purchasedItem;
		this.dateRequested = LocalDateTime.now();
	}
	
	public boolean canRequestRefund(LocalDateTime dateOfPurchase) {
		return LocalDateTime.now().compareTo(dateOfPurchase) <= daysLimit;
	}
	
	public boolean canProcessRefund() {
		return LocalDateTime.now().compareTo(dateRequested) <= processingDays;
	}
	
}
