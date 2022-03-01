package code;

public class Review {
	
	public int rating;
	public String feedback;
	public Product p;

	public Review(int rating, String feedback, Product p) {
		super();
		this.rating = rating;
		this.feedback = feedback;
		this.p = p;
	}
}
