package gui.set01;

import gui.set01.zadanie03_4.*;

/**
 * Zadanie 1. Sklep owocowy
 *
 * (max 5 punktów)
 *
 * Napisać aplikację, która symuluje zakupy w sklepie z owocami.
 * Aplikacja wymaga zdefiniowania kilku klas i umiejętnego ich użycia, w taki
 * sposób by następujący program działał poprawnie.
 * Uwaga: w pokazanym tekście programu występują odwołania do klas: Cennik,
 * Koszyk, Truskawki, Banany, Agrest, Mandarynki, Kasa, Torba,
 * ale nie występuje jeszcze (co najmniej!) jedna ważna klasa potrzebna
 * do spełnienia wymagań postawionych przed programem.
 *
 * class Sklep {
 * public static void main(String[] args) {
 * // Na poczatku dnia ustalany jest cennik
 * Cennik cennik = new Cennik();
 * cennik.set("Truskawki", 5);  // ceny owoców w zł
 * cennik.set("Banany", 6);
 * cennik.set("Agrest", 7);
 *
 * // Wchodzimy do sklepu i bierzemy koszyk
 * Koszyk koszyk = new Koszyk();
 *
 * // Dodajemy do koszyka kilo truskawek
 * // pol kilo bananow, cwierc kilo agrestu
 * // i 2 kilo mandarynek
 *
 * koszyk.add(new Truskawki(1));
 * koszyk.add(new Banany(0.5));
 * koszyk.add(new Agrest(0.25));
 * koszyk.add(new Mandarynki(2)); // dziwnym trafem sprzedawca zapomnial
 * // ustalic ich ceny, ale my o tym nie wiemy
 *
 * // podchodzimy do kasy nr 1,
 * // pokazujemy zawartość koszyka
 * // a kasa nas rozlicza wg obowiązującego cennika
 *
 * Kasa kasa = new Kasa(1);
 * koszyk.showContent();    // pokazuje zawartość koszyka
 * kasa.printBill(koszyk, cennik); // wydruk rachunku
 *
 * // placimy (czego program juz nie pokazuje)
 * // i przekladamy zawartosc koszyka do torby
 *
 * Torba torba = new Torba();
 * torba.loadFrom(koszyk);  // przelozenie owocow z koszyka do torby
 *
 * // Przychodzimy do domu i pokazujemy co kupilismy
 *
 * torba.showContent(); // drukuje zawartosc torby
 *
 * }
 * }
 *
 * Powyższy program powinien wyprowadzić coś w rodzaju następującego listingu:
 *
 * Zawartość koszyka:
 * Truskawki 1.0 kg
 * Banany 0.5 kg
 * Agrest 0.25 kg
 * Mandarynki 2.0 kg
 *
 * Kasa nr 1 (rachunek)
 * Truskawki 1.0 kg * 5.0 zl/kg = 5.0 zl
 * Banany 0.5 kg * 6.0 zl/kg = 3.0 zl
 * Agrest 0.25 kg * 7.0 zl/kg = 1.75 zl
 * Razem: 9.75 zl
 *
 * Zawartość torby
 * Truskawki 1.0 kg
 * Banany 0.5 kg
 * Agrest 0.25 kg
 *
 * Wymaganie:
 * dodanie do powyższego programu zakupów innych rodzajów owoców (np. Winogron) ma byc bardzo łatwe.
 *
 * Potrzeba tylko :
 * * zdefiniowac nową klasę np. Winogrona, przy czym ma to być jak najbardziej oszczędna definicja (kilka wierszy kodu)
 * * dodać odpowiedni kod do funkcji main (np. cennik.set("Winogrona", 8); koszyk.add(new Winogrona(0.5)); )
 *
 * Przy dodaniu nowego rodzaju owoców nie wolno modyfikować żadnych innych klas programu.
 * UWAGA. W sklepie mogą być owoce, których zapomniano dodać do cennika. Wtedy przy kasie są one usuwane z naszego koszyka.
 *
 * @author s8376
 */
public class Zadanie03_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Na poczatku dnia ustalany jest cennik

		Cennik cennik = new Cennik();
		cennik.set("Truskawki", 5); // ceny owoców w zł
		cennik.set("Banany", 6);
		cennik.set("Agrest", 7);

		// Wchodzimy do sklepu i bierzemy koszyk
		Koszyk koszyk = new Koszyk();

		// Dodajemy do koszyka kilo truskawek
		// pol kilo bananow, cwierc kilo agrestu
		// i 2 kilo mandarynek

		koszyk.add(new Truskawki(1));
		koszyk.add(new Banany(0.5));
		koszyk.add(new Agrest(0.25));
		koszyk.add(new Mandarynki(2)); // dziwnym trafem sprzedawca zapomnial
		// ustalic ich ceny, ale my o tym nie wiemy

		// podchodzimy do kasy nr 1,
		// pokazujemy zawartość koszyka
		// a kasa nas rozlicza wg obowiązującego cennika

		Kasa kasa = new Kasa(1);
		koszyk.showContent(); // pokazuje zawartość koszyka
		kasa.printBill(koszyk, cennik); // wydruk rachunku

		// placimy (czego program juz nie pokazuje)
		// i przekladamy zawartosc koszyka do torby

		Torba torba = new Torba();
		torba.loadFrom(koszyk); // przelozenie owocow z koszyka do torby

		// Przychodzimy do domu i pokazujemy co kupilismy
		torba.showContent(); // drukuje zawartosc torby
	}
}
