package code;

public abstract class Transaction {
	
	public static int transactionId;
	public String paymentMethod;
	private String paymentInfo;
	public String status;
	public static String tempStatus;
	public float amount;

	public Transaction(String paymentMethod, String paymentInfo, float amount) {
		super();
		Payment.transactionId++;
		this.paymentMethod = paymentMethod;
		this.setPaymentInfo(paymentInfo);
		this.amount = amount;
		this.status = tempStatus;
	}
	
	public Transaction(float amount) {
		Payment.transactionId++;
		this.amount = amount;
	}

	public boolean verify(float finalPrice) {
		if(finalPrice != amount) {
			this.status = "Failed";
			return false;
		}
		
		if(status != "Approved") {
			return false;
		}
		
		return true;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
