package code;

import java.util.*;

public class Customer extends User {

	public String address;
	public Cart cart = new Cart();
	public Checkout checkout;
	public ArrayList<Order> orders;

	public Customer(int id, String firstName, String lastName, String email, int phoneNumber, String username,
			String password, String address) {
		super(id, firstName, lastName, email, phoneNumber, username, password);
		this.address = address;
	}
	
	public void addToCart(Product p) {
		cart.add(p);
	}
	
	public void removeFromCart(Product p) {
		cart.remove(p);
	}
	
	public void proceedToCheckout() {
		checkout = cart.proceedToCheckout();
	}
	
	public void cancelCheckout() {
		for(int i = 0; i < checkout.products.size(); i++) {
			cart.add(checkout.products.get(i));
		}
		checkout = null;
	}
	
	public void makePayment() {
		orders.add(checkout.makePayment());
		checkout = null;
	}
	
	public void addReview(int rating, String feedback, Product p) {
		Review review = new Review(rating, feedback, p);
		p.addReview(review);
	}

}
