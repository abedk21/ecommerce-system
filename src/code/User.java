package code;

import java.util.ArrayList;

public abstract class User {
		
	private static int counter;
	public int id;
	public String firstName;
	public String lastName;
	public String email;
	public String phoneNumber;
	public String username;
	private String password;
	public static ArrayList<User> users = new ArrayList<User>();

	public User(String firstName, String lastName, String email, String phoneNumber, String username, String password) {
		super();
		User.counter++;
		this.id = counter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.setPassword(password);
		users.add(this);
		
	}
	
//	1.Users should have a unique ID, email, and username for authentication.
//	Context User
//	Inv: allInstances()->forAll(u1, u2:User|u1<>u2 implies u1.id<>u2.id AND u1.email<>u2.email AND u1.username<>u2.username)
	
	public static Customer register(String firstName, String lastName, String email, String phoneNumber, String username,
			String password, Address address) throws Exception{
		if(checkEmail(email)) {
			throw new Exception("Email already exists.");
		}
		
		if(checkUsername(username)) {
			throw new Exception("Username already exists.");
		}
		
		Customer c = new Customer(firstName, lastName, email, phoneNumber, username, password, address);
		return c;
	}
	
	public static Retailer register(String firstName, String lastName, String email, String phoneNumber, String username,
			String password, String companyName) throws Exception{
		if(checkEmail(email)) {
			throw new Exception("Email already exists.");
		}
		
		if(checkUsername(username)) {
			throw new Exception("Username already exists.");
		}
		
		Retailer r = new Retailer(firstName, lastName, email, phoneNumber, username, password, companyName);
		return r;
	}
	
	public static boolean checkEmail(String email) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).email == email) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkUsername(String username) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).username == username) {
				return true;
			}
		}
		return false;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

