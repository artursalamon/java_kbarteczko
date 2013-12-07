package gui.set01.zadanie03_5;

import java.util.Hashtable;

/**
 * Cennik
 */
public final class Cennik {

	private final static Cennik instance = new Cennik();
	protected Hashtable<String, Double> tariff;

	/**
	 *
	 */
	private Cennik() {
		tariff = new Hashtable<String, Double>();
	}

	/**
	 * @return
	 */
	public static Cennik getCennik() {
		return instance;
	}

	/**
	 * @param name
	 * @return
	 */
	public double getPrice(String name) {
		return tariff.get(name);
	}

	/**
	 * @param name
	 * @return
	 */
	public boolean hasPrice(String name) {
		return tariff.containsKey(name) ? true : false;
	}

	/**
	 * @param name
	 * @param price
	 * @return
	 */
	public Cennik set(String name, double price) {
		tariff.put(name, (Double) price);
		return this;
	}
}
