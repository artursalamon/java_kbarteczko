package gui.set01.zadanie03_4;

import java.util.ArrayList;

/**
 * Koszyk
 */
public class Koszyk {

	protected ArrayList<Product> storage;

	/**
	 *
	 */
	public Koszyk() {
		storage = new ArrayList<Product>();
	}

	/**
	 * @param product
	 */
	public void add(Product product) {
		storage.add(product);
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

		String output = "Zawartość koszyka:\n";

		for (Product val : storage) {
			output += val.getName() + " " + val.getQuantity() + " kg\n";
		}

		return output;
	}

	public ArrayList<Product> getStorage() {
		return storage;
	}
}
