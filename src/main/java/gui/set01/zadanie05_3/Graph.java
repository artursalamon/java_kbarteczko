package gui.set01.zadanie05_3;

import javax.swing.*;
import java.awt.*;

/**
 * Graph
 */
public class Graph extends JPanel {

	Image img;
	boolean loaded = false;
	int outerBorder, border;

	/**
	 * @param fileName
	 */
	public Graph(String fileName) {

		loadImage(fileName);

		if (img != null && loaded) {
			outerBorder = img.getWidth(this) / 10;
			border = img.getHeight(this) / 4;

			if (outerBorder < 1) {
				outerBorder = 1;
			}
			if (border < 1) {
				border = 1;
			}

			setPreferredSize(new Dimension(img.getWidth(this)
					+ (border + outerBorder) * 2, img.getHeight(this)
					+ (border + outerBorder) * 2));
		}
	}

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

		int w = img.getWidth(this); // szerokość obrazka
		int h = img.getHeight(this); // wysokość obrazka

		if (w != -1 && w != 0 && h != -1 && h != 0) {
			loaded = true;
		} else {
			setPreferredSize(new Dimension(200, 200));
		}
	}

	/**
	 * @param g
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		if (img != null && loaded) {
			// ramka
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());

			g.setColor(Color.white);
			g.fillRect(outerBorder, outerBorder, getWidth() - outerBorder * 2,
					getHeight() - outerBorder * 2);

			g.drawImage(img, outerBorder + border, outerBorder + border, img
					.getWidth(this), img.getHeight(this), this);

			// napis
			String imageTitle = "Hello world!";

			int imageTitleX, imageTitleY;
			imageTitleX = this.getWidth() / 2
					- g.getFontMetrics().stringWidth(imageTitle) / 2;
			imageTitleY = img.getHeight(this) + outerBorder + border + (border / 2);

			g.setFont(new Font("Sanserif", Font.ITALIC, 13));
			g.setColor(Color.gray);
			g.drawString(imageTitle, imageTitleX + 1, imageTitleY + 1);
			g.setColor(Color.black);
			g.drawString(imageTitle, imageTitleX, imageTitleY);
		}
	}
}
