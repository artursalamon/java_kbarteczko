package gui.set01.zadanie03_3;

/**
 * Kolo
 */
public class Kolo extends Figura {

	protected double pi = 3.14;

	/**
	 * @param r
	 */
	public Kolo(int r) {
		super("Kolo", new double[]{(double) r}, new String[]{"promien"});
	}

	/**
	 * @return
	 */
	public double podajPole() {
		return pi * wymiary[0] * wymiary[0];
	}

	/**
	 * @return
	 */
	public double podajObwod() {
		return 2.0 * pi * wymiary[0];
	}
}
