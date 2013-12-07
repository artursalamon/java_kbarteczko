package utp.set01;

/**
 * MinMax
 *
 * @param <T>
 */
class MinMax<T> {

	private T min;
	private T max;

	/**
	 * @param f
	 * @param l
	 */
	public MinMax(T f, T l) {
		min = f;
		max = l;
	}

	/**
	 * @return
	 */
	public T getMin() {
		return min;
	}

	/**
	 * @return
	 */
	public T getMax() {
		return max;
	}
}

/**
 * GenArr
 *
 * @param <T>
 */
class GenArr<T extends Comparable<T>> {

	private T[] arr;
	private MinMax<T> minMax;

	/**
	 * @param a
	 */
	public GenArr(T[] a) {
		init(a);
	}

	/**
	 * @param a
	 */
	public void init(T[] a) {
		minMax = null;
		arr = a;
	}

	/**
	 * @return
	 */
	public MinMax<T> getMinMax() {

		if (minMax != null)
			return minMax;
		if (arr == null || arr.length == 0)
			return null;
		T min = arr[0];
		T max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(min) < 0)
				min = arr[i]; // dzięki T extends Comparable
			if (arr[i].compareTo(max) > 0)
				max = arr[i];
		}
		minMax = new MinMax<T>(min, max);
		return minMax;
	}
}

/**
 * Listing_3_4_1
 */
public class Listing_3_4_1 {

	/**
	 *
	 */
	public Listing_3_4_1() {

		Integer[] arr1 = {1, 2, 7, -3};
		Integer[] arr2 = {1, 7, 8, -10};
		String[] napisy = {"A", "Z", "C"};

		GenArr<Integer> ga = new GenArr<Integer>(arr1);
		MinMax<Integer> imx = ga.getMinMax();
		System.out.println(imx.getMax() + " " + imx.getMin());
		ga.init(arr2);
		imx = ga.getMinMax();
		System.out.println(imx.getMax() + " " + imx.getMin());

		GenArr<String> gas = new GenArr<String>(napisy);
		System.out.println(gas.getMinMax().getMax() + " "
				+ gas.getMinMax().getMin());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Listing_3_4_1();
	}
}
