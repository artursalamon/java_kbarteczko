package gui.set02;

import gui.set02.ex2.ATM;

/**
 * Ex2
 *
 * Napisać program symulujący pobieranie pieniędzy z bankomatu  a w szczególności:
 * wprowadzanie pinkodu
 * sprawdanie czy dany pinkod znajduje się na predefiniowanej liście
 * uprawnionych pinkodów
 * blokada bankomatu po 3 nieudanych próbach zalogowania
 * wypłacanie tylko wielokrotności 100 PLN
 * limit dzienny wypłaty
 * Jako prostej bazy danych można użyć plików.
 */
public class Ex2 {
	public static void main(String[] args) {
		new ATM("resources/ex2_database.txt");
	}
}
