package gui.set01.zadanie04_2;

/**
 * Spy
 */
abstract public class Spy extends Thread {

	protected String[] initials;
	protected Password password;

	/**
	 * @param password
	 * @param initials
	 */
	public Spy(Password password, String[] initials) {
		setPassword(password);
		setInitials(initials);
	}

	public void setInitials(String[] initials) {
		this.initials = initials;
	}

	public void setPassword(Password password) {
		this.password = password;
	}
}
