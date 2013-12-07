package gui.set01.zadanie03_5;

/**
 * Sklep
 */
public class Sklep {

	private Kasa kasa;

	/**
	 *
	 */
	public Sklep() {

		// Na poczatku dnia ustalany jest cennik
		// i otwierana jest kasa
		Cennik cennik = Cennik.getCennik();
		cennik.set("Truskawki", 5);
		cennik.set("Banany", 6);
		cennik.set("Agrest", 7);
		kasa = new Kasa();
	}

	/**
	 * @param osoba
	 */
	public void zakupyDemo(String osoba) {

		// Podana osoba wchodzi do sklepu i bierze koszyk
		// Każdy koszyk ma swój numer
		// Liczba koszyków jest nieograniczona

		Koszyk koszyk = new Koszyk();
		System.out.println(osoba + " bierze " + koszyk);

		// Dodaje do koszyka kilo truskawek
		// pol kilo bananow, cwierc kilo agrestu
		// i 2 kilo mandarynek
		koszyk.add(new Truskawki(1));
		koszyk.add(new Banany(0.5));
		koszyk.add(new Agrest(0.25));
		koszyk.add(new Mandarynki(2)); // dziwnym trafem sprzedawca zapomnial
		// ustalic ich ceny, ale kupujacy o tym nie wie

		// podchodzi do kasy
		// pokazuje zawartość koszyka
		// a kasa go rozlicza wg ustalonego cennika

		koszyk.showContent();
		kasa.printBill(koszyk); // wydruk rachunku

		// placi i ...
		// przeklada zawartosc koszyka do torby
		Torba torba = new Torba(osoba);
		torba.loadFrom(koszyk);

		// Przychodzi do domu i pokazuje co kupil(a)
		torba.showContent();
	}
}
