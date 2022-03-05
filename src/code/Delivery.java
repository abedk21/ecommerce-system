package code;

import java.time.LocalDateTime;


public class Delivery {
	
	public static int trackingNumber;
	public LocalDateTime dateOfArrival;
	public String liveLocation;
	public String status;
	public int maxDays = 15;

	public Delivery() {
		super();
		Delivery.trackingNumber++;
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
		return String.format("Delivery: [Tracking Number: %d, Live Location: %s, Status: %s, Date of Arrival: %s]", trackingNumber, liveLocation, status, dateOfArrival);
	}
}

