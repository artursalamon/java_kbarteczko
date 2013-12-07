package gui.set01.zadanie04_2;

/**
 * PassGen
 */
public class PassGen {

	/**
	 * @param storage
	 * @return
	 */
	public String generate(String[][] storage) {

		int randomIndex = (int) (storage.length * Math.random());
		return storage[randomIndex][0] + storage[randomIndex][1]
				+ storage[randomIndex][2] + storage[randomIndex][3];
	}
}
