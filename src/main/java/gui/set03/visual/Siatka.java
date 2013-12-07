package gui.set03.visual;

import javax.swing.*;
import java.awt.*;

/**
 * ObszarRysunku
 */
class ObszarRysunku extends JComponent {

	/**
	 * ObszarRysunku
	 *
	 * @param w
	 * @param h
	 */
	public ObszarRysunku(int w, int h) {

		Dimension d = new Dimension(w, h);
		setMinimumSize(d);
		setPreferredSize(new Dimension(d));
		setMaximumSize(d);
	}

	/**
	 * paintComponent
	 *
	 * @param g
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		g.setColor(Color.blue);
		g.drawRect(0, 0, w - 1, h - 1);
		int hor = 10, vert = 10;
		while (hor < h) {
			g.drawLine(1, hor, w - 1, hor);
			hor += 10;
		}

		while (vert < w) {
			g.drawLine(vert, 1, vert, h - 1);
			vert += 10;
		}
	}
}

/**
 * Siatka
 */
public class Siatka extends JFrame {

	/**
	 *
	 */
	public Siatka() {

		super("Siatka");
		add(new ObszarRysunku(200, 200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Siatka();
	}
}
