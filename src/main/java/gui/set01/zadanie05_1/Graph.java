package gui.set01.zadanie05_1;

import javax.swing.*;
import java.awt.*;

/**
 * Graph
 *
 * Rysowanie na komponencie
 * Na komponencie mozna rysowac i wypelniac:
 * proste figury geometryczne,napisy,obrazy (umozliwiaja to metody klasy Graphics);
 * w ciele metody paintComponent() mamy dostep do obiektu wykreslajacego klasy Graphics
 */
public class Graph extends JPanel {

	int dim = 20; //srednica figury
	int x = 75, y = 75; //polozenie
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
		int w = img.getWidth(this); // szerokość obrazka
		int h = img.getHeight(this); // wysokość obrazka
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

		super.paintComponent(g); //wykreslanie komponentu JPanel
		g.setColor(Color.blue); //ustawienie koloru wykreslania
		g.fillOval(x, y, dim, dim); //wypelnianie kola

		// wyrysować obraz z pliku graficznego
		loadImage("files/images/zadanie05_1_1.jpg");
		if (img != null && loaded) {
			g.drawImage(img, getWidth() / 3 * 2, 0, img.getWidth(this), img.getHeight(this),
					this);
		}

		// wyrysować i ewentualnie wypełnić inne figury geometryczne o wymiarach podanych w pikslach
		// linię
		g.setColor(Color.red);
		g.drawLine(25, 25, 175, 25);
		// prostokąt
		g.setColor(Color.black);
		g.drawRect(25, 100, 25, 25);
		g.setColor(Color.green);
		g.fillRect(25, 100, 25, 25);
		// trójkąt
		int[] tabX = {50, 75, 25}, tabY = {50, 25, 25};
		g.setColor(Color.black);
		g.drawPolygon(tabX, tabY, 3);
		g.setColor(Color.cyan);
		g.fillPolygon(tabX, tabY, 3);
		// wycinek koła
		g.setColor(Color.gray);
		g.fillArc(150, 150, 50, 50, 0, 255);
		// wyrysować określony napis w odpowiednim położeniu
		g.setColor(Color.black);
		g.drawString("Hello world!", 26, 176);
		g.setColor(Color.orange);
		g.drawString("Hello world!", 25, 175);
	}

	/**
	 * @return
	 */
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}
}
