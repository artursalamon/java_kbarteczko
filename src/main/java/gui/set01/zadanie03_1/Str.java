package gui.set01.zadanie03_1;

/**
 * Str
 */
public class Str implements Sortable {

	private String name;

	/**
	 *
	 */
	public Str() {
		this("default");
	}

	/**
	 * @param name
	 */
	public Str(String name) {
		this.name = name;
	}

	/**
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	@Override
	public int compare(Object obj1, Object obj2) {

		Str tmpObj1 = (Str) obj1;
		Str tmpObj2 = (Str) obj2;

		return tmpObj1.getName().compareTo(tmpObj2.getName());
	}

	public String getName() {
		return name;
	}
}
