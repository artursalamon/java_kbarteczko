package gui.set01.zadanie03_5;

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
	@Override
	public String toString() {
		return "koszyk sklepowy nr." + counter;
	}

	/**
	 * @return
	 */
	public ArrayList<Product> getStorage() {
		return storage;
	}
}
