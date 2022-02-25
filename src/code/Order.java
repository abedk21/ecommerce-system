package code;

import java.util.*;

public class Order {
	
	public int id;
	public Date dateOfPurchase;
	public ArrayList<Product> purchasedItems;
	public int receiptNumber;

	public Order(int id, Date dateOfPurchase, ArrayList<Product> purchasedItems, int receiptNumber) {
		super();
		this.id = id;
		this.dateOfPurchase = dateOfPurchase;
		this.purchasedItems = purchasedItems;
		this.receiptNumber = receiptNumber;
	}
}
