package gui.set01.zadanie04_2;

/**
 * Employee
 */
public class Employee {

	String[][] storage;

	/**
	 * @return
	 */
	protected char randomChar() {
		// 65-90 duze litery
		return (char) (65 + (int) (25 * Math.random()));
	}

	/**
	 * @param from
	 * @param to
	 * @return
	 */
	protected int randomInt(int from, int to) {
		return from + (int) (to * Math.random());
	}

	/**
	 * @param integer
	 * @return
	 */
	protected String intFormat(int integer) {
		return ("" + (100 + integer)).substring(1);
	}

	/**
	 * @param employees
	 */
	public Employee(int employees) {

		storage = new String[employees][4];
		for (int x = 0; x < employees; x++) {
			storage[x][0] = "" + randomChar() + randomChar();
			storage[x][1] = intFormat(randomInt(1, 30));
			storage[x][2] = intFormat(randomInt(1, 12));
			storage[x][3] = intFormat(randomInt(0, 85));
		}
	}

	/**
	 * @return
	 */
	public String[] getInitials() {

		String[] returnArray = new String[storage.length];

		for (int x = 0; x < storage.length; x++) {
			returnArray[x] = storage[x][0];
		}

		return returnArray;
	}

	public String[][] getStorage() {
		return storage;
	}
}
