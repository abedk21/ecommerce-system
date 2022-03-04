package code;

import java.util.*;

public class Retailer extends User {

	public String companyName;
	public static ArrayList<Product> products;
	public ArrayList<Refund> refundRequests;

	public Retailer(String firstName, String lastName, String email, String phoneNumber, String username,
			String password, String companyName) {
		super(firstName, lastName, email, phoneNumber, username, password);
		this.companyName = companyName;
	}
	
	public void addProduct(String name, float price, int count, String description, Category category) {
		products.add(new Product(name, price, count, description, category));
	}
	
	public void editProduct(Product p, String name, float price, int count, String description, Category category) {
		p.edit(name, price, count, description, category);
	}
	
	public void removeProduct(Product p) {
		if(products.remove(p)) {
			p.category.removeProduct(p);
			System.out.println("Product successfully removed");
		} else{
			System.out.println("Product cannot be removed");
		};
	}

}
