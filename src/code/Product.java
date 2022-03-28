package code;

import java.util.ArrayList;

public class Product {
	
	private static int counter;
	public int id;
	public String name;
	public float price;
	public int count;
	public String description;
	public Category category;
	public Retailer retailer;
	public float averageRating;
	public ArrayList<Review> reviews = new ArrayList<Review>();
	public states state;
	
	enum states {
		IDLE,
		INSTOCK,
		OUTOFSTOCK
	}

	public Product(String name, float price, int count, String description, Category category, Retailer retailer) {
		super();
		Product.counter++;
		this.id = counter;
		this.name = name;
		this.price = price;
		this.count = count;
		this.description = description;
		this.category = category;
		this.retailer = retailer;
		category.addProduct(this);
		this.averageRating = 0;
		this.state = states.IDLE;
	}
	
	public void display() {
		this.state = states.INSTOCK;
	}
	
	public void addCount(int n) {
		count += n;
		state = states.INSTOCK;
	}
	
	public void subCount(int n) {
		count -= n;
		if(count == 0) {
			state = states.OUTOFSTOCK;
		}	
	}
	
	public void edit(String name, float price, int count, String description, Category category) {
		this.name = name;
		this.price = price;
		this.count = count;
		this.description = description;
		if(category != this.category) {
			this.category.removeProduct(this);
			category.addProduct(this);
		}
		this.category = category;
	}
	
//	8. Only the customer user can add the product to cart, the cart item count should be equal or less than the product count, and the customer can only add a maximum of 5 of the same product. The total price is then updated.
//
//	Context Product::addToCart(c :CartItem, countTobeAdded :int)
//	pre: self.User -> forAll(u :user | u.oclIsTypeOf(Customer)) AND self.CartItem -> forAll(c :CartItem, p :Product | c.id = p.id  implies p.count >= countToBeAdded AND (countToBeAdded + c.count) <=5)
//	post:  self.CartItem -> forAll(c :CartItem, p :Product | c.id = p.id implies p.count >= c.count AND c.count <=5)
//	totalPrice = totalPrice@pre + c.count * c.Product.price

	
	public void addToCart(Cart cart, int count) throws Exception {
		
		if(count > this.count) {
			throw new Exception("Can't add more than the actual count of the product.");
		}
		
		boolean found = false;
		for(int i = 0; i < cart.cartItems.size(); i++) {
			if(cart.cartItems.get(i).p == this) {
				found = true;
				if(count+cart.cartItems.get(i).count >= 5) {
					throw new Exception("You can only add 5 of the same product to the cart.");
				}
				break;
			}
		}
		
		if (!found) {
			if(count > 5) {
				throw new Exception("You can only add 5 of the same product to the cart.");
			}
		}
		
//		12. Maximum of 50 items can be added to the cart.
//		Context Cart
//		inv: self.CartItems -> collect(count) -> sum() <= 50
		
		if(count + cart.totalCount > 50) {
			throw new Exception("You can't have more than 50 items in your cart.");
		}
		
		for(int i = 0; i < count; i++) {
			cart.addToCart(this);
		}
	}
	
	public void addToCart(Cart cart) throws Exception {
		if(count > this.count) {
			throw new Exception("The product is out of stock.");
		}
		
		for(int i = 0; i < cart.cartItems.size(); i++) {
			if(cart.cartItems.get(i).p == this) {
				if(count+cart.cartItems.get(i).count >= 5) {
					throw new Exception("You can only add 5 of the same product to the cart.");
				}
				break;
			}
		}
		
//		12. Maximum of 50 items can be added to the cart.
//		Context Cart
//		inv: self.CartItems -> collect(count) -> sum() <= 50
		
		if(cart.totalCount == 50) {
			throw new Exception("You can't have more than 50 items in your cart.");
		}
		cart.addToCart(this);
	}
	
//	9. After the customer orders a product, they can add a review. The average rating of the product will be updated.
//	Context Product::addReview(r :Review)
//	pre: self.User -> forAll(u :user | u.oclIsTypeOf(Customer)) AND
//		self.Review -> excludes(r) AND
//		allInstances() -> includesAll(self.Customer.Order.PurchasedItem.Payment.Checkout.Cart.Product)
//	post: self.Review -> includes(r) AND
//		averageRating = (self.Review-> select(r.id = p.id) -> collect(rating) -> sum()) / self.Review-> select(r.id = p.id) -> size()

