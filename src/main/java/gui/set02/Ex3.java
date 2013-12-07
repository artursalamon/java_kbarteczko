package gui.set02;

import gui.set02.ex3.Lotto;

/**
 * Ex3
 *
 * Napisać i przetestować program w Javie symulujący grę w TotoLotka.
 * Etap-1: wybór przez użytkownika 6 różnych liczb całkowitych
 * z przedziału [1,49]
 * Etap-2: losowanie przez generator 6 losowych, różnych liczb całkowitych
 * z przedziału [1,49]
 * Etap-3: szybkie porównanie wyników losowania – określenie ilości trafień
 *
 * W programie mogą być pomocne takie elementy jak:
 * wprowadzanie danych (z konsoli, z okienek dialogowych)
 * tablice,
 * pętle iteracyjne,
 * funkcje
 * sortowanie danych
 * obsługa wyjatków (jeżeli taka obsługa jest konieczna)
 * użycie klasy BigInteger i operacji bitowych do porównania wyników
 * użycie klasy Math lub Integer do generowania liczb losowych
 * wyprowadzenie danych (na konsolę,do okienek dialogowych)
 */
public class Ex3 {
	public static void main(String[] args) {
		new Lotto();
	}
}
