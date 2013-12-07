package gui.set02;

import gui.set02.ex1.Tablica;

/**
 * Ex1
 *
 * Stworzyć i przetestować klasę Tablica, reprezentującą tablicę liczb
 * rzeczywistych i dostarczyć w niej metod:
 * init() - inicjującą tablicę liczbami podanymi w dialogu,
 * getMax() - zwracającą maksymalny element tablicy,
 * przy czym:
 * inicjacji tej samej tablicy można dokonywać wielokrotnie (różne dane ),
 * obliczanie maksimum dla każdej inicjacji może odbywać się tylko jednokrotnie,
 * ale metoda getMax() zawsze zwraca
 * aktualne maksimum,
 * jeżeli tablica jest niezainicjowana, to metoda getMax() zwraca wartość
 * Double.NaN,
 * do wprowadzania danych służy jedno okienko dialogowe, w którym użytkownik
 * podaje elementy tablicy,
 * rozdzielone spacjami, a przy wadliwych danych jest informowany i proszony
 * o powtórzenie wprowadzania danych.
 */
public class Ex1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Tablica tablica = new Tablica();

		tablica.init();
		System.out.println("max:" + tablica.getMax());


		tablica.init();
		System.out.println("max:" + tablica.getMax());
		System.out.println("max:" + tablica.getMax());
	}
}
