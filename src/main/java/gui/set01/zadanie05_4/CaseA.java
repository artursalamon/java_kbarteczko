package gui.set01.zadanie05_4;

import java.awt.*;

/**
 * CaseA
 */
public class CaseA extends Abstract {

	{
		color = Color.blue;

		x = 75;
		y = 75;
	}

	/**
	 *
	 */
	public CaseA() {
		super(new char[]{});
	}

	/**
	 *
	 */
	public void run() {

		while (true) {
			// odbicie
			if (x + dim > getWidth() || x < 0)
				dx = -dx;
			if (y + dim > getHeight() || y < 0)
				dy = -dy;
			// przesuniecie wzdluz x i y
			x += dx;
			y += dy;

			repaint(); //wstawienie paintComponent() do watku zdarzeniowego

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
			}
		}
	}
}
