package code;

import java.util.*;

public class Customer extends User {

	public Address address;
	public Cart cart = new Cart();
	public Checkout checkout;
	public ArrayList<Order> orders;
	public String paymentMethod;
	public String paymentInfo;

	public Customer(String firstName, String lastName, String email, String phoneNumber, String username,
			String password, Address address) {
		super(firstName, lastName, email, phoneNumber, username, password);
		this.address = address;
	}
	
	public void addToCart(Product p) {
		cart.add(p);
	}
	
	public void removeFromCart(CartItem c) {
		cart.remove(c);
	}
	
	public void proceedToCheckout() {
		checkout = cart.proceedToCheckout();
	}
	
	public void cancelCheckout() {
		checkout = null;
	}
	
	public void makePayment(float amount) {
		makePayment(this.paymentMethod, this.paymentInfo, amount);
	}
	
	public void makePayment(String paymentMethod, String paymentInfo, float amount) {
		Payment payment = new Payment(paymentMethod, paymentInfo, amount);
		try {
			orders.add(checkout.makePayment(payment));
			cart.empty();
			this.paymentMethod = paymentMethod;
			this.paymentInfo = paymentInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkout = null;
	}
	
	public void requestRefund(Retailer r, PurchasedItem purchasedItem, int count, String reason) {
		requestRefund(r, purchasedItem, count, reason, this.paymentMethod, this.paymentInfo);
	}
	
	public void requestRefund(Retailer r, PurchasedItem purchasedItem, int count, String reason, String paymentMethod, String paymentInfo) {
		r.refundRequests.add(new Refund(purchasedItem, count, paymentMethod, paymentInfo, reason));
	}
	
	public void addReview(int rating, String feedback, Product p) {
		Review review = new Review(rating, feedback, p);
		p.addReview(review);
	}

}
