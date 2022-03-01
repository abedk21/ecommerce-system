package code;

import java.util.*;

public class Retailer extends User {

	public String companyName;
	public ArrayList<Product> products;

	public Retailer(int id, String firstName, String lastName, String email, int phoneNumber, String username,
			String password, String companyName) {
		super(id, firstName, lastName, email, phoneNumber, username, password);
		this.companyName = companyName;
	}
	
	public void addProduct(int id, String name, float price, int count, String description, Category category) {
		products.add(new Product(id, name, price, count, description, category));
	}
	
	public void addCount(Product p, int count) {
		p.count += count;
	}
	
	public void subCount(Product p, int count) {
		p.count -= count;
	}
	
	public void editProduct(Product p, int id, String name, float price, int count, String description, Category category) {
		p.edit(id, name, price, count, description, category);
	}
	
	public void removeProduct(Product p) {
		if(products.remove(p)) {
			System.out.println("Product successfully removed");
		} else{
			System.out.println("Product cannot be removed");
		};
	}

}
