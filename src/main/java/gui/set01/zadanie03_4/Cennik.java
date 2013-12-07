package gui.set01.zadanie03_4;

import java.util.Hashtable;

/**
 * Cennik
 */
public class Cennik {

	protected Hashtable<String, Double> tariff;

	/**
	 *
	 */
	public Cennik() {
		tariff = new Hashtable<String, Double>();
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
