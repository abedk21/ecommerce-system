package code;

import java.util.*;

public class Cart {
	
	public ArrayList<CartItem> cartItems;
	public Customer customer;
	public Payment payment;
	public float totalPrice;
	public static float taxRate = 5;
	public float deliveryCharge;
	public float finalPrice;
	public int totalCount;
	public states state;
	public states prevState;
	
	//This is where the cart class state diagram is implemented. The following are the states.
	enum states {
		EMPTY,
		NOTEMPTY,
		FULL,
		CHECKOUT,
		PAYING
	}

	public Cart(Customer customer) {
		super();
		this.cartItems = new ArrayList<CartItem>();
		this.totalPrice = 0;
		this.customer = customer;
		this.state = states.EMPTY;
	}
	
	//The methods addToCart(), removeFromCart(), empty(), proceedToCheckout(), cancelCheckout(), makePayment() are the events of the state diagram that will cause the transitions.
	
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
//		Context cart
//		Inv: allInstances() -> forAll(c: Cart | c.state = "Checkout" implies c.CartItem -> isnotEmpty())
		
		if(cartItems.size() == 0) {
			throw new Exception("Can't proceed to checkout. The cart is empty");
		}
		prevState = state;
		state = states.CHECKOUT;
	}
	
	public void cancelCheckout() {
		state = prevState;
	}
	
	public void makePayment(String paymentMethod, String paymentInfo) {
		
		float finalPrice = totalPrice* (taxRate/100 + 1) + calculateDeliveryCharge();
		
		payment = new Payment(paymentMethod, paymentInfo, finalPrice, this);
		
	}
	
	public void empty() {
		cartItems.clear();
		this.totalPrice = 0;
		this.totalCount = 0;
		this.state = states.EMPTY;
	}
	
//	15. If the total price in the cart is less than $50, then there is a $5 delivery charge.
//	Context Cart
//	inv: self.deliveryCharge = if(totalPrice < 50) then 5
//	else 0
//	endif

	private float calculateDeliveryCharge() {
		if(totalPrice <= 50) {
			return 5;
		}
		return 0;
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
