package gui.set03.layouts;

import javax.swing.*;
import java.awt.*;

/**
 * LayShow
 *
 * @author s8376
 */
public class LayShow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int CNUM = 5; // liczba komponentów w panelach

		String lmNames[] = {
				"Flow Layout", // opisy rozkładów
				"Flow (left aligned)", "Border Layout", "Grid Layout(1,num)",
				"Grid Layout(num, 1)", "Grid Layout(n,m)",};

		LayoutManager lm[] = {
				new FlowLayout(), // rozkłady
				new FlowLayout(FlowLayout.LEFT), new BorderLayout(),
				new GridLayout(1, 0), new GridLayout(0, 1),
				new GridLayout(2, 0),};

		// argumenty dla rozkladu BorderLayout
		String gborders[] = {"West", "North", "East", "South", "Center"};

		// Kolory paneli
		Color colors[] = {new Color(191, 225, 255), new Color(255, 255, 200),
				new Color(201, 245, 245), new Color(255, 255, 140),
				new Color(161, 224, 224), new Color(255, 255, 200),};

		Icon redDot = new ImageIcon("red.gif"); // ikonka na przycisku

		JFrame frame = new JFrame("Layouts show"); // okno i contentPane

		frame.setLayout(new GridLayout(0, 2));

		for (int i = 0; i < lmNames.length; i++) {
			JPanel p = new JPanel();
			p.setBackground(colors[i]); // kolor tła panelu
			p.setBorder(BorderFactory.createTitledBorder(lmNames[i])); // ramka
			p.setLayout(lm[i]); // ustalenie rozkładu
			Icon icon = null;

			// Możemy sprawdzić z jakim rozkładem mamy do czynienia
			// i odpowiednio do tego coś zrobić (tu: ikonka na przyciskach)
			if (lm[i] instanceof BorderLayout)
				icon = redDot;
			for (int j = 0; j < CNUM; j++) { // dodajemy przyciski do paneli
				JButton b = new JButton("P " + (j + 1), icon);
				p.add(b, gborders[j]);
			}
			frame.add(p);
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
