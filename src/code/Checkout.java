package code;

import java.time.*;
//import java.time.format.DateTimeFormatter;
import java.util.*;

public class Checkout {
	
	public float finalPrice;
	public float deliveryCharge = 5;
	public float taxRate = (float) 0.15;
	public ArrayList<Product> products;
	public int totalNumberOfProducts;
	public float totalPrice;

	public Checkout(ArrayList<Product> products, int totalNumberOfProducts, float totalPrice) {
		super();
		this.products = new ArrayList<Product>(products);
		this.totalNumberOfProducts = totalNumberOfProducts;
		this.totalPrice = totalPrice;
		this.finalPrice = totalPrice + totalPrice*taxRate + deliveryCharge;
	}
	
	public Order makePayment() {
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		Order order = new Order(now,products);
		for(int i = 0; i < products.size(); i++) {
			products.get(i).count--;
		}
		return order;
	}
	
}
