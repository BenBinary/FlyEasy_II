package fachlogik;

public class Ticket_Business extends Ticket_General {

	public Ticket_Business() {
		super();
	}

	public String printInfo() {
		return getFlug().toString() + getPrice();
	}

}
