package fachlogik;

import java.io.Serializable;
import java.util.Date;

public class Flug implements Serializable {

	Date startDatum;
	Date landeDatum;

	String startDatumString;
	
	Destinations origin;
	Destinations destination;
	
	String startID;
	String landID;
	
	Boolean internationalFlight;
	
	public Flug() {
		
	}
	
	
	public Flug(String startID, String landID) {
		super();
		this.startID = startID;
		this.landID = landID;
	}
	
	
	/**
	 * @param startDatum
	 * @param origin
	 * @param destination
	 * @param internationalFlight
	 */
	public Flug(String startDatum, Destinations origin, Destinations destination, Boolean internationalFlight) {
		super();
		this.startDatumString = startDatum;
		this.origin = origin;
		this.destination = destination;
		this.internationalFlight = internationalFlight;
	}


	public String getStartDatumString() {
		return startDatumString;
	}


	public Destinations getOrigin() {
		return origin;
	}


	public Destinations getDestination() {
		return destination;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		if (startDatumString.isEmpty()) {
			startDatumString = "";
		}
		return origin + "--> " + destination + " \t \t \t " + startDatumString;
	}
	
	
	public void save() {
		
		System.out.println("Es wird gespeichert");
	}

}
