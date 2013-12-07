package gui.set01;

import gui.set01.zadanie01_1.Tablica;

import javax.swing.*;

/**
 * Zadanie 1 - klasa Tablica
 *
 * Stworzyć i przetestować klasę Tablica, reprezentującą tablicę liczb
 * rzeczywistych i dostarczyć w niej metod:
 *
 * 1. init() - inicjującą tablicę liczbami podanymi w dialogu,
 * 2. getMax() - zwracającą maksymalny element tablicy,
 *
 * przy czym:
 *
 * * inicjacji tej samej tablicy można dokonywać wielokrotnie (różne dane),
 * * obliczanie maksimum dla każdej inicjacji może odbywać się tylko
 * jednokrotnie, ale metoda getMax() zawsze zwraca aktualne maksimum,
 * * jeżeli tablica jest niezainicjowana, to metoda getMax() zwraca wartość
 * Double.NaN,
 * * do wprowadzania danych służy jedno okienko dialogowe, w którym użytkownik
 * podaje elementy tablicy,
 * rozdzielone spacjami, a przy wadliwych danych jest informowany i proszony
 * o powtórzenie wprowadzania danych.
 *
 * @author s8376
 */
public class Zadanie01_1 {

	/**
	 * @return
	 */
	public static double[] getInput() {

		String input, dialogTitle = "";
		boolean inputFlag = false;
		String[] inputArray;
		double[] array = new double[10];

		while (inputFlag == false) {
			try {
				input = JOptionPane
						.showInputDialog((dialogTitle.length() > 0 ? dialogTitle
								+ "\n"
								: "")
								+ "Podaj ciąg znaków");
				inputArray = input.split("([ ,])+");

				for (int x = 0; x < inputArray.length; x++) {
					array[x] = Double.parseDouble(inputArray[x]);
				}

				inputFlag = true;
			} catch (Exception e) {
				dialogTitle = "Niepoprawna wartość wejściowa";
				inputFlag = false;
			}
		}
		return array;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Tablica tablica = new Tablica();
		try {
			//			tablica.init(getInput());
			System.out.println(tablica.getMax());

			tablica.init(getInput());
			System.out.println(tablica.toString());
			System.out.println(tablica.getMax());

			tablica.init(getInput());
			System.out.println(tablica.toString());
			System.out.println(tablica.getMax());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
