package code;

public class Payment {
	
	public static int transactionId;
	public String paymentMethod;
	private String paymentInfo;
	public String status;
	public float amount;

	public Payment(String paymentMethod, String paymentInfo, float amount) {
		super();
		Payment.transactionId++;
		this.paymentMethod = paymentMethod;
		this.paymentInfo = paymentInfo;
		this.amount = amount;
	}
	
	public boolean verify(float finalPrice) {
		if(finalPrice != amount) {
			status = "Rejected";
			return false;
		}
		
		status = "Approved";
		return true;
	}
}
