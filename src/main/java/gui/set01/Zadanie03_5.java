package gui.set01;

import gui.set01.zadanie03_5.Sklep;

/**
 * Zadanie 2
 *
 * (sklep owocowy B - max 7 punktów)
 *
 * Napisać aplikację, która symuluje zakupy w sklepie z owocami.
 * Aplikacja wymaga zdefiniowania kilku klas i umiejętnego ich użycia, w taki
 * sposób by następujący program działał poprawnie.
 * Uwaga: w pokazanym tekście programu  występują odwołania do klas: Cennik,
 * Koszyk, Truskawki, Banany, Agrest, Mandarynki, Kasa, Torba, ale
 * nie występuje jeszcze dwie ważne klasy potrzebne do spełnienia wymagań
 * postawionych przed programem.
 *
 * class Sklep  {
 * private Kasa kasa;
 * Sklep() {
 * // Na poczatku dnia ustalany jest cennik
 * // i otwierana jest kasa
 * Cennik cennik = Cennik.getCennik();
 * cennik.set("Truskawki", 5);
 * cennik.set("Banany", 6);
 * cennik.set("Agrest", 7);
 * kasa = new Kasa();
 * }
 * public void zakupyDemo(String osoba) {
 * // Podana osoba wchodzi do sklepu i bierze koszyk
 * // Każdy koszyk ma swój numer
 * // Liczba koszyków jest nieograniczona
 *
 * Koszyk koszyk = new Koszyk();
 * System.out.println(osoba + " bierze " + koszyk);
 *
 * // Dodaje do koszyka kilo truskawek
 * // pol kilo bananow, cwierc kilo agrestu
 * // i 2 kilo mandarynek
 * koszyk.add(new Truskawki(1));
 * koszyk.add(new Banany(0.5));
 * koszyk.add(new Agrest(0.25));
 * koszyk.add(new Mandarynki(2));  // dziwnym trafem sprzedawca zapomnial
 * // ustalic ich ceny, ale kupujacy o tym nie wie
 *
 * // podchodzi do kasy
 * // pokazuje zawartość koszyka
 * // a kasa go rozlicza wg ustalonego cennika
 *
 * koszyk.showContent();
 * kasa.printBill(koszyk);  // wydruk rachunku
 *
 * // placi i ...
 * // przeklada zawartosc koszyka do torby
 * Torba torba = new Torba(osoba);
 * torba.loadFrom(koszyk);
 *
 * // Przychodzi do domu i pokazuje co kupil(a)
 * torba.showContent();
 * }
 * }
 *
 * // Klasa testująca klasę Sklep
 * class Test {
 * public static void main(String[] args)  {
 * Sklep s = new Sklep();
 * s.zakupyDemo("Janek");
 * }
 *
 * Wydruk:
 * Janek bierze koszyk sklepowy nr 1
 * Zawartość pojemnika "koszyk sklepowy nr 1" :
 * Truskawki 1.0 kg
 * Banany 0.5 kg
 * Agrest 0.25 kg
 * Mandarynki 2.0 kg
 * Kasa - rachunek za [ koszyk sklepowy nr 1 ] :
 * Truskawki 1.0 kg * 5.0 zl/kg  = 5.0 zl
 * Banany 0.5 kg * 6.0 zl/kg  = 3.0 zl
 * Agrest 0.25 kg * 7.0 zl/kg  = 1.75 zl
 * Razem: 9.75 zl
 * Zawartość pojemnika "torba [ właściciel: Janek ] " :
 * Truskawki 1.0 kg
 * Banany 0.5 kg
 * Agrest 0.25 kg
 *
 * Wymagania:
 * * dodanie do powyższego programu zakupów innych rodzajów owoców (np. Winogron) ma byc bardzo łatwe; należy tylko dodać kilkuwierszową definicję nowej klasy owoców, ustalenie cen oraz ew. zakup tych owoców.
 * * należy wykorzystać klasy abstrakcyjne i polimorfizm
 * * należy zminimalizować kod klas Koszyk i Torba
 * * należy zdefiniować klasę Cennik jako singleton (możemy mieć zawsze tylko jeden cennik)
 *
 * UWAGA. W sklepie mogą być owoce, których zapomniano dodać do cennika. Wtedy przy kasie są one usuwane z naszego koszyka.
 *
 * @author s8376
 */
public class Zadanie03_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sklep s = new Sklep();
		s.zakupyDemo("Janek");
	}
}
