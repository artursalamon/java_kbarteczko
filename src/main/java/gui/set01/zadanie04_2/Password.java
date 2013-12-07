package gui.set01.zadanie04_2;

/**
 * Password
 */
public class Password {

	protected boolean passBroken = false;
	protected String password;

	/**
	 * @param password
	 * @return
	 */
	public boolean compare(String password) {
		return this.password.equals(password) ? true : false;
	}

	/**
	 * @return
	 */
	public boolean isPassUnknown() {
		return !passBroken;
	}

	/**
	 * @param storage
	 */
	public void generate(String[][] storage) {

		int randomIndex = (int) (storage.length * Math.random());
		password = storage[randomIndex][0] + storage[randomIndex][1]
				+ storage[randomIndex][2] + storage[randomIndex][3];
	}

	public String getPassword() {
		return password;
	}

	public void setPassBroken() {
		passBroken = true;
	}
}
