package fachlogik;

public class Ticket_Economy extends Ticket_General {

	public Ticket_Economy() {
		super();
	}

	public String printInfo() {
		return getFlug().toString() + getPrice();
	}

}