	//This function adds a review with a rating only without a feedback.
	
	public void addReview(double rating, Customer c) throws Exception {
		
//		4.For the customer to give review to the product, he/she should be a verified purchaser.
//		Context Customer
//		Inv: self.product -> includesAll(self.Order.PurchasedItem.Payment.Checkout.Cart.Product)
		
		boolean found = false;
		for(int i = 0; i < c.orders.size(); i++) {
			ArrayList<PurchasedItem> purchasedItems = c.orders.get(i).purchasedItems;
			for(int j = 0; j < purchasedItems.size(); j++) {
				if(purchasedItems.get(j).p == this) {
					found = true;
				}
			}
		}
		
		if(!found) {
			throw new Exception("Can't add a review for an unpurchased product.");
		}
		
		for(int i = 0; i < reviews.size(); i++) {
			if(reviews.get(i).c == c) {
				throw new Exception("Review already exists.");
			}
		}
		
//		13. A review can only have a rating between 0 and 5.
//
//		Context Review
//		inv: self.rating >= 0 AND self.rating <= 5
		
		if(rating < 0 || rating > 5) {
			throw new Exception("Rating should be between 0 and 5.");
		}
		
		Review review = new Review(rating, this, c);
		addReview(review);
	}
	
	
	//This function adds a review with a rating and a feedback.
	
	public void addReview(double rating, String feedback, Customer c) throws Exception {
		
//		4.For the customer to give review to the product, he/she should be a verified purchaser.
//		Context Customer
//		Inv: self.product -> includesAll(self.Order.PurchasedItem.Payment.Checkout.Cart.Product)
		
		boolean found = false;
		for(int i = 0; i < c.orders.size(); i++) {
			ArrayList<PurchasedItem> purchasedItems = c.orders.get(i).purchasedItems;
			for(int j = 0; j < purchasedItems.size(); j++) {
				if(purchasedItems.get(j).p == this) {
					found = true;
				}
			}
		}
		if(!found) {
			throw new Exception("Can't add a review for an unpurchased product.");
		}
		for(int i = 0; i < reviews.size(); i++) {
			if(reviews.get(i).c == c) {
				throw new Exception("Review already exists.");
			}
		}
		
//		13. A review can only have a rating between 0 and 5.
//
//		Context Review
//		inv: self.rating >= 0 AND self.rating <= 5
		
		if(rating < 0 || rating > 5) {
			throw new Exception("Rating should be between 0 and 5.");
		}
		Review review = new Review(rating, feedback, this, c);
		addReview(review);
	}
	
	//After a new review is added, the average rating of the product will be updated here.
	public void addReview(Review review) {
		reviews.add(review);
		float sum = 0;
		for (int i = 0; i < reviews.size(); i++) {
			sum += reviews.get(i).rating;
		}
		averageRating = sum/reviews.size();
	}
	
	public String toString() {
		String reviews = "[";
		if(!this.reviews.isEmpty()) {
			for(int i = 0; i < this.reviews.size(); i++) {
				if(i != this.reviews.size() -1) {
					reviews += this.reviews.get(i) + ", ";
				} else {
					reviews += this.reviews.get(i);
				}
			}
		}
		reviews += "]";
		return String.format("Product: [Name: %s, Price: $%.2f, Count: %d, Description: %s, Category: %s, Average Rating: %.2f, Reviews: %s]", name, price, count, description, category.name, averageRating, reviews);
	}
}
