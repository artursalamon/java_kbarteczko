package gui.set01.zadanie03_4;

import java.util.ArrayList;

/**
 * Kasa
 */
public class Kasa {

	protected String name;

	/**
	 * @param name
	 */
	public Kasa(String name) {
		this.name = name;
	}

	/**
	 * @param name
	 */
	public Kasa(int name) {
		this.name = "" + name;
	}

	/**
	 * @param koszyk
	 * @param cennik
	 */
	public void printBill(Koszyk koszyk, Cennik cennik) {

		double amount = 0.0;
		String output = "Kasa nr " + name + " (rachunek)\n";

		ArrayList<Product> storage = koszyk.getStorage();

		for (int x = 0; x < storage.size(); x++) {
			if (cennik.hasPrice(storage.get(x).getName())) {
				amount += storage.get(x).getQuantity()
						* cennik.getPrice(storage.get(x).getName());
				output += storage.get(x).getName() + " "
						+ storage.get(x).getQuantity() + " kg * "
						+ cennik.getPrice(storage.get(x).getName())
						+ " zl/kg = " + storage.get(x).getQuantity()
						* cennik.getPrice(storage.get(x).getName()) + "\n";
			} else {
				storage.remove(x);
			}
		}

		output += "Razem: " + amount + " zl\n";

		System.out.println(output);
	}
}
