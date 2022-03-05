package code;

public class Review {
	
	public double rating;
	public String feedback;
	public Product p;

	public Review(double rating, String feedback, Product p) {
		super();
		this.rating = rating;
		this.feedback = feedback;
		this.p = p;
	}
	
	public String toString() {
		return String.format("[Rating: %.2f, Feedback: %s]", rating, feedback);
	}
}
