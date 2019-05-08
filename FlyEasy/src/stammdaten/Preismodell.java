package stammdaten;

public enum Preismodell {
	
	
	
	LONG_DISTANCE(400.0), DOMESTIC(100.0), CONTINENTAL(200.0), ECONOMY(0.0), FIRST(100), BUSINESS(50);

	
	private Double price;
	
	
	private Preismodell(double price) {
		this.price = price;
	}
}
