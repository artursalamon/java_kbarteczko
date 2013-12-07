package gui.set01;

import gui.set01.zadanie03_6.*;

/**
 * Zadanie 3
 * (modyfikacja zadania 2 - max 10 punktów)
 *
 * Po wykonaniu zadania 2 usunąć metodę zakupyDemo(...) z klasy Sklep,
 * a zamiast niej zdefiniować metodę void zakupy(...), tak by następujący kod:
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
 * // tu definicja metody zakupy(....)
 * }
 * class Test {
 * public static void main(String[] args)  {
 * Sklep s = new Sklep();
 * s.zakupy("Janek",
 * new Owoce[] { new Truskawki(1), new Banany(0.5),
 * new Agrest(0.25), new Mandarynki(1)
 * }
 * );
 * s.zakupy("Małgosia",
 * new Owoce[] { new Truskawki(5), new Banany(3) }  );
 * }
 * }
 *
 * dał w wyniku wydruk:
 *
 * Janek bierze koszyk sklepowy nr 1
 * Zawartość pojemnika "koszyk sklepowy nr 1" :
 * Truskawki 1.0 kg
 * Banany 0.5 kg
 * Agrest 0.25 kg
 * Mandarynki 1.0 kg
 * Kasa - rachunek za [ koszyk sklepowy nr 1 ] :
 * Truskawki 1.0 kg * 5.0 zl/kg  = 5.0 zl
 * Banany 0.5 kg * 6.0 zl/kg  = 3.0 zl
 * Agrest 0.25 kg * 7.0 zl/kg  = 1.75 zl
 * Razem: 9.75 zl
 * Zawartość pojemnika "torba [ właściciel: Janek ] " :
 * Truskawki 1.0 kg
 * Banany 0.5 kg
 * Agrest 0.25 kg
 * Małgosia bierze koszyk sklepowy nr 2
 * Zawartość pojemnika "koszyk sklepowy nr 2" :
 * Truskawki 5.0 kg
 * Banany 3.0 kg
 * Kasa - rachunek za [ koszyk sklepowy nr 2 ] :
 * Truskawki 5.0 kg * 5.0 zl/kg  = 25.0 zl
 * Banany 3.0 kg * 6.0 zl/kg  = 18.0 zl
 * Razem: 43.0 zl
 * Zawartość pojemnika "torba [ właściciel: Małgosia ] " :
 * Truskawki 5.0 kg
 * Banany 3.0 kg
 *
 * @author s8376
 */
public class Zadanie03_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Sklep s = new Sklep();
		s.zakupy("Janek", new Owoce[]{

				new Truskawki(1), new Mandarynki(1), new Banany(0.5), new Agrest(0.25)

		});

		s.zakupy("Małgosia", new Owoce[]{new Truskawki(5), new Banany(3)});
	}
}
