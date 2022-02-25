package code;

public class Payment {
	
	public int transactionId;
	public String paymentMethod;
	private String paymentInfo;
	public String status;
	public float amount;

	public Payment(int transactionId, String paymentMethod, String paymentInfo, String status, float amount) {
		super();
		this.transactionId = transactionId;
		this.paymentMethod = paymentMethod;
		this.paymentInfo = paymentInfo;
		this.status = status;
		this.amount = amount;
	}
}
