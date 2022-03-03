package code;

public class Test {

	public static void main(String[] args) {
		
		Administrator admin = new Administrator();
		
		Retailer retailer1 = new Retailer("John", "Doe", "johndoe@test.com", "15146788976", "john.doe",
			"johndoe123", "John Doe's Shop");
		
		Address address = new Address("221B Baker Street", "1234", "London", "United Kingdom");
		
		Customer customer1 = new Customer("Bill", "Jones", "billjones@test.com","15148793267","bill.jones", "billjones123", address);
		
		admin.addCategories("Appliances", "Cell Phones & Accessories", "Clothing, Shoes and Jewelry", "Computers", "Electronics", "Food", "Health", "Home & Kitchen", "Movies & TV", "Musical Instruments", "Office Products", "Pet Supplies", "Sports & Outdoors", "Tools & Home Improvement", "Toys & Games");
		
		
		retailer1.addProduct("Iphone 14", 2000, 100, "The most innovative phone in the world.", admin.getCategory("Electronics"));
	}

}
