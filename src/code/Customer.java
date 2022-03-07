package code;

import java.util.*;

public class Customer extends User {

	public Address address;
	public Cart cart = new Cart(this);
	public ArrayList<Order> orders = new ArrayList<Order>();
	public String paymentMethod;
	public String paymentInfo;

	public Customer(String firstName, String lastName, String email, String phoneNumber, String username,
			String password, Address address) {
		super(firstName, lastName, email, phoneNumber, username, password);
		this.address = address;
	}

}
