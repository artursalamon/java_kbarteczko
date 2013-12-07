package gui.set03.kiosk2;

import static java.lang.System.out;

/**
 * Kiosk
 */
public class Kiosk {

	/**
	 *
	 */
	public Kiosk() {

		// Sprowadzamy gazety
		// możemy użyć dalej zdefiniowanej metody trans (może coś jeszcze będzie robić)
//		trans(SUPPLY, Głos, 20);
//		trans(SUPPLY, Polityka, 20);
//		trans(SUPPLY, Gazeta, 20);

		// ale możemy też pisać tak:
//		SUPPLY.perform(Gazeta, 10);
//		SUPPLY.perform(Polityka, 10);

		// co jest w kiosku i ile wydano na sprowadzenie gazet:
		out.println("Po dostawie w kiosku są następujące gazety:");
		double cost = 0;
		for (Gazety g : Gazety.values()) {
//			int n = getVolume(g);
//			cost += g.getWholesalePrice() * n;
//			out.println(g + " - liczba egzemplarzy " + n);
		}
		out.println("Wydano: " + cost);

		// Sprzedajemy trochę
//		SALE.perform(Polityka, 15);
//		SALE.perform(Głos, 10);
//		SALE.perform(Gazeta, 20);

		// Co sprzedano i ile uzyskano?
		out.println("Sprzedano gazety: ");
		double income = 0;
		for (Gazety g : Gazety.values()) {
//			int n = getSold(g);
//			income += g.getRetailPrice() * n;
//			out.println(g + " - liczba egzemplarzy " + n);
		}
		out.println("Dochód " + income);
		out.println("Zarobek : " + (income - cost));

		out.println("Zostały do sprzedaży:");
//		for (Gazety g : Gazety.values())
//			out.println(g + " - liczba egzemplarzy: " + getVolume(g));

	}

	/**
	 * Ew. można taką metodę sobie dodac
	 * Transakcja - zakup gazet do kiosku lub ich sprzedaż
	 *
	 * @param t - rodzaj transakcji (SUPPLY lub SALE)
	 * @param g - jaka gazeta
	 * @param n - ile sztuk
	 */
	public void trans(Transaction t, Gazety g, int n) {
		t.perform(g, n);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Kiosk();
	}
}
