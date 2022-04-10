package code;

import java.time.LocalDateTime;


public class Delivery {
	
	public int trackingNumber;
	public static int counter;
	public Address address;
	public LocalDateTime dateOfArrival;
	public LocalDateTime expectedDateOfArrival;
	public String liveLocation;
	public int maxDays = 15;
	public static boolean override;
	public states state;
	
	//This is where the delivery class state diagram is implemented. The following are the states.
	enum states {
		READY,
		SHIPPED,
		INTRANSIT,
		DELAYED,
		CANCELLED,
		ARRIVED
	}

	public Delivery(Address address) {
		super();
		Delivery.counter++;
		this.trackingNumber = counter;
		this.address = address;
		this.expectedDateOfArrival = LocalDateTime.now().plusDays(maxDays);
		this.liveLocation = "NA";
		this.state = states.READY;
	}
	
	public void updateDate(LocalDateTime expectedDateOfArrival) {
		this.expectedDateOfArrival = expectedDateOfArrival;
	}
	
	public void updateLocation(String liveLocation) {
		this.liveLocation = liveLocation;
	}
	
	//The methods ship(), inTransit(), delay(), cancel(), arrived()  are the events of the state diagram that will cause the transitions.
	
	public void ship() {
		state = states.SHIPPED;
	}
	
	public void inTransit() {
		state = states.INTRANSIT;
	}
	
	public void delay() {
		state = states.DELAYED;
	}
	
	public void cancel() {
		state = states.CANCELLED;
	}
	
	public void arrived() {
		state = states.ARRIVED;
		this.dateOfArrival = LocalDateTime.now();
	}

	public String toString() {
		if(state != states.ARRIVED) {
			return String.format("Delivery: [Tracking Number: %d, Live Location: %s, Status: %s, Shipping To: %s, Expected Date of Arrival: %s]", trackingNumber, liveLocation, state, address, expectedDateOfArrival);	
		}
		return String.format("Delivery: [Tracking Number: %d, Live Location: %s, Status: %s, Shipping To: %s, Date of Arrival: %s]", trackingNumber, liveLocation, state, address, dateOfArrival);
	}
}

