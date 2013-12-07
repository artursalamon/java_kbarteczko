package gui.set01;

import gui.set01.zadanie04_1.MyRunnable;
import gui.set01.zadanie04_1.MyThread;

import javax.swing.*;

/**
 * Zad. 1
 *
 * (10 p)
 *
 * Zdefiniuj w programie klasę własnego wątku rozszerzajacą klasę Thread. Watek
 * ten ma w pętli nieskończonej wypisywać na konsolę okreslone znaki.
 *
 * Zdefiniuj również klasę zadania implementującąjącą interfejs Runnable.
 * Zadanie to ma w petli nieskończonej wypisywać na konsolę liczby.
 *
 * Uruchom watek własny oraz wątek realizujący zadanie i zaobserwuj ich
 * działanie.
 *
 * Zmodyfikuj klasę własnego wątku tak aby wątek usypiał na jakiś czas.
 *
 * Zmodyfikuj klasę własnego wątku tak aby można było przerwać stan uśpienia z
 * wątku głównego.
 *
 * Zmodyfikuj klasę własnego wątku tak aby wątek można było zakończyć z wątku
 * głównego.
 *
 * Zmodyfikuj klasę własnego wątku aby wątek można było wstrzymać na
 * synchronizatorze a potem uwolnić .
 *
 * Napisz fragment programu który generuje w wątku głównym okienko dialogowe z
 * menu pozwalającym na sterowanie wątkiem pobocznym.
 *
 * @author s8376
 */
public class Zadanie04_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyThread t1 = new MyThread();
		Thread t2 = new Thread(new MyRunnable());

		t1.start();
		t2.start();

		String input;
		while (true) {
			input = JOptionPane.showInputDialog("Panel\nAkcje:\n"
					+ "S - uśpienie wątku (sleep)\n"
					+ "I - przerwanie (interupt)\n"
					+ "H - wstrzymanie wątku (wait)\n"
					+ "W - wybudzenie wątku (notify)\n"
					+ "K - zakończenie wątku");

			if (input == null) {
				break;
			} else if (input.equals("S") || input.equals("s")) { // uspienie watku
				t1.setSleep();
			} else if (input.equals("I") || input.equals("i")) { // wyrwanie z uspienia
				t1.interrupt();
			} else if (input.equals("H") || input.equals("h")) { // uspienie watku
				t1.setWait();
			} else if (input.equals("W") || input.equals("w")) { // wybudzenie watku
				t1.wakeUp();
			} else if (input.equals("K") || input.equals("k")) { // zakonczenie watku
				t1.stopThis();
				break;
			}

		}

		System.exit(0);
	}
}
