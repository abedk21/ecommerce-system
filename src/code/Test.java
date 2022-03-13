package code;

public class Test {

	public static void main(String[] args) {
		
		Administrator admin = new Administrator();
		
		Retailer retailer1 = new Retailer("John", "Doe", "johndoe@test.com", "15146788976", "john.doe",
			"johndoe123", "John Doe's Shop");
		
		Address address1 = new Address("221B Baker Street", "1234", "London", "United Kingdom");
		
		Address address2 = new Address("Saint Catherine Street", "H3H 289", "Montreal", "Quebec");
		
		Address address3 = new Address("Wall Street", "6812", "New York", "USA");
		
		Customer customer1 = new Customer("Bill", "Jones", "billjones@test.com","15148793267","bill.jones", "billjones123", address1);
		
		Customer customer2 = new Customer("Jimmy", "James", "jimjames@test.com","16753457689","jimj", "jimmyjames789", address2);
		
		Customer customer3 = new Customer("Jane", "Doe", "janedoe@test.com","123456789","jane123", "password567", address3);
		
		admin.addCategories("Appliances", "Cell Phones & Accessories", "Clothing, Shoes and Jewelry", "Computers", "Electronics", "Food", "Health", "Home & Kitchen", "Movies & TV", "Musical Instruments", "Office Products", "Pet Supplies", "Sports & Outdoors", "Tools & Home Improvement", "Toys & Games");
		
		
		retailer1.addProduct("Iphone 14", 1000, 100, "The most innovative phone in the world.", CategoryList.getCategory("Cell Phones & Accessories"));
		retailer1.addProduct("Macbook Pro", 2000, 100, "The most innovative laptop in the world.", CategoryList.getCategory("Electronics"));
		retailer1.addProduct("Shirt", 50, 50, "Large shirts for men.", CategoryList.getCategory("Clothing, Shoes and Jewelry"));
		retailer1.addProduct("Vaccuum Cleaner", 10, 300, "A vaccuum cleaner that cleans your house.", CategoryList.getCategory("Appliances"));
		retailer1.addProduct("Xbox One", 600, 60, "Microsoft gaming console.", CategoryList.getCategory("Electronics"));
		retailer1.addProduct("PS5", 600, 80, "Sony gaming console.", CategoryList.getCategory("Electronics"));
		retailer1.addProduct("Nintendo Switch", 300, 30, "Handheld game console by Nintendo.", CategoryList.getCategory("Electronics"));
		
		CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14").addToCart(customer1.cart, 3);
		System.out.println(CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14"));
		CategoryList.getCategory("Clothing, Shoes and Jewelry").findProduct("Shirt").addToCart(customer1.cart);
		CategoryList.getCategory("Appliances").findProduct("Vaccuum Cleaner").addToCart(customer1.cart);
		
		System.out.println(customer1.cart);
		
		customer1.cart.proceedToCheckout();
		
		System.out.println(customer1.cart.checkout);
		
		customer1.cart.checkout.makePayment("Visa Debit Card", "My visa card", customer1.cart.checkout.finalPrice);
		
		System.out.println(customer1.orders);
		
		System.out.println(customer1.orders.get(0).delivery);
		
		CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14").addReview(4.5, "I really liked this phone!");
		
		System.out.println(CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14"));
	}

}
