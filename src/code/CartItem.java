package code;

public class CartItem {
	
	public Product p;
	public int count;

	public CartItem(Product p) {
		super();
		this.p = p;
		this.count = 1;
	}
	
	public String toString() {
		return String.format("[Name: %s, Price: $%.2f, Count: %d]", p.name, p.price, count);
	}

}
