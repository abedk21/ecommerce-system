package code;

import java.util.*;


public class Delivery {
	
	public int trackingNumber;
	public Date dateOfArrival;
	public String liveLocation;
	public String status;

	public Delivery(int trackingNumber, Date dateOfArrival, String liveLocation, String status) {
		super();
		this.trackingNumber = trackingNumber;
		this.dateOfArrival = dateOfArrival;
		this.liveLocation = liveLocation;
		this.status = status;
	}
}

