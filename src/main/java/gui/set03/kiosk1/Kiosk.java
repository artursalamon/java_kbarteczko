package gui.set03.kiosk1;

import java.util.EnumMap;

import static java.lang.System.out;

/**
 * Kiosk
 */
public class Kiosk {

	/**
	 * Mapa gazet dostępnych w kiosku: klucz - gazeta, wartość - liczba egzemplarzy
	 */
	private EnumMap<Gazety, Integer> map = new EnumMap<Gazety, Integer>(Gazety.class);

	/**
	 *
	 */
	public Kiosk() {

//		supply(Glos, 20);
//		supply(Polityka, 20);
//		supply(Gazeta, 20);

		// co jest w kiosku:
		// Jak łatwo i elegancko!!!
		for (Gazety g : Gazety.values())
			out.println(g + " - liczba egzemplarzy " + map.get(g));

		// Sprzedajemy trochę
		double income = 0;
//		income += sale(Glos, 2);
//		income += sale(Polityka, 10);
//		income += sale(Gazeta, 5);
//		income += sale(Glos, 2);
		// Teraz w kiosku zostało
		for (Gazety g : Gazety.values())
			out.println(g + " - liczba egzemplarzy " + map.get(g));
		// a uzyskany dochód ze sprzedaży
		out.println("Dochód: " + income);
	}

	/**
	 * Dostawa q sztuk gazety g
	 *
	 * @param g - konkretna gazeta
	 * @param q - liczba sztuk w dostawie
	 */
	public void supply(Gazety g, int q) {
		// metoda containsKey() zwraca true jesli w mapie jest podany klucz
		if (map.containsKey(g))
			q += map.get(g);
		map.put(g, q);
	}

	/**
	 * sprzedaż q sztuk gazety g
	 *
	 * @param g - sprzedawana gazeta
	 * @param q - liczba sprzedanych sztuk
	 * @return wartość transakcji
	 */
	public double sale(Gazety g, int q) {
		if (!map.containsKey(g))
			return 0;
		int n = map.get(g);
		if (q > n)
			q = n;
		map.put(g, n - q);
		return q * g.getPrice();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Kiosk();
	}
}
