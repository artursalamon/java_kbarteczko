package gui.set02.ex1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Tablica
 */
public class Tablica {

	private List<Integer> storage;
	private int maximum;
	private boolean isCalculatedMax = false;

	/**
	 * Inicjalizuje tablicę liczbami podanymi w dialogu
	 *
	 * inicjacji tej samej tablicy można dokonywać wielokrotnie (różne dane),
	 * do wprowadzania danych służy jedno okienko dialogowe, w którym użytkownik podaje elementy tablicy,
	 * rozdzielone spacjami, a przy Wwadliwych danych jest informowany i proszony o powtórzenie wprowadzania danych.
	 */
	public void init() {

		storage = new ArrayList<Integer>();
		isCalculatedMax = false;

		while (true) {
			String input = JOptionPane.showInputDialog("Liczby rozdzielone spacja");
			try {
				for (String val : input.split("([ ]+)")) {
					System.out.println(val);
					storage.add(Integer.parseInt(val));
				}
			} catch (Exception e) {
				System.out.println("Exception");
				System.out.println(e.toString());
			}

			break;
		}
	}

	/**
	 * Zwraca maksymalny element tablicy
	 *
	 * obliczanie maksimum dla każdej inicjacji może odbywać się tylko jednokrotnie, ale metoda getMax() zawsze zwraca
	 * aktualne maksimum
	 * jeżeli tablica jest niezainicjowana, to metoda getMax() zwraca wartość Double.NaN
	 *
	 * @return
	 */
	public Object getMax() {

		if (storage == null) {
			return Double.NaN;
		}

		if (!isCalculatedMax) {
			isCalculatedMax = true;
			maximum = Collections.max(storage);
		}

		return maximum;
	}
}
