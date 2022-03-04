package code;

import java.time.LocalDateTime;
import java.util.*;


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
		return "[Tracking Number: "+trackingNumber+", Live Location: "+liveLocation+", Status: "+status+", Date of Arrival: "+dateOfArrival+"]";
	}
}

