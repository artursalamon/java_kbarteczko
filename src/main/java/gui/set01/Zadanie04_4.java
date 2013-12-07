package gui.set01;

import gui.set01.zadanie04_4.Controller;

/**
 * Zadanie-3: dane meteorologiczne
 *
 * (max. 10p)
 *
 * Napisać program symulujący przetwarzanie danych meteorologicznych.
 * Na program składa się m.in. wątek generowania danych, który losowo pobiera
 * z tablicy krajów nazwę kraju, z tablicy dat - datę, a z tablicy temperatur
 * dwie liczby: temperaturę w dzien i w nocy.
 * Z tych danych formuje "rekord": kraj data temp_w_dzien temp_w_nocy.
 *
 * Dla każdego kraju działa  wątek odbioru danych, który od wątku-generatora
 * otrzymuje  kolejne rekordy dla danego kraju i zapisuje je do pliku o nazwie:
 * nazwa_kraju.temp w postaci  binarnej.
 *
 * Inny wątek - kontroler ma zapewniać:
 * * liczenie dotychczasowej (czyli na danych dotąd zapisanych) średniej temperatury dla podanego kraju
 * * kończenie pracy wszystkich wątków.
 *
 * Operacje te podajemy w dialogu wejściowym w wątku-kontrolerze.
 *
 * Zapewnić prostą w oprogramowaniu komunikację między wątkami np. przez potoki (PipedInputStream,PipedOutputStream)
 *
 * @author s8376
 */
public class Zadanie04_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Controller controller = new Controller();
		controller.run();

		System.out.println("OK");
	}
}
