package gui.set01;

import gui.set01.zadanie03_2.Osoba;
import gui.set01.zadanie03_2.Pracownik;

/**
 * Zadanie 2
 *
 * (max. 4 p)
 *
 * Zdefinuij w programie klasę Osoba :
 *
 * class Osoba{
 * private String imie;
 * private String nazwisko;
 * private int wiek;
 *
 * //konstruktory....
 *
 * public String getImie(){...}
 * public String getNazwisko(){...}
 * public int getWiek(){...}
 * public void show(){......}
 * public String toString(){....}
 * }//class Osoba
 *
 * reprezentujaca osobę o podanych danych.
 *
 * Metoda show() ma prezentować na konsoli dane o osobie
 * Metoda toString() ma zwracać łańcuch opisujący daną osobę - opis pól+wartości pól
 *
 * Zdefiniuj również klasę Pracownik dziedziczącą klasę Osoba:
 *
 * class Pracownik extends Osoba{
 * private String zawod;
 * private double pensja;
 * //konstruktory....
 * public String getZawod(){...}
 * public double getPensja(){...}
 * public void show(){......}
 * public String toString(){....}
 * }//class Pracownik
 *
 * Metoda show() ma prezentować na konsoli dane o pracowniku
 * Metoda toString() ma zwracać łańcuch opisujący danego pracownika - opis pól+wartości pól
 *
 * Utwórz obiekty klasy Osoba i Pracownik i wywołaj wszyskie metody z obu klas.
 *
 * Jakiego typu zmiennych referencyjnych trzeba użyć?
 *
 * Czy do wywołania metod klasy Pracownik można użyc referencji typu Osoba? Dlaczego ?
 *
 * Które metody będą wywołane polimorficznie ?
 *
 * Czy do wywołania metod klasy Osoba można użyc referencji typu Pracownik? Dlaczego ?
 *
 * Jak nazywa sie definiowanie w podklasach metod o takiej samej sygnaturze co metody nadklasy ?
 * Jak sie nazywa wiązanie nazwy metody z ciałem metody w fazie wykonania ?
 * Czy wszystkie metody w Javie można wywoływać polimorficznie ?
 *
 * Jak w obu klasach można odwołać sie do pól prywatnych obu klas w innej klasie  ?
 *
 * @author s8376
 */
public class Zadanie03_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Osoba osoba = new Osoba("Jan", "Kowalski", 25);
		Pracownik pracownik = new Pracownik("Zenon", "Nowak", 35, "Tokarz", 1500.00);

		System.out.println(osoba.getImie());
		System.out.println(osoba.getNazwisko());
		System.out.println(osoba.getWiek());
		osoba.show();
		System.out.println(osoba.toString());

		System.out.println("\n");

		System.out.println(pracownik.getImie());
		System.out.println(pracownik.getNazwisko());
		System.out.println(pracownik.getWiek());
		System.out.println(pracownik.getZawod());
		System.out.println(pracownik.getPensja());
		pracownik.show();
		System.out.println(pracownik.toString());

		Osoba osoba2 = new Pracownik();
		System.out.println(((Pracownik) osoba2).getZawod());
	}
}
