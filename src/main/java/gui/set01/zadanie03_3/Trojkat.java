package gui.set01.zadanie03_3;

/**
 * Trojkat
 */
public class Trojkat extends Figura {

	/**
	 * @param a
	 * @param b
	 * @param c
	 */
	public Trojkat(int a, int b, int c) {
		super("Trojkat", new double[]{(double) a, (double) b, (double) c},
				new String[]{"bok-1", "bok-1", "bok-1"});
	}

	/**
	 * @return
	 */
	public double podajPole() {

		double p = (1.0 / 2.0) * (wymiary[0] + wymiary[1] + wymiary[2]);
		return Math.sqrt(p * (p - wymiary[0]) * (p - wymiary[1])
				* (p - wymiary[2]));
	}

	/**
	 * @return
	 */
	public double podajObwod() {
		return wymiary[0] + wymiary[1] + wymiary[2];
	}
}
