package code;

import java.time.LocalDateTime;


public class Delivery {
	
	public int trackingNumber;
	public static int counter;
	public Address address;
	public LocalDateTime dateOfArrival;
	public String liveLocation;
	public String status;
	public int maxDays = 15;
	public static boolean override;

	public Delivery(Address address) {
		super();
		Delivery.counter++;
		this.trackingNumber = counter;
		this.address = address;
		this.dateOfArrival = LocalDateTime.now().plusDays(maxDays);
		this.liveLocation = "NA";
		this.status = "Shipped";
	}
	
	public void update(LocalDateTime dateOfArrival, String liveLocation, String status) {
		this.dateOfArrival = dateOfArrival;
		this.liveLocation = liveLocation;
		this.status = status;
	}

	public String toString() {
		return String.format("Delivery: [Tracking Number: %d, Live Location: %s, Status: %s, Shipping To: %s, Date of Arrival: %s]", trackingNumber, liveLocation, status, address, dateOfArrival);
	}
}

