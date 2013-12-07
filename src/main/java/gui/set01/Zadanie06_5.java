package gui.set01;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Zadanie 2. Kombinowanie rozkładów (max. 6p)
 *
 * Napisać aplikację, w oknie której znajdzie się edytor tekstowy (JTextArea)
 * oraz umieszone nad nim trzy przyciski wyrównane do prawej strony okna.
 * Z napisami A, B, C w piśmie "wytłuszczona kursywa". Przy zmianach rozmiaru okna
 * mają zmieniać się rozmiary edytora, a przyciski mają zachowywać swoje rozmiary
 * i położenie (tuż nad edytorem - wyrównane do prawej strony)
 *
 * @author s8376
 */
public class Zadanie06_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// okno
		JFrame frame = new JFrame();
		frame.setTitle("Terminal");
		frame.setLocation(250, 250);
		frame.setPreferredSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

		frame.setLayout(new MigLayout("", "[grow][][][right]"));

		// A, B, C w piśmie "wytłuszczona kursywa".
		Font font = new Font("Dialog", Font.BOLD + Font.ITALIC, 14);

		// przyciski
		JButton buttonA = new JButton("A");
		buttonA.setFont(font);
		frame.add(buttonA, "skip 1");

		JButton buttonB = new JButton("B");
		buttonB.setFont(font);
		frame.add(buttonB, "right align");

		JButton buttonC = new JButton("C");
		buttonC.setFont(font);
		frame.add(buttonC, "right align, wrap");

		// textarea
		JTextArea textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(9999, 9999));
		textArea.setFont(new Font(Font.MONOSPACED, 0, 12));
		textArea.setForeground(Color.white);
		textArea.setBackground(Color.black);
		JScrollPane scroll = new JScrollPane(textArea);
		frame.add(scroll, "grow, span");

		// pakowanie i wyswietlanie okienka
		frame.pack();
		frame.setVisible(true);
	}
}
