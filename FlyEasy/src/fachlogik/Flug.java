package fachlogik;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;


public class Flug implements Serializable {

	private static final long serialVersionUID = 7024505680571386182L;

	List<Passagiere> passagiere = new ArrayList<>();

	Date startDatum;
	Date landeDatum; // (noch) keine Nutzung

	// TODO: Konvertierung String -> Date
	String startDatumString;
	Integer primaryKey;
	Destinations origin;
	Destinations destination;

	@Deprecated
	String startID;
	@Deprecated
	String landID;

	Boolean internationalFlight;

	public Flug() {
	}

    @Deprecated
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

	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
	
		if (this.origin == ((Flug)obj).origin &&  this.destination == ((Flug)obj).destination && this.getStartDatumString() == ((Flug)obj).getStartDatumString() ) {
			return true;
		} else {
			
			return false;
		}
		
		
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
	
	public void setStartDatumString(String startDatumString) {
		this.startDatumString = startDatumString;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub

		if (startDatumString.isEmpty()) {
			startDatumString = "";
		}
		return origin + "--> " + destination + " \t \t \t " + startDatumString;
	}

    @Deprecated
	public void save() {
		System.out.println("Es wird gespeichert");
	}


	public List<Passagiere> getPassagiere() {
		return passagiere;
	}

	public void addPassagiere(Passagiere passagiere) {
		this.passagiere.add(passagiere);
	}
	
	public void setOrigin(Destinations origin) {
		this.origin = origin;
	}
	
	public void setOrigin(String origin) {
		
		this.origin = Destinations.valueOf(origin);
	}

	public void setDestination(Destinations destination) {
		this.destination = destination;
	}
	
	public void setDestination(String destination) {
		this.destination = Destinations.valueOf(destination);
	}

	public Integer getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		int pk;
		
		pk = Integer.parseInt(primaryKey);
		this.primaryKey = pk;
	}
	
}
