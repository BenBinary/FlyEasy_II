package fachlogik;

public abstract class Ticket_General {

	private Flug flug;
	private Double price;


	public Ticket_General() {
		this.flug = new Flug();
		// price
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
