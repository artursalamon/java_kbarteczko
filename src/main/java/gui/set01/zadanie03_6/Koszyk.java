package gui.set01.zadanie03_6;

import java.util.ArrayList;

/**
 * Koszyk
 */
public class Koszyk extends ContainerAbstract {

	public static int counter;

	/**
	 *
	 */
	public Koszyk() {
		super();
		counter++;
	}

	/**
	 * @param product
	 * @return
	 */
	public Koszyk add(Product product) {
		storage.add(product);
		return this;
	}

	/**
	 * @return
	 */
	public ArrayList<Product> getStorage() {
		return storage;
	}

	/**
	 * @return
	 */
	public String toString() {
		return "koszyk sklepowy nr." + counter;
	}
}
