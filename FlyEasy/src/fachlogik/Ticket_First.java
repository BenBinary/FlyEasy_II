package fachlogik;

public class Ticket_First extends Ticket_General {

	public Ticket_First() {
		super();
	}

	public String printInfo() {
		return getFlug().toString() + getPrice();
	}

}
