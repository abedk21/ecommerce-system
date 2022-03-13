package code;

import java.util.*;

public class Retailer extends User {

	public String companyName;
	public static ArrayList<Product> products = new ArrayList<Product>();
	public ArrayList<Refund> refundRequests;

	public Retailer(String firstName, String lastName, String email, String phoneNumber, String username,
			String password, String companyName) {
		super(firstName, lastName, email, phoneNumber, username, password);
		this.companyName = companyName;
	}
	
//	2. The retailer cannot add the same product again to avoid redundancy.
//	Context Retailer::addProduct(P:product)
//	pre: self.Product->excludes(P)
//	post: self.Product->includes(P)

	
	public void addProduct(String name, float price, int count, String description, Category category) throws Exception {
		if(checkProduct(name)) {
			throw new Exception("Product already exists.");
		}
		products.add(new Product(name, price, count, description, category, this));
	}
	
	private boolean checkProduct(String name) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).name == name) {
				return true;
			}
		}
		return false;
	}

	public void removeProduct(Product p) {
		if(products.remove(p)) {
			p.category.removeProduct(p);
			System.out.println("Product successfully removed");
		} else{
			System.out.println("Product cannot be removed");
		};
	}
	
	public String toString() {
		return String.format("Retailer: [First Name: %s, Last Name: %s, Email: %s, Phone Number: %s, Username: %s, Company Name: %s]", firstName, lastName, email, phoneNumber, username, companyName);
	}

}
