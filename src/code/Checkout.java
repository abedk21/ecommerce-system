package code;

//import java.time.format.DateTimeFormatter;
import java.util.*;

public class Checkout {
	
	public float finalPrice;
	public float deliveryCharge = 5;
	public float taxRate = 15;
	public ArrayList<CartItem> cartItems;
	public float totalPrice;
	public Cart cart;

	public Checkout(Cart cart, float totalPrice) {
		super();
		this.cartItems = new ArrayList<CartItem>(cart.cartItems);
		this.totalPrice = totalPrice;
		this.finalPrice = totalPrice* (taxRate/100 + 1) + deliveryCharge;
	}
	
	public void makePayment(String paymentMethod, String paymentInfo, float amount) {
		Payment payment = new Payment(paymentMethod, paymentInfo, amount);
		if(payment.verify(finalPrice)) {  
			ArrayList<PurchasedItem> purchasedItems = new ArrayList<PurchasedItem>();
			for(int i = 0; i < cartItems.size(); i++) {
				cartItems.get(i).p.count -= cartItems.get(i).count;
				purchasedItems.add(new PurchasedItem(cartItems.get(i)));
			}
			Order order = new Order(purchasedItems, payment, cart.customer.address);
			cart.customer.orders.add(order);
			cart.empty();
		} else {
			System.out.println("Payment Failed");
		}
	}
	
	public void cancelCheckout() {
		cart.checkout = null;
	}
	
	public String toString() {
		String checkout = "Checkout: [Items: [";
		for (int i = 0; i < cartItems.size(); i++) {
			if (i != 0) {
				checkout += ", ";
			}
			checkout += cartItems.get(i);
	      }
		checkout += "]" +", Total Price: $" + totalPrice + ", Added Tax: " + taxRate + "%, Delivery Charge: $" + deliveryCharge + ", Final Price: $" + finalPrice + "]";
		return checkout;
	}
	
}
