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
	
	public Review(double rating, Product p) {
		this.rating = rating;
		this.p = p;
	}
	
	public void edit(double rating, String feedback) {
		this.rating = rating;
		this.feedback = feedback;
	}

	public String toString() {
		if(feedback == null) {
			return String.format("[Rating: %.2f]", rating);
		}
		return String.format("[Rating: %.2f, Feedback: %s]", rating, feedback);
	}
}
