package code;

public class Retailer extends User {

	public String companyName;

	public Retailer(int id, String firstName, String lastName, String email, int phoneNumber, String username,
			String password, String companyName) {
		super(id, firstName, lastName, email, phoneNumber, username, password);
		this.companyName = companyName;
	}
	
	public Product addProduct(int id, String name, float price, int count, String description, String category, float averageRating) {
		return new Product(id, name, price, count, description, category, averageRating);
	}
	
	public void editProduct(Product p, int id, String name, float price, int count, String description, String category, float averageRating) {
		p.edit(id, name, price, count, description, category, averageRating);
	}

}
