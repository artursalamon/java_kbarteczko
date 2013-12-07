package ppj.set01;

import javax.swing.*;

/**
 * Zadanie 1 2
 *
 * Wybieramy się w podróż lotniczą.
 * Napisać program obliczania  kosztów przelotu w zależności od podawanych
 * "na wejściu" (czyli przez użytkownika):
 *
 * * liczby dni pobytu,
 * * liczby osób,
 * * ceny przelotu tam i z powrotem na osobę,
 *
 * Uwzględnić następujące dodatkowe wymagania:
 *
 * * jeżeli liczba dni pobytu przekracza 14, to cena przelotu jest mniejsza
 * od ceny podstawowej o 20%,
 * * jeżeli  w podróż wybiera się więcej niż 10 osób to cena każdego biletu
 * jest zmniejszana o 10%..
 *
 * Uwaga: zniżki się kumulują tzn. jeżeli bilet podstawowy kosztuje 100,
 * i oba warunki udzielenia zniżek są prawdziwe, to cena biletu po zniżkach
 * będzie równa 100*0.8*0.9.
 *
 * Wyprowadzić informację o łacznych kosztach przelotu dla wszystkich osób
 *
 * @author s8376
 */
public class Zadanie_1_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean flag = false;
		String data;
		int days = 0;
		int persons = 0;
		int price = 0;

		do {
			try {
				data = JOptionPane.showInputDialog("Liczba dni pobytu:");
				days = Integer.parseInt(data);
				if (days <= 0) {
					throw new Exception("Liczba musi byc wieksza od 0");
				}
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		} while (flag == false);

		do {
			try {
				data = JOptionPane.showInputDialog("Liczba osób:");
				persons = Integer.parseInt(data);
				if (days <= 0) {
					throw new Exception("Liczba musi byc wieksza od 0");
				}
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		} while (flag == false);

		do {
			try {
				data = JOptionPane
						.showInputDialog("Cena przelotu tam i z powrotem na osobę:");
				price = Integer.parseInt(data);
				if (days <= 0) {
					throw new Exception("Liczba musi byc wieksza od 0");
				}
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		} while (flag == false);

		double cost = (double) price;
		if (days > 14) {
			cost = cost * 0.8;
		}
		if (persons > 10) {
			cost = cost * 0.9;
		}

		System.out.println("Koszt podróży dla osób: " + persons + " na dni: "
				+ days + " przy cenie: " + price + " = " + (cost * persons));
	}
}
