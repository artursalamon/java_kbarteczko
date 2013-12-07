package gui.set01.zadanie03_3;

/**
 * Prostokat
 */
public class Prostokat extends Figura {

	/**
	 * @param x
	 * @param y
	 */
	public Prostokat(int x, int y) {
		super("Prostokat", new double[]{(double) x, (double) y},
				new String[]{"dlugosc", "szerokosc"});
	}

	/**
	 * @return
	 */
	public double podajPole() {
		return wymiary[0] * wymiary[1];
	}

	/**
	 * @return
	 */
	public double podajObwod() {
		return 2.0 * wymiary[0] + 2.0 * wymiary[1];
	}
}
