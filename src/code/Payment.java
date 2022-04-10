package code;

import java.util.ArrayList;

public class Payment extends Transaction {
	
	public Cart cart;
	public float finalPrice;
	public float processedAmount; //amount to be verified
	public states state;
	public static boolean bankApproved;
	
	//This is where the payment class state diagram is implemented. The following are the states.
	enum states {
		IDLE,
		PROCESSING,
		VERIFIED,
		CANCELLED,
		FAILED,
		SUCCESS
	}
	
	public Payment(String paymentMethod, String paymentInfo, float finalPrice, Cart cart) {
		super(paymentMethod, paymentInfo);
		state = states.IDLE;
		this.finalPrice = finalPrice;
		this.cart = cart;
	}
	
	//The methods pay(), verifyAmount(), verifyBank(), tryAgain(), cancel() are the events of the state diagram that will cause the transitions.
	
	public void pay(float amount) throws Exception{
		state = states.PROCESSING;
		processedAmount = amount;
	}

	public void verifyAmount() {
		if(processedAmount == finalPrice) {
			state = states.VERIFIED;
			amount = processedAmount;
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
	
	public void tryAgain() throws Exception{
		if(state != states.FAILED) {
			throw new Exception("Can't try again at this time.");
		}
		
		state = states.PROCESSING;
	}
	
	public void cancel() throws Exception{
		if(state != states.FAILED) {
			throw new Exception("Can't cancel payment at this time.");
		}
		
		state = states.CANCELLED;
	}

//	10. After the customer makes a payment and if payment is successful, their cart will be empty, and the count of the purchased items will be subtracted from the count of the product.  
//	Context Payment 
//	Inv: allInstances() -> forAll(p: Payment | p.state = “Success” implies self.CartItems -> isEmpty()) AND self.Cart.Product -> forAll(c :CartItem, p :Product | c.id = p.id implies p.count = p.count@pre - c.count)  
	
	public void completePurchase() {
		if(state == states.SUCCESS) {
//			7. An item can only be purchased if the payment was successful 
//			Context Payment  
//			Inv: self.purchaseditem -> isnotEmpty() implies self.state = “Success”  
			
			Order order = new Order(this, cart.customer.address);
			ArrayList<PurchasedItem> purchasedItems = new ArrayList<PurchasedItem>();
			for(int i = 0; i < cart.cartItems.size(); i++) {
				cart.cartItems.get(i).p.subCount(cart.cartItems.get(i).count);
				purchasedItems.add(new PurchasedItem(cart.cartItems.get(i), order));
			}
			order.purchasedItems = purchasedItems;
			cart.customer.orders.add(order);
			cart.empty();
		} else {
			System.out.println("Can't complete purchase because payment wasn't successful.");
		}
	}
	
}
