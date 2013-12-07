package gui.set01;

import gui.set01.zadanie02_1.Bus;
import gui.set01.zadanie02_1.Person;

/**
 * Zadanie 2
 *
 * Uzupełnić funkcjonalność obiektów klasy Bus o wsiadanie/wysiadanie pasażerów
 * na przystankach.
 * Przetestować dodatkową funkcjonalność w programie testującym symulując trasę
 * autobusu z kilkoma przystankami.
 *
 * @author s8376
 */
public class Zadanie02_2 {

	/**
	 * @param busstopName
	 * @param bus
	 * @param in
	 * @param out
	 */
	public static void busstop(String busstopName, Bus bus, int in, int out) {

		bus.stop();
		System.out.println("\n" + busstopName);
		try {
			bus.passengersDisembark(out);
			bus.passengersEmbarking(in);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(bus.toString());
		bus.start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Bus bus = new Bus("WW 12345", new Person("ZTM", "ABC123"), 2700, 3000,
				16000, 15000, 300, 45);

		// zajezdnia
		bus.fill(250);
		bus.start();

		busstop("Przystanek 1", bus, 25, 0);
		busstop("Przystanek 2", bus, 24, 12);
		busstop("Przystanek 3", bus, 10, 0);
		busstop("Przystanek 4", bus, 8, 25);
		busstop("Przystanek 5", bus, 35, 12);
		busstop("Przystanek 6", bus, 0, 46);

		// zajezdnia
		bus.fill(250);
		bus.stop();
	}
}
