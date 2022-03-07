package code;

public class CartItem {
	
	public Product p;
	public Cart cart;
	public int count;

	public CartItem(Product p, Cart cart) {
		super();
		this.p = p;
		this.cart = cart;
		this.count = 1;
	}
	
	public String toString() {
		return String.format("[Name: %s, Price: $%.2f, Count: %d]", p.name, p.price, count);
	}
	
	public void removeFromCart(int count) {
		cart.remove(this, count);
	}

}
