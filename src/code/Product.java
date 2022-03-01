package code;

import java.util.ArrayList;

public class Product {
	
	public int id;
	public String name;
	public float price;
	public int count;
	public String description;
	public Category category;
	public float averageRating;
	public ArrayList<Review> reviews = new ArrayList<Review>();

	public Product(int id, String name, float price, int count, String description, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = 0;
		this.description = description;
		this.category = category;
		this.averageRating = 0;
	}
	
	public void edit(int id, String name, float price, int count, String description, Category category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.description = description;
		this.category = category;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
		float sum = 0;
		for (int i = 0; i <= reviews.size(); i++) {
			sum += reviews.get(i).rating;
		}
		averageRating = sum/reviews.size();
	}
}
