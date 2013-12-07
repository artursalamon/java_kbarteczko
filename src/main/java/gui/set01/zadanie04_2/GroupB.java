package gui.set01.zadanie04_2;

import javax.swing.*;

/**
 * GroupB
 */
public class GroupB extends Spy {

	/**
	 * @param password
	 * @param initials
	 */
	public GroupB(Password password, String[] initials) {
		super(password, initials);
	}

	/**
	 *
	 */
	public void run() {

		String passCandidate, input;

		String message = "Nasze propozycje haseł";

		while (password.isPassUnknown()) {
			passCandidate = "";
			input = JOptionPane.showInputDialog(message);

			if (input == null) {
				return;
			} else if (password.compare(input)) {
				password.setPassBroken();
				System.out.println("Hasło złamane: " + passCandidate);
				return;
			} else {
				System.out.println("nie udało się");
			}
		}
	}
}
