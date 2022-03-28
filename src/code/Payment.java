package code;

public class Payment extends Transaction {
	
	public states state;
	public static boolean bankApproved;
	
	enum states {
		PROCESSING,
		VERIFIED,
		CANCELLED,
		FAILED,
		SUCCESS
	}
	
	public Payment(String paymentMethod, String paymentInfo, float amount) {
		super(paymentMethod, paymentInfo, amount);
		state = states.PROCESSING;
	}

	public void verify(float finalPrice) {
		if(amount == finalPrice) {
			state = states.VERIFIED;
		}
		else {
			state = states.FAILED;
		}
		
	}
	
	public void verifyBank() throws Exception{
		if(state != states.VERIFIED) {
			throw new Exception("Payment isn't verified");
		}
		
		if(bankApproved) {
			state = states.SUCCESS;
		}
		else {
			state = states.FAILED;
		}
	}
	
	public boolean check() {
		if(state != states.SUCCESS) {
			return false;
		}
		
		return true;
	}
	
	public void tryAgain() throws Exception{
		if(state != states.FAILED) {
			throw new Exception("Can't try again at this time.");
		}
		
		state = states.PROCESSING;
	}
	
	public void cancel() throws Exception{
		if(state != states.FAILED || state != states.VERIFIED) {
			throw new Exception("Can't cancel payment at this time.");
		}
		
		state = states.CANCELLED;
	}
	
}
