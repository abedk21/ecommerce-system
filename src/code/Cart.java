package code;

import java.util.*;

public class Cart {
	
	public ArrayList<Product> products;
	public int totalNumberOfProducts;
	public float totalPrice;

	public Cart() {
		super();
		this.products = new ArrayList<Product>();
		this.totalNumberOfProducts = 0;
		this.totalPrice = 0;
	}
	
	public void add(Product p) {
		this.products.add(p);
		this.totalNumberOfProducts = products.size();
		calculateTotalPrice();
	}
	
	public void remove(Product p) {
		this.products.remove(p);
		this.totalNumberOfProducts = products.size();
		calculateTotalPrice();
	}
	
	public void calculateTotalPrice() {
		float totalPrice = 0;
		for (int i = 0; i < products.size(); i++) { 
			totalPrice += products.get(i).price;		
	      }
		this.totalPrice = totalPrice;
	}
	
	public Checkout proceedToCheckout() {
		return new Checkout(products, totalNumberOfProducts, totalPrice);
	}
}
