package gui.set01;

import gui.set01.zadanie03_3.Figura;
import gui.set01.zadanie03_3.Kolo;
import gui.set01.zadanie03_3.Prostokat;
import gui.set01.zadanie03_3.Trojkat;

/**
 * Zadanie 3.  Figury geometryczne
 *
 * (max.   4p)
 *
 * Zdefinuj w programie klasę abstrakcyjną Figura reprezentujacą dowolną figurę
 * geometryczną:
 *
 * abstract class Figura{
 * private String nazwa; //nazwa figury
 * protected double[] wymiary; //wymiary figury
 * protected String[] opisWym;  // opis wymiarów
 *
 * // .... konstruktor- jaki ?
 *
 * abstract public double podajPole(); //metoda abstrakcyjna-oblicza pole  figury
 * abstract public double podajObwod(); //metoda abstrakcyjna - oblicza obwod figury
 * public void show(){ //prezentuje obiekt na konsoli
 * //  ........ instrukcje metody show()
 * }//show()
 * }//class Figura
 *
 * Na bazie tej klasy zdefinuj klasy konkretnych  figur geometrycznych  np.
 * - prostokąt, koło, trójkąt a w nich odpowiednie konstruktory i metody,
 * tak  aby można było wywoływać polimorficznie metody getPole(), getObwod()
 * i show() posługując sie odnośnikiem typu Figura.
 *
 * Przetestuj te metody w klasie głównej programu.
 *
 * Fragment programu do testowania:
 *
 * public static void main(String[] args){
 *
 * Figura fig = null;
 *
 * fig = new Prostokat(20,30);
 * fig.show();
 *
 * System.out.println("-------------------------------");
 *
 * fig = new Kolo(10);
 * fig.show();
 *
 * System.out.println("-------------------------------");
 *
 * fig = new Trojkat(3,4,5);
 * fig.show();
 * System.out.println("-------------------------------");
 * }
 *
 * ma dać nastepujacy wydruk na konsolę:
 *
 * Nazwa figury: Prostokat
 * dlugosc: 20.0
 * szerokosc: 30.0
 * pole= 600.0
 * obwod= 100.0
 * -------------------------------
 * Nazwa figury: Kolo
 * promien: 10.0
 * pole= 314.1592653589793
 * obwod= 62.83185307179586
 * -------------------------------
 * Nazwa figury: Trojkat
 * bok-1: 3.0
 * bok-2: 4.0
 * bok-3: 5.0
 * pole= 6.0
 * obwod= 12.0
 * -------------------------------
 *
 * @author s8376
 */
public class Zadanie03_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Figura fig = null;

		fig = new Prostokat(20, 30);
		fig.show();

		System.out.println("-------------------------------");

		fig = new Kolo(10);
		fig.show();

		System.out.println("-------------------------------");

		fig = new Trojkat(3, 4, 5);
		fig.show();

		System.out.println("-------------------------------");
	}
}
