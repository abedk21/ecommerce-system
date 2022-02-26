package code;

public class Product {
	
	public int id;
	public String name;
	public float price;
	public int count;
	public String description;
	public String category;
	public float averageRating;

	public Product(int id, String name, float price, int count, String description, String category, float averageRating) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.description = description;
		this.category = category;
		this.averageRating = averageRating;
	}
	
	public void edit(int id, String name, float price, int count, String description, String category, float averageRating) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.description = description;
		this.category = category;
		this.averageRating = averageRating;
	}
}
