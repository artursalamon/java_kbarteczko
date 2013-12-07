package gui.set03.visual;

import javax.swing.*;
import java.awt.*;

/**
 * Intro
 */
class Intro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// ta klasa (potrzebne do niezależnego pobierania zasobów, takich jak obrazki)
		Class<Intro> klas = Intro.class;
		// Ikony z plików graficznych zawartych w katalogu images aplikacji
		Icon[] icon = {new ImageIcon(klas.getResource("images/intro1.jpg")),
				new ImageIcon(klas.getResource("images/intro2.jpg")),
				new ImageIcon(klas.getResource("images/intro3.jpg")),};
		String[] opis = {"Ocean", "Pool", "Town"}; // tekst na przyciskach
		JFrame frame = new JFrame("First Swing"); // utworzenie okna ramowego z podanym tytułem
		frame.setLayout(new FlowLayout()); // ustalenie rozkładu jego contentPane

		for (int i = 0; i < icon.length; i++) {
			// tworzenie kolejnych przycisków
			JButton b = new JButton(opis[i], icon[i]);
			// Ustalenie pisma i koloru napisu na przyciskach
			b.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
			b.setForeground(Color.blue);
			//  Ustalenie pozycji tekstu na przycisku względem ikony
			b.setVerticalTextPosition(SwingConstants.BOTTOM);
			b.setHorizontalTextPosition(SwingConstants.CENTER);
			frame.add(b); // dodanie przycisku do contentPane okna
		}

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack(); // spakowanie okna
		// (wymiary okna takie by dokładnie zmieścić komponenty)
		frame.setLocationRelativeTo(null); // centrowanie okna w obszarze pulpitu
		frame.setVisible(true); // pokazanie okna
	}
}
