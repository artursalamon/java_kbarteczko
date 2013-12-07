package gui.set03.threads;

/**
 * Teksty
 *
 * Klasa dla ustalania i pobierania tekstów
 */
class Teksty {

	String txt = null;
	boolean newTxt = false;

	/**
	 * Metoda ustalająca tekst - wywołuje Autor
	 */
	synchronized void setTextToWrite(String s) {

		while (newTxt == true) {
			try {
				wait();
			} catch (InterruptedException exc) {
			}
		}
		txt = s;
		newTxt = true;
		notifyAll();
	}

	/**
	 * Metoda pobrania tekstu - wywołuje Writer
	 */
	synchronized String getTextToWrite() {

		while (newTxt == false) {
			try {
				wait();
			} catch (InterruptedException exc) {
			}
		}
		newTxt = false;
		notifyAll();
		return txt;
	}
}

/**
 * Writer
 *
 * Klasa "wypisywacza"
 */
class Writer extends Thread {

	Teksty txtArea;

	/**
	 * @param t
	 */
	Writer(Teksty t) {
		txtArea = t;
	}

	/**
	 *
	 */
	public void run() {

		String txt = txtArea.getTextToWrite();
		while (txt != null) {
			System.out.println("-> " + txt);
			txt = txtArea.getTextToWrite();
		}
	}
}

/**
 * Author
 *
 * Klasa autora
 */
class Author extends Thread {

	Teksty txtArea;

	/**
	 * @param t
	 */
	Author(Teksty t) {
		txtArea = t;
	}

	/**
	 *
	 */
	public void run() {

		String[] s = {"Pies", "Kot", "Zebra", "Lew", "Owca", "Słoń", null};
		for (int i = 0; i < s.length; i++) {
			try { // autor zastanawia się chwilę co napisać
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException exc) {
			}
			txtArea.setTextToWrite(s[i]);
		}
	}
}

/**
 * Koord
 *
 * Klasa testująca
 */
public class Koord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Teksty t = new Teksty();
		Thread t1 = new Author(t);
		Thread t2 = new Writer(t);
		t1.start();
		t2.start();
	}
}
