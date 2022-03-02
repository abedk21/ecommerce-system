package code;

public class Refund extends Transaction {

	public String reason;
	public ReturnItem returnItem;

	public Refund(ReturnItem returnItem, String paymentMethod, String paymentInfo, String reason) {
		super(paymentMethod, paymentInfo, returnItem.amount);
		this.reason = reason;
		this.status = "Requested";
		this.returnItem = returnItem;
	}
	
}
