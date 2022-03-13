package code;

//import java.time.format.DateTimeFormatter;
import java.util.*;

public class Checkout {
	
	public float finalPrice;
	public float deliveryCharge;
	public float taxRate = 15;
	public float totalPrice;
	public Cart cart;

	public Checkout(Cart cart, float totalPrice) {
		super();
		this.cart = cart;
		this.totalPrice = totalPrice;
		deliveryCharge = calculateDeliveryCharge();
		this.finalPrice = totalPrice* (taxRate/100 + 1) + deliveryCharge;
	}
	

//	15. If the total price in the checkout is less than $50, then there is a $5 delivery charge.
//	Context Checkout
//	inv: self..deliveryCharge = if(totalPrice < 50) then 5
//	else 0
//	endif

	private float calculateDeliveryCharge() {
		if(totalPrice <= 50) {
			return 5;
		}
		return 0;
	}
	
//	10. After the customer makes a payment and if payment is approved, their cart will be empty and the count of the purchased items will be subtracted from the count of the product.
//	Context Checkout::makePayment(p :Payment)
//	pre: self.Payment -> excludes(p) AND
//		self.Cart.CartItems -> isNotEmpty()
//	post: 
//	self.Payment -> includes(p) AND
//	p.status = “Approved” implies self.Cart.CartItems -> isEmpty() AND self.Cart.Product -> forAll(c :CartItem, p :Product | c.id = p.id implies p.count = p.count@pre - c.count)

	public void makePayment(String paymentMethod, String paymentInfo, float amount) {
		Payment payment = new Payment(paymentMethod, paymentInfo, amount);
		
//		7. An item can only be purchased if the payment is approved
//		Context Payment
//		Inv: self.purchaseditem -> isnotEmpty() implies self.status = “Approved”
		
		// The verify() method will check if the payment has been approved.
		if(payment.verify(finalPrice)) {
			Order order = new Order(payment, cart.customer.address);
			ArrayList<PurchasedItem> purchasedItems = new ArrayList<PurchasedItem>();
			for(int i = 0; i < cart.cartItems.size(); i++) {
				cart.cartItems.get(i).p.count -= cart.cartItems.get(i).count;
				purchasedItems.add(new PurchasedItem(cart.cartItems.get(i), order));
			}
			order.purchasedItems = purchasedItems;
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
		for (int i = 0; i < cart.cartItems.size(); i++) {
			if (i != 0) {
				checkout += ", ";
			}
			checkout += cart.cartItems.get(i);
	      }
		checkout += "]" +", Total Price: $" + totalPrice + ", Added Tax: " + taxRate + "%, Delivery Charge: $" + deliveryCharge + ", Final Price: $" + finalPrice + "]";
		return checkout;
	}
	
}
