package code;

import java.util.*;

public class Cart {
	
	public ArrayList<CartItem> cartItems;
	public Checkout checkout;
	public Customer customer;
	public float totalPrice;
	public int totalCount;
	public states state;
	public states prevState;
	
	enum states {
		EMPTY,
		NOTEMPTY,
		FULL,
		CHECKOUT
	}

	public Cart(Customer customer) {
		super();
		this.cartItems = new ArrayList<CartItem>();
		this.totalPrice = 0;
		this.customer = customer;
		this.state = states.EMPTY;
	}
	
	public void addToCart(Product p) {
		for(int i = 0; i < cartItems.size(); i++) {
			if(cartItems.get(i).p == p) {
				cartItems.get(i).count++;
				totalCount++;
				calculateTotalPrice();
				return;
			}
		}
		cartItems.add(new CartItem(p, this));
		totalCount++;
		calculateTotalPrice(); //update total price
		if(state == states.EMPTY) {
			state = states.NOTEMPTY;
		}
		
		if(totalCount == 50) {
			state = states.FULL;
		}
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
					totalCount--;
				} else {
					cartItems.get(i).count-= count;
					totalCount-=count;
				}
				calculateTotalPrice(); //update total price
				return;
			}
		}
		
		if(state == states.FULL) {
			state = states.NOTEMPTY;
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
		prevState = state;
		state = states.CHECKOUT;
	}
	
	public void empty() {
		cartItems.clear();
		this.totalPrice = 0;
		this.totalCount = 0;
		this.state = states.EMPTY;
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
