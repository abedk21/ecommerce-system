package code;

import java.util.*;

public class Cart {
	
	public ArrayList<CartItem> cartItems;
	public Checkout checkout;
	public Customer customer;
	public float totalPrice;

	public Cart(Customer customer) {
		super();
		this.cartItems = new ArrayList<CartItem>();
		this.totalPrice = 0;
		this.customer = customer;
	}
	
	public void add(Product p) {
		for(int i = 0; i < cartItems.size(); i++) {
			if(cartItems.get(i).p == p) {
				cartItems.get(i).count++;
				calculateTotalPrice();
				return;
			}
		}
		cartItems.add(new CartItem(p, this));
		calculateTotalPrice();
	}
	
	public void remove(CartItem c, int count) {
		for(int i = 0; i < cartItems.size(); i++) {
			if(cartItems.get(i) == c) {
				if(cartItems.get(i).count == 1) {
					cartItems.remove(i);
				} else {
					cartItems.get(i).count-= count;
				}
				calculateTotalPrice();
				return;
			}
		}
	}
	
	public void calculateTotalPrice() {
		float totalPrice = 0;
		for (int i = 0; i < cartItems.size(); i++) { 
			totalPrice += cartItems.get(i).p.price * cartItems.get(i).count;		
	      }
		this.totalPrice = totalPrice;
	}
	
	public void proceedToCheckout() {
		checkout = new Checkout(this, totalPrice);
	}
	
	public void empty() {
		cartItems.clear();
		this.totalPrice = 0;
	}
	
	public String toString() {
		String cart = "Cart: [Items: [";
		for (int i = 0; i < cartItems.size(); i++) {
			if (i != 0) {
				cart += ", ";
			}
			cart += cartItems.get(i);
	      }
		cart += "]" +", Total Price: $" + totalPrice + "]";
		return cart;
	}
}
