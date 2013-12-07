package gui.set03.kiosk1;

/**
 * Gazety
 */
public enum Gazety {

	Glos(1), Polityka(4.5), Gazeta(2.5);

	/**
	 * @param p
	 */
	Gazety(double p) {
		price = p;
	}

	public double getPrice() {
		return price;
	}

	private final double price;
}
