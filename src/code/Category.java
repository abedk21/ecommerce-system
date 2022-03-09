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
	
	public void edit(String name) {
		this.name = name;
	}

	public Product findProduct(String name) {
		for(int i = 0; i <= products.size(); i++) {
			if(products.get(i).name == name) {
				return products.get(i);
			}
		}
		return null;
	}
}
