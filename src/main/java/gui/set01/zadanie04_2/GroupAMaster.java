package gui.set01.zadanie04_2;

/**
 * GroupAMaster
 */
public class GroupAMaster {

	protected int threadsNum = 0;

	/**
	 * @param threadsNum
	 */
	public GroupAMaster(int threadsNum) {
		this.threadsNum = threadsNum;
	}

	/**
	 * @param password
	 * @param initials
	 */
	public void startGroups(Password password, String[] initials) {

		if (threadsNum == 0) {
			threadsNum = initials.length;
		}
		GroupA[] threads = new GroupA[threadsNum];

		int limit = 1000000;
		int part = limit / threadsNum;
		int from = 0 - part;
		int to = 0;

		int x = 0;
		boolean workFlag = true;
		do {
			from += part;
			if (to + part < limit && x + 1 < threadsNum) {
				to += part - 1;
			} else {
				to = limit;
				workFlag = false;
			}

			threads[x] = new GroupA(password, initials, from, to);
			threads[x].start();
			x++;
		} while (workFlag);
		System.out.println("Uruchomiono " + x + " wątków grupy A");
	}
}
