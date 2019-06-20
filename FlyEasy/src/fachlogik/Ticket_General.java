package fachlogik;

public abstract class Ticket_General {

	private Flug flug;
	private Double price;
	private int id;


	public Ticket_General() {
		this.flug = new Flug();
		// price
		id = IDGenerator.instance().getIDNumber();
	}

	public abstract String printInfo();

	public Flug getFlug() {
		return flug;
	}

	public void setFlug(Flug flug) {
		this.flug = flug;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
