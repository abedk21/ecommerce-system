package code;


public abstract class User {
	public int id;
	public String firstName;
	public String lastName;
	public String email;
	public int phoneNumber;
	public String username;
	private String password;

	public User(int id, String firstName, String lastName, String email, int phoneNumber, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}
}

