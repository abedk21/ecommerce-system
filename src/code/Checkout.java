package code;

import java.util.ArrayList;

public class Checkout {
	
	public float finalPrice;
	public float deliveryCharge = 5;
	public float taxRate = (float) 0.15;
	public ArrayList<Product> products;
	public int totalNumberOfProducts;
	public float totalPrice;

	public Checkout(ArrayList<Product> products, int totalNumberOfProducts, float totalPrice) {
		super();
		this.products = products;
		this.totalNumberOfProducts = totalNumberOfProducts;
		this.totalPrice = totalPrice;
		this.finalPrice = totalPrice + totalPrice*taxRate + deliveryCharge;
	}
}
