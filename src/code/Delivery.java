package code;

import java.time.LocalDateTime;
import java.util.*;


public class Delivery {
	
	public static int trackingNumber = 0;
	public LocalDateTime dateOfArrival;
	public String liveLocation;
	public String status;

	public Delivery(LocalDateTime localDateTime, String status) {
		super();
		Delivery.trackingNumber++;
		this.dateOfArrival = localDateTime;
		this.status = status;
	}
}

