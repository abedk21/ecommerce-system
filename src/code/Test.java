package code;

public class Test {

	public static void main(String[] args) throws Exception {
		
		//creating an admin
		Administrator admin = new Administrator();
		
		//registering a retailer
		Retailer retailer1 = User.register("John", "Doe", "johndoe@test.com", "15146788976", "john.doe",
			"johndoe123", "John Doe's Shop");
		
		System.out.println(retailer1);
		
		//creating addresses
		Address address1 = new Address("221B Baker Street", "1234", "London", "United Kingdom");
		
		Address address2 = new Address("Saint Catherine Street", "H3H 289", "Montreal", "Quebec");
		
		Address address3 = new Address("Wall Street", "6812", "New York", "USA");
		
		//registering the following customers
		Customer customer1 = User.register("Bill", "Jones", "billjones@test.com","15148793267","bill.jones", "billjones123", address1);
		
		System.out.println(customer1);
		
		Customer customer2 = User.register("Jimmy", "James", "jimjames@test.com","16753457689","jimj", "jimmyjames789", address2);
		
		System.out.println(customer2);
		
		Customer customer3 = User.register("Jane", "Doe", "janedoe@test.com","123456789","jane123", "password567", address3);
		
		System.out.println(customer3);
		
		//Attempting to register a user with an email that already exists. An exception is thrown.		
	    try {
	    	 User.register("Jane", "Doe", "janedoe@test.com","123456789","jane123", "password567", address3);
	      } catch (Exception e) {
	        System.out.println(e);
	      }
	    
	    //Attempting to register a user with a username that already exists. An exception is thrown.
	    try {
	    	 User.register("Jane", "Doe", "janedoe1@test.com","123456789","jane123", "password567", address3);
	      } catch (Exception e) {
	        System.out.println(e);
	      }
		
		admin.addCategories("Appliances", "Cell Phones & Accessories", "Clothing, Shoes and Jewelry", "Computers", "Electronics", "Food", "Health", "Home & Kitchen", "Movies & TV", "Musical Instruments", "Office Products", "Pet Supplies", "Sports & Outdoors", "Tools & Home Improvement", "Toys & Games");
		
		//retailer1 adds the following products
		retailer1.addProduct("Iphone 14", 1000, 100, "The most innovative phone in the world.", CategoryList.getCategory("Cell Phones & Accessories"));
		retailer1.addProduct("Macbook Pro", 2000, 100, "The most innovative laptop in the world.", CategoryList.getCategory("Electronics"));
		retailer1.addProduct("Shirt", 50, 50, "Large shirts for men.", CategoryList.getCategory("Clothing, Shoes and Jewelry"));
		retailer1.addProduct("Socks", 10, 50, "Socks", CategoryList.getCategory("Clothing, Shoes and Jewelry"));
		retailer1.addProduct("Bread", 3, 50, "Bread for eating.", CategoryList.getCategory("Food"));
		retailer1.addProduct("Vaccuum Cleaner", 100, 300, "A vaccuum cleaner that cleans your house.", CategoryList.getCategory("Appliances"));
		retailer1.addProduct("Xbox One", 600, 60, "Microsoft gaming console.", CategoryList.getCategory("Electronics"));
		retailer1.addProduct("PS5", 600, 80, "Sony gaming console.", CategoryList.getCategory("Electronics"));
		retailer1.addProduct("Nintendo Switch", 300, 30, "Handheld game console by Nintendo.", CategoryList.getCategory("Electronics"));
		retailer1.addProduct("Microwave", 100, 50, "Microwaves make preparing a meal quick & easy from heating, defrost to baking.", CategoryList.getCategory("Appliances"));
		retailer1.addProduct("Toaster", 50, 60, "For a quick breakfast or snack, a toaster is your ideal appliance to own for toasting crispy breads, bagels & more.", CategoryList.getCategory("Appliances"));
		
		System.out.println(CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14"));
		
		//Attempting to add a duplicate product. An exception is thrown.
	    try {
	    	retailer1.addProduct("Nintendo Switch", 300, 30, "Handheld game console by Nintendo.", CategoryList.getCategory("Electronics"));
	      } catch (Exception e) {
	        System.out.println(e);
	      }
		
		//Attempting to proceed to checkout with an empty cart. An exception is thrown.		
	    try {
	    	customer1.cart.proceedToCheckout();
	      } catch (Exception e) {
	        System.out.println(e);
	      }
	    
		//Attempting to add a review to a product that is not purchased. An exception is thrown.		
	    try {
	    	CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14").addReview(4.5, "I really liked this phone!", customer1);
	      } catch (Exception e) {
	        System.out.println(e);
	      }
		
	    //customer1 adds the following products to their cart
		CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14").addToCart(customer1.cart, 3);
		CategoryList.getCategory("Clothing, Shoes and Jewelry").findProduct("Shirt").addToCart(customer1.cart);
		CategoryList.getCategory("Appliances").findProduct("Vaccuum Cleaner").addToCart(customer1.cart);
		
	    //customer2 adds the following products to their cart
		CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14").addToCart(customer2.cart, 2);
		CategoryList.getCategory("Clothing, Shoes and Jewelry").findProduct("Shirt").addToCart(customer2.cart, 5);
		CategoryList.getCategory("Appliances").findProduct("Vaccuum Cleaner").addToCart(customer2.cart);
		
	    //customer3 adds the following products to their cart
		CategoryList.getCategory("Clothing, Shoes and Jewelry").findProduct("Socks").addToCart(customer3.cart);
		
		//Attempting to add to the cart more than the actual count of the product. An exception is thrown.		
	    try {
	    	CategoryList.getCategory("Appliances").findProduct("Vaccuum Cleaner").addToCart(customer1.cart, 301);
	      } catch (Exception e) {
	        System.out.println(e);
	      }
	    
		//Attempting to add to the cart more than 5 items of the same product. An exception is thrown.		
	    try {
	    	CategoryList.getCategory("Appliances").findProduct("Vaccuum Cleaner").addToCart(customer1.cart, 6);
	      } catch (Exception e) {
	        System.out.println(e);
	      }
		
		System.out.println(customer1.cart);
		
		//customer1 removes an item from their cart
		CartItem c = customer1.cart.cartItems.get(0);
		customer1.cart.removeFromCart(c, 1);
		
		System.out.println(customer1.cart);
		
		System.out.println(customer2.cart);
		
		System.out.println(customer3.cart);
		
		//customer1 proceeds to checkout
		customer1.cart.proceedToCheckout();
		
		//customer2 proceeds to checkout
		customer2.cart.proceedToCheckout();
		
		//customer3 proceeds to checkout. There's a $5 delivery charge because the total price is less than $50.
		customer3.cart.proceedToCheckout();
		
		System.out.println(customer1.cart.checkout);
		
		System.out.println(customer2.cart.checkout);
		
		System.out.println(customer3.cart.checkout);
		
		customer3.cart.checkout.cancelCheckout();
		
		//Checkout will be cancelled
		System.out.println(customer3.cart.checkout);
		
		//Emptying cart of customer3
		customer3.cart.empty();
		
	    //customer3 tries to add more than 50 items to their cart
		CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14").addToCart(customer3.cart, 5);
		CategoryList.getCategory("Clothing, Shoes and Jewelry").findProduct("Shirt").addToCart(customer3.cart, 5);
		CategoryList.getCategory("Clothing, Shoes and Jewelry").findProduct("Socks").addToCart(customer3.cart, 5);
		CategoryList.getCategory("Electronics").findProduct("Macbook Pro").addToCart(customer3.cart, 5);
		CategoryList.getCategory("Appliances").findProduct("Vaccuum Cleaner").addToCart(customer3.cart, 5);
		CategoryList.getCategory("Appliances").findProduct("Microwave").addToCart(customer3.cart, 5);
		CategoryList.getCategory("Appliances").findProduct("Toaster").addToCart(customer3.cart, 5);
		CategoryList.getCategory("Electronics").findProduct("Xbox One").addToCart(customer3.cart, 5);
		CategoryList.getCategory("Electronics").findProduct("PS5").addToCart(customer3.cart, 5);
		CategoryList.getCategory("Electronics").findProduct("Nintendo Switch").addToCart(customer3.cart, 5);
		
	    try {
	    	CategoryList.getCategory("Food").findProduct("Bread").addToCart(customer3.cart, 5);
	      } catch (Exception e) {
	        System.out.println(e);
	      }
		
		
		System.out.println(customer3.cart.totalCount);
		
		
		//Emptying cart of customer3
		customer3.cart.empty();
		
		//customer3 adds the following products to cart
		CategoryList.getCategory("Appliances").findProduct("Toaster").addToCart(customer3.cart);
		CategoryList.getCategory("Electronics").findProduct("Xbox One").addToCart(customer3.cart);
		
		//customer3 proceeds to checkout
		customer3.cart.proceedToCheckout();
		
		//Attempting to make payment with a different amount than the amount required. An exception is thrown.		
	    try {
	    	customer1.cart.checkout.makePayment("Visa Debit Card", "My visa card", 0);
	      } catch (Exception e) {
	        System.out.println(e);
	      }
		
		
		Payment.tempStatus = "Approved";
		
		//customer1 makes a payment
		customer1.cart.checkout.makePayment("Visa Debit Card", "My visa card", customer1.cart.checkout.finalPrice);
		
		//Cart should be empty
		System.out.println(customer1.cart);
		
		//customer2 makes a payment
		customer2.cart.checkout.makePayment("Paypal", "My paypal account", customer2.cart.checkout.finalPrice);
		
		//customer3 makes a payment
		customer3.cart.checkout.makePayment("Crypto", "Bitcoin", customer3.cart.checkout.finalPrice);
		
		
		System.out.println(customer1.orders);
		
		
		customer1.orders.get(0).track();
		
		//Attempting to cancel order before date of arrival. An exception is thrown.		
	    try {
	    	customer1.orders.get(0).cancel();
	      } catch (Exception e) {
	        System.out.println(e);
	      }
		
		
		System.out.println(customer2.orders);
		
		
		customer2.orders.get(0).track();
		
		
		System.out.println(customer3.orders);
		
		
		customer3.orders.get(0).track();
		
		Delivery.override = true;
		
		//customer3 cancels their order
		customer3.orders.get(0).cancel();
		
		//status of the delivery will be cancelled
		customer3.orders.get(0).track();
		
		//since customer3's order has been cancelled, they can request a refund
		customer3.orders.get(0).purchasedItems.get(0).requestRefund("Haven't received this order, so it was cancelled.");
		
		//refund request will appear for retailer1
		System.out.println(retailer1.refundRequests);
		
		//retailer1 pays the refund and the status of the refund is changed
		retailer1.refundRequests.get(0).pay("Master Card", "My Card", retailer1.refundRequests.get(0).amount);
		
		System.out.println(retailer1.refundRequests);
		
		//Attempting to add a review with rating that is not between 0 and 5. An exception is thrown.		
	    try {
	    	CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14").addReview(6, "I really liked this phone!", customer1);
	      } catch (Exception e) {
	        System.out.println(e);
	      }
		
	    //customer1 adds a review to the following product
		CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14").addReview(4.5, "I really liked this phone!", customer1);
		
	    //customer2 adds a review to the following product
		CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14").addReview(2, "I didn't like this phone.", customer2);
		
		//Attempting to add another review to the same product by the same customer. An exception is thrown.		
	    try {
	    	CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14").addReview(4.5, "I really liked this phone!", customer1);
	      } catch (Exception e) {
	        System.out.println(e);
	      }
	    
		//Attempting to request a refund for a purchased item that hasn't arrived yet. An exception is thrown.		
	    try {
	    	customer1.orders.get(0).purchasedItems.get(0).requestRefund(1, "I don't like it");
	      } catch (Exception e) {
	        System.out.println(e);
	      }
		
	    //product's average rating will be updated after customers added their reviews
		System.out.println(CategoryList.getCategory("Cell Phones & Accessories").findProduct("Iphone 14"));
	}

}
