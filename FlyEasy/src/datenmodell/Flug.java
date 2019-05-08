package datenmodell;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.StreamTokenizer;
import java.util.Date;

public class Flug implements Serializable {
	


	Date startDatum;
	Date landeDatum;

	String startDatumString;
	
	Destinations orgin;
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
	 * @param orgin
	 * @param destination
	 * @param internationalFlight
	 */
	public Flug(String startDatum, Destinations orgin, Destinations destination, Boolean internationalFlight) {
		super();
		this.startDatumString = startDatum;
		this.orgin = orgin;
		this.destination = destination;
		this.internationalFlight = internationalFlight;
	}


	public String getStartDatumString() {
		return startDatumString;
	}


	public Destinations getOrgin() {
		return orgin;
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
		return orgin + "--> " + destination + " \t \t \t " + startDatumString;
	}
	
	
	public void save() {
		
		
		
		System.out.println("Es wird gespeichert");
		
		
	}
	
	

}
