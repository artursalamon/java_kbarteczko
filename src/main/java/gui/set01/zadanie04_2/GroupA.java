package gui.set01.zadanie04_2;

/**
 * GroupA
 */
public class GroupA extends Spy {

	protected int from = 0;
	protected int to = 1000000;

	/**
	 * @param password
	 * @param initials
	 * @param from
	 * @param to
	 */
	public GroupA(Password password, String[] initials, int from, int to) {
		super(password, initials);
		this.from = from;
		this.to = to;
	}

	/**
	 *
	 */
	public void run() {

		String passCandidate;
		while (password.isPassUnknown()) {
			for (int x = 0; x < initials.length; x++) {
				for (int y = from; y < to; y++) {
					passCandidate = initials[x]
							+ (("" + (1000000 + y)).substring(1));
					if (password.compare(passCandidate)) {
						password.setPassBroken();
						System.out.println("Hasło złamane: " + passCandidate);
						return;
					}
				}
			}
			break;
		}
	}
}
