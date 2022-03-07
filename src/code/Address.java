package code;

public class Address {

	public String street;
	public String postalCode;
	public String city;
	public String country;
	
	public Address(String street, String postalCode, String city, String country) {
		super();
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}
	
	public void change(String street, String postalCode, String city, String country) {
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}
	
	public String toString() {
		return String.format("Address: [Street: %s, Postal Code: %s, City: %s, Country: %s]", street, postalCode, city, country);
	}
}
