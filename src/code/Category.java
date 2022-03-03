package code;

import java.util.*;

public class Category {
	
	public String name;
	public ArrayList<Product> products = new ArrayList<Product>();

	public Category(String name) {
		super();
		this.name = name;
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public void removeProduct(Product p) {
		products.remove(p);
	}
}
