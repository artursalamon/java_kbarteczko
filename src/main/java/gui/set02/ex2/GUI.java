package gui.set02.ex2;

/**
 * GUI
 */
public class GUI {

	/**
	 * @param string
	 */
	private void print(String string) {
		System.out.println(string);
	}

	/**
	 * @param alert
	 */
	public void showAlert(String alert) {
		print(alert);
	}

	/**
	 *
	 */
	public void showAuth() {
		print("Podaj PIN:");
	}

	/**
	 *
	 */
	public void showMenu() {

		print("Menu");
		print("1. Pokaż saldo");
		print("2. Wypłać");
		print("3. Zakończ");
	}
}
