package gui.set01.zadanie05_4;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract
 */
abstract public class Abstract extends JPanel implements Runnable {

	/**
	 * Kierunki przesuwania sie obiektu
	 *
	 * n-orth, s-outh, w-est, e-ast
	 */
	char directionInit, directionCurrent, directionLast;
	/**
	 * Granice przesuniecia w kierunkach
	 */
	int eGauge, sGauge;
	char[] directions;
	/**
	 * srednica figury
	 */
	int dim = 20;
	/**
	 * polozenie poczatkowe
	 */
	int x = 0, y = 0;
	/**
	 * dlugosc kroku w kierunku x i y
	 */
	int dx = 3, dy = 5;
	/**
	 * opoznienie odswiezania
	 */
	int delay = 40;
	/**
	 * Kolor pendzla
	 */
	Color color = Color.blue;

	{
		setBounds(0, 0, 200, 200);
		setOpaque(false);
	}

	/**
	 * @param directions
	 */
	public Abstract(char[] directions) {
		this.directions = directions;
	}

	/**
	 * @param g
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.setColor(color); // ustawienie koloru wykreslania
		g.fillOval(x, y, dim, dim); // wypełnienie kola kolorem
	}

	/**
	 * @return
	 */
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

	/**
	 *
	 */
	public void run() {

		int lastX = x, lastY = y;

		boolean directionFlag = true;

		while (true) {
			for (int directionKey = 0; directionKey < directions.length; directionKey++) {
				directionFlag = true;
				while (directionFlag) {

					if (x + dim > getWidth() && y + dim > getHeight()) {
						return;
					}

					if (directions[directionKey] == 'n') {
						y -= dy;
						if (y - dy < 0) {
							lastY = y;
							directionFlag = false;
						}
					} else if (directions[directionKey] == 'e') {
						x += dx;
						if (x + dim > eGauge || x + dim > lastX + eGauge) {
							lastX = x;
							directionFlag = false;
						}
					} else if (directions[directionKey] == 's') {
						y += dy;
						if (y + dim > sGauge || y + dim > lastY + sGauge) {
							lastY = y;
							directionFlag = false;
						}
					} else if (directions[directionKey] == 'w') {
						x -= dx;
						if (x - dx < 0) {
							lastX = x;
							directionFlag = false;
						}
					}

					repaint();

					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
					}
				}
			}
		}
	}
}
