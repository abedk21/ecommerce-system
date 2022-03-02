package code;

import java.time.*;
//import java.time.format.DateTimeFormatter;
import java.util.*;

public class Checkout {
	
	public float finalPrice;
	public float deliveryCharge = 5;
	public float taxRate = (float) 1.15;
	public ArrayList<CartItem> cartItems;
	public float totalPrice;

	public Checkout(ArrayList<CartItem> cartItems, float totalPrice) {
		super();
		this.cartItems = new ArrayList<CartItem>(cartItems);
		this.totalPrice = totalPrice;
		this.finalPrice = totalPrice*taxRate + deliveryCharge;
	}
	
	public Order makePayment(Payment payment) throws Exception{
		if(payment.verify(finalPrice)) {  
			ArrayList<PurchasedItem> purchasedItems = new ArrayList<PurchasedItem>();
			for(int i = 0; i < cartItems.size(); i++) {
				cartItems.get(i).p.count -= cartItems.get(i).count;
				purchasedItems.add(new PurchasedItem(cartItems.get(i)));
			}
			Order order = new Order(purchasedItems, payment);
			return order;
		}
		throw new Exception("Payment Failed");
	}
	
}
