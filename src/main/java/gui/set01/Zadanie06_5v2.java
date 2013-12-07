package gui.set01;

import javax.swing.*;
import java.awt.*;

/**
 * Zadanie 2. Kombinowanie rozkładów (max. 10p)
 *
 * Napisać aplikację, w oknie której znajdzie się edytor tekstowy (JTextArea)
 * oraz umieszone przyciski oraz pola tekstowe
 *
 * Uwaga:
 *
 * przyciski A1-A3 są wyrównane w lewo i nie zmieniają swoich rozmiarów,
 * przyciski B1-B3 są wyrównane w prawo i nie zmieniają swoich rozmiarów,
 * przyciski numeryczne nie zmieniają swoich rozmiarów,
 * pola tekstowe ( JTextField ) mogą zmieniać swoje rozmiary i położenie
 *
 * @author s8376
 */
public class Zadanie06_5v2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//(02:57:22 PM) <font size="3">Jacek Głogosz: całość na gridlayout (02:57:30 PM) Jacek Głogosz: u góry 2x flowlayout (02:57:41 PM) Jacek Głogosz: na dole po lewej gridlayout (02:57:54 PM) Jacek Głogosz: (całośc na gridbag layout, a nie grid) (02:57:34 PM) Filip: uuuuuu (02:57:41 PM) Filip: zmienia to postać rzeczy :D (02:58:54 PM) Jacek Głogosz: i po prawej na dole, też gridlayout (02:59:03 PM) Jacek Głogosz: wszystko oczywiście ma dodatkowe ustawienia :)</font>

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 400));
		frame.setLocation(300, 200);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// panel gorny
		JPanel topLeft = new JPanel();

		topLeft.setBackground(Color.GREEN);

		topLeft.setLayout(new FlowLayout(FlowLayout.LEFT));
		topLeft.add(new JButton("A1"));
		topLeft.add(new JButton("A2"));
		topLeft.add(new JButton("A3"));
		c.gridx = 1;
		c.gridy = 1;
		frame.add(topLeft, c);

		JPanel topRight = new JPanel();

		topRight.setBackground(Color.RED);

		topRight.setLayout(new FlowLayout(FlowLayout.RIGHT));
		topRight.add(new JButton("B1"));
		topRight.add(new JButton("B2"));
		topRight.add(new JButton("B3"));
		c.gridx = 2;
		c.gridy = 1;
		frame.add(topRight, c);

		// panel srodkowy
		JPanel middle = new JPanel();
		JTextArea textarea = new JTextArea("To jest JTextArea");
		textarea.setPreferredSize(new Dimension(200, 200));
		middle.add(textarea);
		middle.setBackground(Color.gray);
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 2;
		frame.add(middle, c);

		// panel dolny
		JPanel bottomLeft = new JPanel();
		bottomLeft.setBackground(Color.pink);
		bottomLeft.setLayout(new GridLayout(0, 3));
		for (int x = 0; x < 9; x++) {
			bottomLeft.add(new JButton("" + (x + 1)));
		}
		c.gridx = 1;
		c.gridy = 3;
		frame.add(bottomLeft, c);

		JPanel bottomRight = new JPanel();
		bottomRight.setBackground(Color.blue);
		bottomRight.setLayout(new BoxLayout(bottomRight, BoxLayout.Y_AXIS));
		bottomRight.add(new JTextField("To jest JTextField"));
		bottomRight.add(new JTextField("To jest JTextField"));
		bottomRight.add(new JTextField("To jest JTextField"));
		c.gridx = 2;
		c.gridy = 3;
		frame.add(bottomRight, c);

		frame.pack();
		frame.setVisible(true);
	}
}
