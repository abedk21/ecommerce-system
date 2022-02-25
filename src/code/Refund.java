package code;

public class Refund {
	public int transactionId;
	public String paymentMethod;
	private String paymentInfo;
	public String status;
	public float amount;
	public String reason;

	public Refund(int transactionId, String paymentMethod, String paymentInfo, String status, float amount, String reason) {
		super();
		this.transactionId = transactionId;
		this.paymentMethod = paymentMethod;
		this.paymentInfo = paymentInfo;
		this.status = status;
		this.amount = amount;
		this.reason = reason;
	}
}
