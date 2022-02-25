package code;

public class Retailer extends User {

	public String companyName;

	public Retailer(int id, String firstName, String lastName, String email, int phoneNumber, String username,
			String password, String companyName) {
		super(id, firstName, lastName, email, phoneNumber, username, password);
		this.companyName = companyName;
	}

}
