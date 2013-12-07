package gui.set01.zadanie01_1;

/**
 * Tablica
 */
public class Tablica {

	protected int max = 10;
	protected double[] array;
	protected boolean getMaxOnlyOnceFlag = false;
	protected boolean initFlag = false;

	/**
	 *
	 */
	public Tablica() {
		array = new double[max];
	}

	/**
	 * @param max
	 */
	public Tablica(int max) {
		this.max = max;
		array = new double[max];
	}

	/**
	 * @param array
	 * @throws Exception
	 */
	public void init(double[] array) throws Exception {

		if (array.length > max) {
			throw new Exception("Dlugosc tablicy przekracza rozmiar maksymalny");
		}
		for (int x = 0; x < this.array.length; x++) {
			this.array[x] = 0.0;
		}
		for (int x = 0; x < array.length; x++) {
			this.array[x] = array[x];
		}
		getMaxOnlyOnceFlag = false;
		initFlag = true;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public double getMax() throws Exception {

		if (initFlag == false) {
			//			throw new Exception("Nie uzyto metody init()");
			return Double.NaN;
		}
		initFlag = false;
		if (getMaxOnlyOnceFlag == true) {
			throw new Exception("Metoda getMax() byla juz uzyta");
		}
		getMaxOnlyOnceFlag = true;

		Double output = 0.0;
		boolean firstFlag = true;

		for (Double val : array) {
			if (firstFlag) {
				output = val;
				firstFlag = false;
			}
			if (val != null && output < val) {
				output = val;
			}
		}

		return output;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {

		String output = "";
		for (Double val : array) {
			output += val + ", ";
		}

		return output;
	}
}
