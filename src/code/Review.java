package code;

public class Review {
	
	public int id;
	public double rating;
	public String feedback;
	public Product p;
	public Customer c;

	public Review(double rating, String feedback, Product p, Customer c) {
		super();
		this.rating = rating;
		this.feedback = feedback;
		this.p = p;
		this.id = p.id;
		this.c = c;
	}
	
	public Review(double rating, Product p, Customer c) {
		this.rating = rating;
		this.p = p;
		this.c = c;
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
