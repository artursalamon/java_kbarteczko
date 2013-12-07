package gui.set01.zadanie05_2;

import javax.swing.*;
import java.awt.*;

/**
 * Graph
 */
public class Graph extends JPanel {

	Image img;
	boolean loaded = false;

	/**
	 * @param imgFileName
	 */
	private void loadImage(String imgFileName) {

		img = Toolkit.getDefaultToolkit().getImage(imgFileName);
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 1);

		try {
			mt.waitForID(1);
		} catch (InterruptedException exc) {
		}

		int w = img.getWidth(this);
		int h = img.getHeight(this);

		if (w != -1 && w != 0 && h != -1 && h != 0) {
			loaded = true;
			setPreferredSize(new Dimension(w, h));
		} else
			setPreferredSize(new Dimension(200, 200));
	}

	/**
	 * @param g
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		loadImage("files/images/zadanie05_1_1.jpg");
		if (img != null && loaded) {
			g.drawImage(img, 0, 0, getWidth() / 2, getHeight() / 2,
					this);
		}

		g.setColor(Color.blue);
		g.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 4, getHeight() / 4);

		// wyrysować i ewentualnie wypełnić inne figury geometryczne o wymiarach podanych w pikslach
		// linię
		g.setColor(Color.red);
		g.drawLine(getWidth() / 8, (getHeight() / 8) * 7, (getWidth() / 8) * 7,
				(getHeight() / 8) * 7);

		// prostokąt
		g.setColor(Color.green);
		g.drawRect((getWidth() / 4) * 3, getHeight() / 4, getWidth() / 4,
				getHeight() / 4);

		// trójkąt
		g.setColor(Color.cyan);
		g.fillPolygon(new int[]{getWidth() / 6, (getWidth() / 6) * 2, (getWidth() / 6) * 3}, new int[]{getHeight() / 3, (getHeight() / 3) * 2, getHeight() / 3}, 3);

		// wycinek koła
		g.setColor(Color.gray);
		g.fillArc((getWidth() / 8) * 5, (getHeight() / 6) * 4, getWidth() / 8,
				getHeight() / 8, 0, 255);

		// wyrysować określony napis w odpowiednim położeniu
		g.setColor(Color.black);
		g.drawString("Hello world!", getWidth() / 4 + 1,
				(getHeight() / 4) * 3 + 1);
		g.setColor(Color.orange);
		g.drawString("Hello world!", getWidth() / 4, (getHeight() / 4) * 3);
	}

	/**
	 * @return
	 */
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}
}
