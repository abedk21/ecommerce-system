package code;

import java.util.*;

public class Cart {
	
	public ArrayList<CartItem> cartItems;
	public float totalPrice;

	public Cart() {
		super();
		this.cartItems = new ArrayList<CartItem>();
		this.totalPrice = 0;
	}
	
	public void add(Product p) {
		for(int i = 0; i < cartItems.size(); i++) {
			if(cartItems.get(i).p == p) {
				cartItems.get(i).count++;
				calculateTotalPrice();
				return;
			}
		}
		cartItems.add(new CartItem(p));
		calculateTotalPrice();
	}
	
	public void remove(CartItem c) {
		for(int i = 0; i < cartItems.size(); i++) {
			if(cartItems.get(i) == c) {
				if(cartItems.get(i).count == 1) {
					cartItems.remove(i);
				} else {
					cartItems.get(i).count--;
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
	
	public Checkout proceedToCheckout() {
		Checkout checkout = new Checkout(cartItems, totalPrice);
		return checkout;
	}
	
	public void empty() {
		cartItems.clear();
		this.totalPrice = 0;
	}
}
