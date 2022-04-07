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
	
	public void addAddress(Address address){
		this.address = address;
	}
	
	public void editAddress(String street, String postalCode, String city, String country){
		address.street = street;
		address.postalCode = postalCode;
		address.city = city;
		address.country = country;
	}
	
	public void addPaymentDetails(String paymentMethod, String paymentInfo) {
		this.paymentMethod = paymentMethod;
		this.paymentInfo = paymentInfo;
	}
	
	public String toString() {
		return String.format("Customer: [First Name: %s, Last Name: %s, Email: %s, Phone Number: %s, Username: %s, %s]", firstName, lastName, email, phoneNumber, username, address);
	}
}
