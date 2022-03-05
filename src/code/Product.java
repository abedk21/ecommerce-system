package code;

import java.util.ArrayList;

public class Product {
	
	public static int id;
	public String name;
	public float price;
	public int count;
	public String description;
	public Category category;
	public float averageRating;
	public ArrayList<Review> reviews = new ArrayList<Review>();

	public Product(String name, float price, int count, String description, Category category) {
		super();
		Product.id++;
		this.name = name;
		this.price = price;
		this.count = count;
		this.description = description;
		this.category = category;
		category.addProduct(this);
		this.averageRating = 0;
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
