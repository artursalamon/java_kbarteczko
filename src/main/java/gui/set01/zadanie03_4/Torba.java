package gui.set01.zadanie03_4;

import java.util.ArrayList;

/**
 * Torba
 */
public class Torba {

	protected ArrayList<Product> storage;

	/**
	 *
	 */
	public Torba() {
		storage = new ArrayList<Product>();
	}

	/**
	 * @param koszyk
	 * @return
	 */
	public Torba loadFrom(Koszyk koszyk) {

		for (Product val : koszyk.getStorage()) {
			storage.add(val);
		}

		return this;
	}

	/**
	 *
	 */
	public void showContent() {
		System.out.println(toString());
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		String output = "Zawartość torby\n";

		for (Product val : storage) {
			output += val.getName() + " " + val.getQuantity() + " kg\n";
		}

		return output;
	}
}
