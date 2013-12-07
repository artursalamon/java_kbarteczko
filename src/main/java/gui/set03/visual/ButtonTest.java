package gui.set03.visual;

import javax.swing.*;
import java.awt.*;

/**
 * CustButton
 */
class CustButton extends JButton {

	/**
	 * @param txt
	 */
	public CustButton(String txt) {
		super(txt);
		setFont(new Font("Dialog", Font.PLAIN, 24));
	}

	/**
	 * @param g
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		int w = getWidth(); // aktualna szerokość ...
		int h = getHeight(); // i wysokość komponentu
		g.setColor(Color.red); // ustalenie koloru rysunku
		// rysowanie kwadracików
		g.fillRect(0, 0, 10, 10);
		g.fillRect(w - 10, 0, 10, 10);
		g.fillRect(0, h - 10, 10, 10);
		g.fillRect(w - 10, h - 10, 10, 10);
	}
}

/**
 * ButtonTest
 */
public class ButtonTest extends JFrame {

	/**
	 *
	 */
	public ButtonTest() {

		CustButton mb = new CustButton("To jest przycisk");
		add(mb);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // domyślna operacja zamknięcia okna: koniec pracy
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		new ButtonTest();
	}
}
