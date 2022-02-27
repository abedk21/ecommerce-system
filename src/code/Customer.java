package code;

public class Customer extends User {

	public String address;
	public Cart cart = new Cart();

	public Customer(int id, String firstName, String lastName, String email, int phoneNumber, String username,
			String password, String address) {
		super(id, firstName, lastName, email, phoneNumber, username, password);
		this.address = address;
	}

}
