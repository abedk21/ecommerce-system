package code;

import java.util.*;

public class Cart {
	
	public ArrayList<CartItem> cartItems;
	public Checkout checkout;
	public Customer customer;
	public float totalPrice;
	public int totalCount;

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
		calculateTotalPrice(); //update total price
		totalCount++;
	}
	
//	14. When a cart item is removed from cart, its price will be subtracted from the cart’s total price.
//	Context Cart::removeFromCart(c :CartItem, countToBeRemoved :int)
//	pre: self.CartItem -> includes(c)
//	post: c.count = c.count@pre - countToBeRemoved
//		totalPrice = totalPrice@pre - c.Product.price * countToBeRemoved

	public void removeFromCart(CartItem c, int count) {
		for(int i = 0; i < cartItems.size(); i++) {
			if(cartItems.get(i) == c) {
				if(cartItems.get(i).count == 1) {
					cartItems.remove(i);
				} else {
					cartItems.get(i).count-= count;
				}
				calculateTotalPrice(); //update total price
				return;
			}
		}
	}
	
	private void calculateTotalPrice() {
		float totalPrice = 0;
		for (int i = 0; i < cartItems.size(); i++) { 
			totalPrice += cartItems.get(i).p.price * cartItems.get(i).count;		
	      }
		this.totalPrice = totalPrice;
	}
	
	public void proceedToCheckout() throws Exception {
		
//		6. The customer won’t be able to proceed to checkout if the cart is empty.
//		Context cart::proceedToCheckout(c :Checkout)
//		Pre: self.checkout -> excludes(c) AND self.CartItem -> isnotEmpty()
//		Post: self.checkout -> includes(c)
		
		if(cartItems.size() == 0) {
			throw new Exception("Can't proceed to checkout. The cart is empty");
		}
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
