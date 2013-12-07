package ppj.set01;

import javax.swing.*;

/**
 * Zadanie 1 1
 *
 * Napisać program wyliczający:
 * * sumę, iloczyn i iloraz dwóch podanych liczb,
 * * maksimum z dwóch podanych liczb,
 * * minimum z dwóch podanych liczb.
 *
 * Liczby podawane są przez użytkownika, a program wypisuje wyniki obliczeń
 * w postaci:
 * SUMA = ...
 * ILOCZYN = ...
 * ILORAZ = ...
 * MAX = ....
 * MIN = ...
 *
 * Uwaga: należy uwzględnić przypadek dzielenia przez 0.
 *
 * @author s8376
 */
public class Zadanie_1_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean flag = false;
		int first = 0;
		int second = 0;
		String dane;

		do {
			try {
				dane = JOptionPane.showInputDialog("Podaj pierwszą liczbę:");
				first = Integer.parseInt(dane);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		} while (flag == false);

		do {
			try {
				dane = JOptionPane.showInputDialog("Podaj drugą liczbę:");
				second = Integer.parseInt(dane);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		} while (flag == false);

		System.out.println("SUMA = " + first + " + " + second + " = "
				+ (first + second));
		System.out.println("ILOCZYN = " + first + " * " + second + " = "
				+ (first * second));
		System.out.println("ILORAZ = " + first + " / " + second + " = "
				+ (second != 0 ? ((double) first / (double) second) : "ERROR"));
		System.out.println("MAX = " + (first > second ? first : second));
		System.out.println("MIN = " + (first < second ? first : second));
	}
}
