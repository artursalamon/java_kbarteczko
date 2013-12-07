package gui.set01.zadanie04_1;

/**
 * MyThread
 */
public class MyThread extends Thread {

	protected boolean stopThisMadness = false;
	protected Integer x = 0;
	protected boolean sleep = false;
	protected boolean wait = false;

	/**
	 *
	 */
	public void setSleep() {
		sleep = true;
	}

	/**
	 *
	 */
	public void setWait() {
		wait = true;
	}

	/**
	 *
	 */
	public void stopThis() {
		stopThisMadness = true;
	}

	/**
	 *
	 */
	public void run() {

		while (true) {
			if (stopThisMadness) {
				return;
			}

			try {
				if (sleep) {
					sleep(3600);
				}
			} catch (InterruptedException e) {
				sleep = false;
			}

			try {
				synchronized (this) {
					while (wait) {
						wait();
					}
				}
			} catch (InterruptedException e) {
				synchronized (this) {
					wait = false;
					notify();
				}
			}

			System.out.println("echo " + (++x));
			try {
				sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 *
	 */
	public void wakeUp() {
		synchronized (this) {
			wait = false;
			notify();
		}
	}
}
