package code;

public abstract class Transaction {
	
	public static int transactionId;
	public String paymentMethod;
	private String paymentInfo;
	public String status;
	public float amount;

	public Transaction(String paymentMethod, String paymentInfo, float amount) {
		super();
		Payment.transactionId++;
		this.paymentMethod = paymentMethod;
		this.setPaymentInfo(paymentInfo);
		this.amount = amount;
	}
	
	public boolean verify(float finalPrice) {
		if(finalPrice != amount) {
			return false;
		}
		
		if(status != "Approved") {
			return false;
		}
		
		return true;
	}
	
	public void updateStatus(String status) {
		this.status = status;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}
