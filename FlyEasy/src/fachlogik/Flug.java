package fachlogik;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Debugging bei pushen

// Änderung von benedikt


public class Flug implements Serializable {

	private static final long serialVersionUID = 7024505680571386182L;

	List<Passagiere> passagiere = new ArrayList<>();

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


	public List<Passagiere> getPassagiere() {
		return passagiere;
	}

	public void addPassagiere(Passagiere passagiere) {
		this.passagiere.add(passagiere);
	}
}
