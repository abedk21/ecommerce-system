package code;

public abstract class Transaction {
	
	public static int transactionId;
	public String paymentMethod;
	private String paymentInfo;
	public String status;
	public static String tempStatus;
	public float amount;

	public Transaction(String paymentMethod, String paymentInfo) {
		super();
		Payment.transactionId++;
		this.paymentMethod = paymentMethod;
		this.setPaymentInfo(paymentInfo);
		this.status = tempStatus;
	}
	
	public Transaction(float amount) {
		Payment.transactionId++;
		this.amount = amount;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
