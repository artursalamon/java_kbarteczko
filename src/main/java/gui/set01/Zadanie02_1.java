package gui.set01;

import gui.set01.zadanie02_1.Bus;
import gui.set01.zadanie02_1.Car;
import gui.set01.zadanie02_1.EngineVehicle;
import gui.set01.zadanie02_1.Person;

/**
 * Zadanie 1
 * Posługując się przykładem z wykładu (klasa Vehicle i klasa Car)
 * zdefiniować klasę EngineVehicle (pojazd silnikowy), dziedziczącą klasę Vehicle.
 * Wszystkie pojazdy silnikowe mają następujące właściwości:
 * - mają numer rejestracyjny,
 * - są napędzane paliwem (np. benzyną), a zatem mają bak o zadanej pojemności,
 * paliwo w baku (jakaś ilość) oraz umożliwiają tankowanie
 * (powiedzmy metoda void fill(int) - wlanie do baku n litrów paliwa.
 *
 * Używając zdefiniowanej klasy EngineVehicle zmodyfikować klasę Car
 * z wykładu i zdefiniować nową klasę Bus (autobus).
 * Autobusy będą miały dwie dodatkowe właściwości:
 * - liczba miejsc
 * - liczba wolnych miejsc.
 * Dostarczyć metod startVehicles(EngineVehicle[]) i reportState(EngineVehicle[]),
 * tak, by następujący program wyprowadził podane po nim napisy:
 *
 * class Veh1  {
 * static void reportState(EngineVehicle[] v)  {
 * // ...
 * }
 * static void startEngineVehicles(EngineVehicle[] v) {
 * // ...
 * }
 * public static void main(String[] args)  {
 * Bus a = new Bus("BUS1", new Person("MZA", "xxx"), 100, 100, 100, 100, 500, 20),
 * b = new Bus("BUS2", new Person("MZA", "xxx"), 100, 100, 100, 100, 500, 25);
 *
 * Car c = new Car("WA1090", new Person("Janek", "xxx"), 100, 100, 100, 100, 50),
 * d = new Car("WB7777", new Person("Zbyszek", "xxx"), 100, 100, 100, 100, 50);
 *
 * a.fill(100);
 * b.fill(100);
 * c.fill(30);
 * d.fill(50);
 *
 * EngineVehicle[] allVeh = new EngineVehicle[] { a, b, c, d };   // proszę zwrócić uwagę na inicjację tablicy allVeh!
 *
 * startEngineVehicles( allVeh );
 *
 * reportState( allVeh );
 * }
 *
 * Wyprowadza napisy:
 *
 * Pojazd silnikowy BUS1 - JEDZIE
 * Pojazd silnikowy BUS2 - JEDZIE
 * Pojazd silnikowy WA1090 - JEDZIE
 * Pojazd silnikowy WB7777 - JEDZIE
 *
 * @author s8376
 */
public class Zadanie02_1 {

	/**
	 * @param v
	 */
	static void reportState(EngineVehicle[] v) {

		for (EngineVehicle val : v) {
			System.out.println("Pojazd silnikowy " + val.getRegisterNumber()
					+ " - " + val.getState(val.getState()));
		}
	}

	/**
	 * @param v
	 */
	static void startEngineVehicles(EngineVehicle[] v) {

		for (EngineVehicle val : v) {
			val.start();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Bus a = new Bus("BUS1", new Person("MZA", "xxx"), 100, 100, 100, 100,
				500, 20), b = new Bus("BUS2", new Person("MZA", "xxx"), 100,
				100, 100, 100, 500, 25);

		Car c = new Car("WA1090", new Person("Janek", "xxx"), 100, 100, 100,
				100, 50), d = new Car("WB7777", new Person("Zbyszek", "xxx"),
				100, 100, 100, 100, 50);

		a.fill(100);
		b.fill(100);
		c.fill(30);
		d.fill(50);

		EngineVehicle[] allVeh = new EngineVehicle[]{a, b, c, d}; // proszę zwrócić uwagę na inicjację tablicy allVeh!

		startEngineVehicles(allVeh);
		reportState(allVeh);
	}
}
