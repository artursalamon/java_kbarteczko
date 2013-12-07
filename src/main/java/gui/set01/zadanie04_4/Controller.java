package gui.set01.zadanie04_4;

import javax.swing.*;

/**
 * Controller
 */
public class Controller extends Thread {

	/**
	 *
	 */
	public void run() {

		Generator generator = new Generator();
		Writer writer = new Writer();

		generator.run();
		writer.run();

		while (true) {
			if (JOptionPane.showConfirmDialog(null, "Czy wykonać następną operację?") != 0) {
				//FIXME zamyka watki
				return;
			} else {
				// pokazuje statystyki
			}
		}
	}
}
