package gui.set01.zadanie04_4;

/**
 * Generator
 */
public class Generator {

	/**
	 *
	 */
	public void run() {

		int x = 0;
		while (true) {
			x++;
			System.out.println(x);

			if (x > 150000) {
				return;
			}
		}
	}
}
