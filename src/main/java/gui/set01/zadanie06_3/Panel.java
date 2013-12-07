package gui.set01.zadanie06_3;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Panel
 *
 * @author s8376
 */
public class Panel extends JPanel implements Runnable {

	int index = 0, maxIndex = 0;
	Image[] images;
	Image img;

	/**
	 * @param path
	 * @param list
	 */
	public Panel(String path, ArrayList<File> list) {

		super();

		maxIndex = list.size();
		images = new Image[maxIndex];

		int x = 0;
		for (File file : list) {
			loadImage(path + file.getName(), x);
			x++;
		}
	}

	/**
	 * @param imgFileName
	 * @param index
	 */
	private void loadImage(String imgFileName, int index) {

		img = Toolkit.getDefaultToolkit().getImage(imgFileName);
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 1);
		try {
			mt.waitForID(1);
		} catch (InterruptedException exc) {
		}

		images[index] = img;
	}

	/**
	 * @param g
	 */
	public void paintComponent(Graphics g) {

		if (images[index] != null) {
			g.drawImage(images[index], 0, 0, 200, 130, this);
		}

		if (index + 1 >= maxIndex) {
			index = 0;
		} else {
			index++;
		}
	}

	/**
	 *
	 */
	public void run() {

		while (true) {
			try {
				Thread.sleep(2000);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
