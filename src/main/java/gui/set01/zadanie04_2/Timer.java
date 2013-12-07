package gui.set01.zadanie04_2;

/**
 * Timer
 */
public class Timer extends Thread {

	protected int counter;
	protected Password password;
	protected boolean running = true;

	/**
	 * @param password
	 */
	public Timer(Password password) {
		this.password = password;
	}

	/**
	 *
	 */
	public void stopTimer() {
		this.running = false;
	}

	/**
	 *
	 */
	public void run() {

		while (running && !password.passBroken) {
			try {
				counter++;
				System.out.println("Czas: " + (counter / 60) + ":"
						+ (counter % 60));
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
