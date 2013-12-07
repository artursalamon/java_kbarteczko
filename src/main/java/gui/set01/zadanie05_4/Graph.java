package gui.set01.zadanie05_4;

import javax.swing.*;
import java.awt.*;

/**
 * Graph
 */
public class Graph extends JPanel {

	int dim = 20;
	int x = 75, y = 75;
	int dx = 3, dy = 5;
	int delay = 40;
	Color color;

	/**
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fillOval(x, y, dim, dim);
	}

	/**
	 * @return
	 */
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}
