package code;


public abstract class User {
		
	public static int id;
	public String firstName;
	public String lastName;
	public String email;
	public String phoneNumber;
	public String username;
	private String password;

	public User(String firstName, String lastName, String email, String phoneNumber, String username, String password) {
		super();
		User.id++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.setPassword(password);
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

